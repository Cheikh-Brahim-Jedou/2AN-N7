using LinearAlgebra
include("../src/cauchy.jl")
include("../src/gct.jl")
"""
Approximation de la solution du problème min f(x), x ∈ Rⁿ.

L'algorithme des régions de confiance résout à chaque itération, un modèle quadratique
de la fonction f dans une boule (appelée la région de confiance) de centre l'itéré 
courant. Cette minimisation se fait soit par un pas de Cauchy ou par l'algorithme 
du gradient conjugué tronqué.

# Syntaxe

    x_sol, f_sol, flag, nb_iters, xs = regions_de_confiance(f, ∇f, ∇²f, x0; kwargs...)

# Entrées

    - f       : (Function) la fonction à minimiser
    - ∇f   : (Function) le gradient de la fonction f
    - ∇²f   : (Function) la hessienne de la fonction f
    - x0      : (Vector{<:Real}) itéré initial
    - kwargs  : les options sous formes d'arguments "keywords"
        • max_iter      : (Int) le nombre maximal d'iterations (optionnel, par défaut 5000)
        • tol_abs       : (Real) la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel       : (Real) la tolérence relative (optionnel, par défaut 1e-8)
        • δ             : (Real) pour considérer ou non les tests de stagnation (optionnel, par défaut 1)
        • Δ0            : (Real) le rayon initial de la région de confiance (optionnel, par défaut 2)
        • Δmax          : (Real) le rayon maximal de la région de confiance (optionnel, par défaut 10)
        • γ1, γ2        : (Real) les facteurs de mise à jour de la région de confiance (optionnel, par défaut 0.5 et 2)
        • η1, η2        : (Real) les seuils pour la mise à jour de la région de confiance (optionnel, par défaut 0.25 et 0.75)
        • algo_pas      : (String) l'algorithme de calcul du pas - "cauchy" ou "gct" (optionnel, par défaut "gct")
        • max_iter_gct  : (Int) le nombre maximal d'iterations du GCT (optionnel, par défaut 2*length(x0))

# Sorties

    - x_sol : (Vector{<:Real}) une approximation de la solution du problème
    - f_sol : (Real) f(x_sol)
    - flag  : (Int) indique le critère sur lequel le programme s'est arrêté
        • 0  : convergence
        • 1  : stagnation du xk
        • 2  : stagnation du f
        • 3  : nombre maximal d'itération dépassé
    - nb_iters : (Int) le nombre d'itérations faites par le programme
    - xs    : (Vector{Vector{<:Real}}) les itérés

# Exemple d'appel

    f(x)=100*(x[2]-x[1]^2)^2+(1-x[1])^2
    ∇f(x)=[-400*x[1]*(x[2]-x[1]^2)-2*(1-x[1]) ; 200*(x[2]-x[1]^2)]
    ∇²f(x)=[-400*(x[2]-3*x[1]^2)+2  -400*x[1];-400*x[1]  200]
    x0 = [1; 0]
    x_sol, f_sol, flag, nb_iters, xs = regions_de_confiance(f, ∇f, ∇²f, x0, algo_pas="gct")

"""
# Créer une version modifiée qui retourne l'historique
function regions_de_confiance(f::Function, ∇f::Function, ∇²f::Function, x0::Vector{<:Real};
    max_iter::Int=5000, tol_abs::Real=1e-10, tol_rel::Real=1e-8, δ::Real=1, 
    Δ0::Real=2, Δmax::Real=10, γ1::Real=0.5, γ2::Real=2, η1::Real=0.25, η2::Real=0.75, 
    algo_pas::String="cauchy", max_iter_gct::Int = 2*length(x0))
    
    # Initialisation
    x = Float64.(copy(x0))
    xs = [copy(x)]
    Δ = Float64(Δ0)
    g0_norm = norm(∇f(x))
    f_x = f(x)
    
    
    historique_f = [f_x]
    historique_delta = [Δ]
    historique_rho = []
    historique_accepte = []  # true si pas accepté, false sinon
    
    flag = -1
    k = 0
    
    if g0_norm ≤ max(tol_rel * g0_norm, tol_abs)
        return x, f_x, 0, 0, xs, historique_f, historique_delta, historique_rho, historique_accepte
    end

    while k < max_iter
        g = ∇f(x)
        H = ∇²f(x)
        
        if algo_pas == "cauchy"
            s = cauchy(g, H, Δ)
        elseif algo_pas == "gct"
            s = gct(g, H, Δ, max_iter=max_iter_gct)
        else
            error("algo_pas doit être 'cauchy' ou 'gct'")
        end
        
        # Calcul du ratio ρ
        f_current = f_x
        f_new = f(x + s)
        m_current = f_current
        m_new = f_current + dot(g, s) + 0.5 * dot(s, H*s)
        
        if abs(m_current - m_new) < eps()
            ρ = 1.0
        else
            ρ = (f_current - f_new) / (m_current - m_new)
        end
        
        
        push!(historique_rho, ρ)
        
        # Mise à jour
        pas_accepte = false
        if ρ ≥ η1
            x .= x + s
            f_x = f_new
            push!(xs, copy(x))
            pas_accepte = true
            
            if norm(∇f(x)) ≤ max(tol_rel * g0_norm, tol_abs)
                flag = 0
                push!(historique_f, f_x)
                push!(historique_delta, Δ)
                push!(historique_accepte, pas_accepte)
                k += 1
                break
            end
        else
            f_x = f_current
        end
        
        # AJOUT : Stocker acceptation
        push!(historique_accepte, pas_accepte)
        
        # Mise à jour du rayon
        if ρ ≥ η2
            Δ = min(γ2 * Δ, Δmax)
        elseif ρ ≥ η1
            Δ = Δ
        else
            Δ = γ1 * Δ
        end
        
        # AJOUT : Stocker nouvelle valeur
        if pas_accepte
            push!(historique_f, f_x)
        else
            push!(historique_f, historique_f[end])  # Répéter la valeur précédente
        end
        push!(historique_delta, Δ)
        
        # Stagnation
        k += 1
        if k > 1 && length(xs) >= 2
            if norm(xs[end] - xs[end-1]) ≤ δ * max(tol_rel * norm(xs[end-1]), tol_abs)
                flag = 1
                break
            end
            if k > 2 && abs(f(xs[end]) - f(xs[end-1])) ≤ δ * max(tol_rel * abs(f(xs[end-1])), tol_abs)
                flag = 2
                break
            end
        end
    end
    
    if k ≥ max_iter && flag == -1
        flag = 3
    end
    
    return x, f_x, flag, k, xs, historique_f, historique_delta, historique_rho, historique_accepte
end
