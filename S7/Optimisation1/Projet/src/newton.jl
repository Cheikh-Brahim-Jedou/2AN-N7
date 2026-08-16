using LinearAlgebra
"""
Approximation d'une solution du problème min f(x), x ∈ Rⁿ, en utilisant l'algorithme de Newton.

# Syntaxe

   x_sol, f_sol, flag, nb_iters, xs = newton(f, ∇f, ∇²f, x0; kwargs...)

# Entrées

   - f       : (Function) la fonction à minimiser
   - ∇f   : (Function) le gradient de la fonction f
   - ∇²f   : (Function) la Hessienne de la fonction f
   - x0      : (Union{Real,Vector{<:Real}}) itéré initial
   - kwargs  : les options sous formes d'arguments "keywords"
      • max_iter : (Int) le nombre maximal d'iterations (optionnel, par défaut 1000)
      • tol_abs  : (Real) la tolérence absolue (optionnel, par défaut 1e-10)
      • tol_rel  : (Real) la tolérence relative (optionnel, par défaut 1e-8)
      • δ        : (Real) pour considérer ou non les tests de stagnation (optionnel, par défaut 1)

# Sorties

   - x_sol : (Union{Real,Vector{<:Real}}) une approximation de la solution du problème
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
   x_sol, f_sol, flag, nb_iters, xs = newton(f, ∇f, ∇²f, x0, max_iter=10)

"""
function newton(f::Function, ∇f::Function, ∇²f::Function, x0::Union{Real,Vector{<:Real}}; 
    max_iter::Int = 1000, 
    tol_abs::Real = 1e-10, 
    tol_rel::Real = 1e-8, 
    δ::Real = 1)

    #

    x = Float64.(x0 isa Number ? [x0] : x0) # pour convertir x en float 64
    g0_norm = norm(∇f(x))      
    xs = [copy(x)]

    flag = -1
    k = 0
    
    # on verfie au debut si on est dans un cas de stagnation 
    
    if g0_norm ≤ max(tol_rel * g0_norm, tol_abs)
      return x, f(x), 0, 0, xs 
    end

    while k < max_iter
        # on calcul le gradien  et la hessienne de f en x
        g = ∇f(x)
        H = ∇²f(x)

        d= -H \ g
        
        # les nouvelles valeur de x et f
        x_new = x .+ d
        f_new = f(x_new)
        
        #CN1 
        if norm(∇f(x_new)) ≤ max(tol_rel * g0_norm, tol_abs)
            flag = 0
            x = x_new
            k += 1
            push!(xs, copy(x))
            break
        end

        #stagnation de l'itere
        if norm(x_new - x) ≤ δ * max(tol_rel * norm(x), tol_abs)
            flag = 1
            x = x_new
            k += 1
            push!(xs, copy(x))
            break
        end

        #stagnation de la fonction
        if abs(f_new - f(x)) ≤ δ * max(tol_rel * abs(f(x)), tol_abs)
            flag = 2
            x = x_new
            k += 1
            push!(xs, copy(x))
            break
        end

       
        x = x_new
        push!(xs, copy(x))
        k += 1
    end

    # nombre d'iterations max 
    if k ≥ max_iter && flag == -1
        flag = 3
    end

    return x, f(x), flag, k, xs

end