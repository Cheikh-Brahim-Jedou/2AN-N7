using LinearAlgebra
"""
Approximation de la solution du problème 

    min qₖ(s) = s'gₖ + 1/2 s' Hₖ s

        sous les contraintes s = -t gₖ, t > 0, ‖s‖ ≤ Δₖ

# Syntaxe

    s = cauchy(g, H, Δ; kwargs...)

# Entrées

    - g : (Vector{<:Real}) le vecteur gₖ
    - H : (Union{Matrix{<:Real}, UniformScaling{Bool}}) la matrice Hₖ
    - Δ : (Real) le scalaire Δₖ
    - kwargs  : les options sous formes d'arguments "keywords", c'est-à-dire des arguments nommés
        • tol_abs  : la tolérence absolue (optionnel, par défaut 1e-10)

# Sorties

    - s : (Vector{<:Real}) la solution du problème

# Exemple d'appel

    g = [0; 0]
    H = [7 0 ; 0 2]
    Δ = 1
    s = cauchy(g, H, Δ)

"""
function cauchy(g::Vector{<:Real}, H::Union{Matrix{<:Real}, UniformScaling{Bool}}, Δ::Real; tol_abs::Real = 1e-10)

    g_norm = norm(g)
    
    if g_norm < tol_abs
        return s = zeros(eltype(g), length(g))
    end
    
    b = -g_norm^2
    a = dot(g,H*g)
    t_limite = Δ / g_norm
    
    if a <= tol_abs 
        t_pas = t_limite
    else 
        t_pas = -b / a
       
    end 
    t_final = min(t_pas , t_limite)
    
    return s = -t_final*g

end