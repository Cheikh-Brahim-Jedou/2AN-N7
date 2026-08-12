function tp_gps_final()
   
    clc; clear; close all;
    
    disp('--- RÉSOLUTION DU PROBLÈME MCLM (n quelconque) ---');

    % Données du problème 
    A = [100; 200; 300; 400];
    G = [1 1 1; 2 2 4; 3 4 5; 1 0 1];
    b = [-151.66; 96.534; -253.27; -1202.7];

    
    M = [A, G];
    sol_reelle = M \ b;
    x_bar = sol_reelle(1);       
    I_bar = sol_reelle(2:end);   

    %  Construction de la matrice Q
    Q = G'*G - G'*A * inv(A'*A) * A'*G;

    %  Appel de notre algorithme généralisé pour trouver I_hat
    I_hat = resoudre_QNE_recursif(Q, I_bar);

    % Calcul de la solution x_hat finale
    x_hat = (A'*A) \ (A'*b - A'*G*I_hat);

    % Affichage des résultats
    disp('Les ambiguïtés entières I_hat trouvées sont :');
    disp(I_hat);
    disp('La position finale x_hat est :');
    disp(x_hat);

end


function I_hat = resoudre_QNE_recursif(Q, I_bar)
    
  
    n = length(I_bar);
    R = chol(Q); 
    
    % Solution de départ avec l'arrondi et calcul du record initial (chi)
    I_round = round(I_bar);
    chi_minimum = (I_round - I_bar)' * Q * (I_round - I_bar);
    
    I_hat = I_round;       
    I_courant = zeros(n, 1); 
    
    
    explorer(n, chi_minimum);
    
    
    function explorer(k, reste)
        
        % ÉTAPE A : La condition d'arrêt (on a atteint le rez-de-chaussée)
        if k == 0
            
            phi_test = (I_courant - I_bar)' * Q * (I_courant - I_bar);
            
            if phi_test < chi_minimum
                chi_minimum = phi_test;
                I_hat = I_courant;
            end
            return; % On quitte la fonction pour remonter d'un étage
        end
        
        % ÉTAPE B : Préparation du niveau k (Calcul des bornes)
        % 1. Le décalage causé par les entiers des étages supérieurs
        decalage = 0;
        for j = (k+1):n
            decalage = decalage + R(k,j) * (I_courant(j) - I_bar(j));
        end
        
     
        racine = sqrt(max(0, reste)); 
        
        g_k = ceil( (-racine - decalage) / R(k,k) + I_bar(k) );
        d_k = floor( (racine - decalage) / R(k,k) + I_bar(k) );
        
        
        for i_k = g_k:d_k
            
            I_courant(k) = i_k; 
            
            
            terme = R(k,k) * (i_k - I_bar(k)) + decalage;
            nouveau_reste = reste - terme^2;
            
            % Si on n'a pas explosé le budget (reste positif), on plonge
            if nouveau_reste >= 0
                explorer(k - 1, nouveau_reste);
            end
            
        end
    end % (Fin de la fonction explorer)

end 