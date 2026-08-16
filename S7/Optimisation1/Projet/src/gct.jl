using LinearAlgebra
"""
Approximation de la solution du problème 

    min qₖ(s) = s'gₖ + 1/2 s' Hₖ s, sous la contrainte ‖s‖ ≤ Δₖ

# Syntaxe

    s = gct(g, H, Δ; kwargs...)

# Entrées

    - g : (Vector{<:Real}) le vecteur gₖ
    - H : (Matrix{<:Real}) la matrice Hₖ
    - Δ : (Real) le scalaire Δₖ
    - kwargs  : les options sous formes d'arguments "keywords", c'est-à-dire des arguments nommés
        • max_iter : le nombre maximal d'iterations (optionnel, par défaut 100)
        • tol_abs  : la tolérence absolue (optionnel, par défaut 1e-10)
        • tol_rel  : la tolérence relative (optionnel, par défaut 1e-8)

# Sorties

    - s : (Vector{<:Real}) une approximation de la solution du problème

# Exemple d'appel

    g = [0; 0]
    H = [7 0 ; 0 2]
    Δ = 1
    s = gct(g, H, Δ, max_iter = 10)

"""
function gct(g::Vector{<:Real}, H::Matrix{<:Real}, Δ::Real; 
    max_iter::Int = 100, 
    tol_abs::Real = 1e-10, 
    tol_rel::Real = 1e-8)

    s = zeros(length(g))
  

"""
Approximation de la solution du problème :
    min qₖ(s) = s'gₖ + 1/2 s' Hₖ s
    sous la contrainte ‖s‖ ≤ Δₖ

# Syntaxe
    s = gct(g, H, Δ; kwargs...)
# ... (Description des Entrées/Sorties comme dans votre squelette) ...
"""

    
    
    # Initialisation selon l'Algorithme 3:
   
    s = zeros(length(g))
    g_k = copy(g)          
    p_k = -copy(g)        
    
    # Norme initiale du gradient (pour la tolérance relative)
    g_0_norm = norm(g)
    
    # Vérification de la convergence initiale
    if g_0_norm < max(tol_rel * g_0_norm, tol_abs)
        return s
    end

    j = 0 # Compteur d'itération
    while j < max_iter && norm(g_k) > max(tol_rel * g_0_norm, tol_abs) # Condition d'arrêt sur le gradient
        
        # 1. Calcul des coefficients : H * p_k est requis deux fois
        H_p_k = H * p_k
        
        #  Calcul de κ_k (Algorithme 3)
        kappa_k = dot(p_k, H_p_k)
        
        # 2. Condition de courbure négative ou nulle (kappa_k <= 0)
        if kappa_k <= 0
            #  Calcul de σ (racine positive pour ‖s + σp‖ = Δ)
            # Résoudre ‖s + σp‖² = Δ²
            
            # Coefficients de l'équation quadratique en σ : aσ² + bσ + c = 0
            a_eq = dot(p_k, p_k)
            b_eq = 2 * dot(s, p_k)
            c_eq = dot(s, s) - Δ^2
            
            # Seule la racine positive est intéressante (σ > 0)
            sigma = (-b_eq + sqrt(b_eq^2 - 4 * a_eq * c_eq)) / (2 * a_eq)
            
            # Retourner le point sur la frontière
            return s + sigma * p_k
        end

        # 3. Calcul de α_k
        alpha_k = dot(g_k, g_k) / kappa_k
        
        # 4. Vérification de la contrainte (‖s + αp‖ ≥ Δ)
        s_plus_alpha_p = s + alpha_k * p_k
        
        if norm(s_plus_alpha_p) >= Δ
            #  Calcul de σ (comme précédemment) pour trouver le point sur la frontière
            a_eq = dot(p_k, p_k)
            b_eq = 2 * dot(s, p_k)
            c_eq = dot(s, s) - Δ^2
            
            sigma = (-b_eq + sqrt(b_eq^2 - 4 * a_eq * c_eq)) / (2 * a_eq)
            
            # Retourner le point sur la frontière
            return s + sigma * p_k
        end

        # 5. Mise à jour des itérés (Si la contrainte n'est pas violée)
        
        # Mise à jour du pas s
        s = s_plus_alpha_p 
        
        
        g_next = g_k + alpha_k * H_p_k 
        
        # 6. Calcul de β_k
        beta_k = dot(g_next, g_next) / dot(g_k, g_k) 
        
        # Mise à jour de la direction de recherche
        p_k = -g_next + beta_k * p_k 
        
        # Préparation pour la prochaine itération
        g_k = g_next
        j += 1
    end


   return s
   
end