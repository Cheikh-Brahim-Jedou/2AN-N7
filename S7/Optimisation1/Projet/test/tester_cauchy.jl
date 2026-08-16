# Ecrire les tests de l'algorithme du pas de Cauchy
using Test

function tester_cauchy(cauchy::Function)
    
    # tolérance pour les tests
    tol_erreur = sqrt(eps())
    
    tol_abs = 1e-10

	Test.@testset "Pas de Cauchy" begin
         # Test 1 : 
        Test.@testset "Gradient presque nul" begin 
            g = [1e-12, 0.0]
            H = [7.0 0.0; 0.0 2.0]
            Δ = 1.0
            
            s = cauchy(g, H, Δ, tol_abs=tol_abs)
            Test.@test norm(s) < tol_erreur
         end
         # Test 2: Cas SPD non saturé
        Test.@testset "Cas 2: SPD non saturé" begin
            g = [1.0, 2.0]
            H = [7.0 0.0; 0.0 2.0]  # SPD
            Δ = 10.0  # Grand rayon
            
            s = cauchy(g, H, Δ, tol_abs=tol_abs)
            g_norm = norm(g)
            gHg = dot(g, H * g)
            
            # Vérifier la formule théorique
            t_theorique = g_norm^2 / gHg
            Test.@test abs(norm(s) / g_norm - t_theorique) < tol_erreur
            Test.@test norm(s) < Δ  # Non saturé
            
        end
         # Test 3 : Cas SPD saturé
        Test.@testset " Cas 3 : SPD saturé" begin
            g = [1.0, 2.0]
            H = [7.0 0.0; 0.0 2.0]  # SPD
            Δ = 0.2  # Petit rayon
            
            s = cauchy(g, H, Δ, tol_abs=tol_abs)
            
            #verification de saturation
            Test.@test abs(norm(s) - Δ) < tol_erreur
            #verification de la direction
            Test.@test abs(g[1]/g[2] - s[1]/s[2]) < tol_erreur
        end    
        
    end

end