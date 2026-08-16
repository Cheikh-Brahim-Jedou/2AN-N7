using LinearAlgebra
include("../src/newton.jl")
include("../src/regions_de_confiance.jl")
"""

Approximation d'une solution au problème 

    min f(x), x ∈ Rⁿ, sous la contrainte c(x) = 0,

par l'algorithme du lagrangien augmenté.

# Syntaxe

    x_sol, f_sol, flag, nb_iters, μs, λs = lagrangien_augmente(f, ∇f, ∇²f, c, ∇c, ∇²c, x0; kwargs...)

# Entrées

    - f      : (Function) la ftion à minimiser
    - ∇f     : (Function) le gradient de f
    - ∇²f    : (Function) la hessienne de f
    - c      : (Function) la c à valeur dans R
    - ∇c     : (Function) le gradient de c
    - ∇²c    : (Function) la hessienne de c
    - x0     : (Vector{<:Real}) itéré initial
    - kwargs : les options sous formes d'arguments "keywords"
        • max_iter  : (Int) le nombre maximal d'iterations (optionnel, par défaut 1000)
        • tol_abs   : (Real) la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel   : (Real) la tolérence relative (optionnel, par défaut 1e-8)
        • λ0        : (Real) le multiplicateur de lagrange associé à c initial (optionnel, par défaut 2)
        • μ0        : (Real) le facteur initial de pénalité de la c (optionnel, par défaut 10)
        • τ         : (Real) le facteur d'accroissement de μ (optionnel, par défaut 2)
        • algo_noc  : (String) l'algorithme sans c à utiliser (optionnel, par défaut "rc-gct")
            * "newton"    : pour l'algorithme de Newton
            * "rc-cauchy" : pour les régions de confiance avec pas de Cauchy
            * "rc-gct"    : pour les régions de confiance avec gradient conjugué tronqué

# Sorties

    - x_sol    : (Vector{<:Real}) une approximation de la solution du problème
    - f_sol    : (Real) f(x_sol)
    - flag     : (Int) indique le critère sur lequel le programme s'est arrêté
        • 0 : convergence
        • 1 : nombre maximal d'itération dépassé
    - nb_iters : (Int) le nombre d'itérations faites par le programme
    - μs       : (Vector{<:Real}) tableau des valeurs prises par μk au cours de l'exécution
    - λs       : (Vector{<:Real}) tableau des valeurs prises par λk au cours de l'exécution

# Exemple d'appel

    f(x)=100*(x[2]-x[1]^2)^2+(1-x[1])^2
    ∇f(x)=[-400*x[1]*(x[2]-x[1]^2)-2*(1-x[1]) ; 200*(x[2]-x[1]^2)]
    ∇²f(x)=[-400*(x[2]-3*x[1]^2)+2  -400*x[1];-400*x[1]  200]
    c(x) =  x[1]^2 + x[2]^2 - 1.5
    ∇c(x) = 2*x
    ∇²c(x) = [2 0; 0 2]
    x0 = [1; 0]
    x_sol, _ = lagrangien_augmente(f, ∇f, ∇²f, c, ∇c, ∇²c, x0, algo_noc="rc-gct")

"""
function lagrangien_augmente(f::Function, ∇f::Function, ∇²f::Function, 
        c::Function, ∇c::Function, ∇²c::Function, x0::Vector{<:Real}; 
        max_iter::Int=1000, tol_abs::Real=1e-10, tol_rel::Real=1e-8,
        λ0::Real=2, μ0::Real=10, τ::Real=2, algo_noc::String="rc-gct")
    
    
    
    # --- Paramètres  ---(les caracteres sont pris directement du sujet de projet)
    β = 0.9
    η_hat = 0.1258925
    α = 0.1
    ε0 = 1/μ0
    η0 = η_hat / (μ0^α)
    

    # --- Initialisations --- ( les caracteres  sont pris directement du sujet de projet )
    xk = Float64.(copy(x0))
    λk = Float64(λ0)
    μk = Float64(μ0)
    εk = ε0
    ηk = η0

    μs = [μk]
    λs = [λk]
    
    # on ajoute l'historique pour la vizualisation dans le notebook
    hist_c = [abs(c(xk))]                    
    hist_grad_L = [norm(∇f(xk) + λk*∇c(xk))] 
    hist_x = [copy(xk)]  
    
    k = 0
    flag = -1

    # 

    while k < max_iter
        # 1. Définition du sous-problème : min L_A(x, λk, μk)
        # L_A(x) = f(x) + λk*c(x) + (μk/2)*c(x)^2
        f_sub(x) = f(x) + λk * c(x) + (μk / 2) * (c(x)^2)
        grad_f_sub(x) = ∇f(x) + (λk + μk * c(x)) * ∇c(x)
        hess_f_sub(x) = ∇²f(x) + (λk + μk * c(x)) * ∇²c(x) + μk * ∇c(x) * ∇c(x)'

        # 2. Résolution du sous-problème sans contraintes
        if algo_noc == "newton"
            xk_next, _, _, _, _ = newton(f_sub, grad_f_sub, hess_f_sub, xk; tol_abs=εk, tol_rel=0)
        elseif algo_noc == "rc-cauchy"
            xk_next, _, _, _, _ = regions_de_confiance(f_sub, grad_f_sub, hess_f_sub, xk; tol_abs=εk, tol_rel=0, algo_pas="cauchy")
        else # "rc-gct"
            xk_next, _, _, _, _ = regions_de_confiance(f_sub, grad_f_sub, hess_f_sub, xk; tol_abs=εk, tol_rel=0, algo_pas="gct")
        end

        # 3. Mises à jour (Algorithme 4)
        if abs(c(xk_next)) <= ηk
            # Succès : Mise à jour du multiplicateur
            λk = λk + μk * c(xk_next)
            εk = εk / μk
            ηk = ηk / (μk^β)
        else
            # Échec : Augmentation de la pénalité
            μk = τ * μk
            εk = ε0 / μk
            ηk = η_hat / (μk^α)
        end

        xk = xk_next
        k += 1
        push!(μs, μk)
        push!(λs, λk)
        push!(hist_c, abs(c(xk)))
        push!(hist_grad_L, norm(∇f(xk) + λk*∇c(xk)))
        push!(hist_x, copy(xk))

        # 4. Critères d'arrêt globaux (Conditions de KKT)
        # Convergence si ||∇L(x, λ)|| <= tol et ||c(x)|| <= tol
        grad_L = ∇f(xk) + λk * ∇c(xk)
        if norm(grad_L) <= max(tol_rel * norm(∇f(x0)), tol_abs) && abs(c(xk)) <= max(tol_rel * abs(c(x0)), tol_abs)
            flag = 0
            break
        end
    end

    if k >= max_iter && flag == -1
        flag = 1
    end

    return xk, f(xk), flag, k, μs, λs ,hist_c, hist_grad_L, hist_x
end
    
  