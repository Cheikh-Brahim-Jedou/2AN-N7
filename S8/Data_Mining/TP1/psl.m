
clc; clear; close all;

A = [100; 200; 300; 400];  
G = [1 1 1; 2 2 4; 3 4 5; 1 0 1];  
b = [-151.66; 96.534; -253.27; -1202.7];  


M = [A, G]; 
sol_reelle = M \ b; 
x_bar = sol_reelle(1);      
I_bar = sol_reelle(2:4);   

Q = G'*G - G'*A * inv(A'*A) * A'*G; 
R = chol(Q);


I_round = round(I_bar);
chi = (I_round - I_bar)' * Q * (I_round - I_bar);
I_hat = I_round; 

Q_1 = [2 2 2; 2 4 5 ; 2 5 7 ];
R_1 = chol(Q_1);
I_bar_1 = [0.1; 0.2; 0.3] ; 


g3 = ceil(-sqrt(chi)/R_1(3,3) + I_bar_1(3)); 
d3 = floor(sqrt(chi)/R_1(3,3) + I_bar_1(3));



           

for i3 = g3:d3
    term3 = R(3,3) * (i3 - I_bar(3));
    reste3 = chi - term3^2;
    
    if reste3 >= 0
    
        offset2 = R(2,3)*(i3 - I_bar(3));
        g2 = ceil(-sqrt(reste3)/R(2,2) + I_bar(2) - offset2/R(2,2));
        d2 = floor(sqrt(reste3)/R(2,2) + I_bar(2) - offset2/R(2,2));
        
        for i2 = g2:d2
            term2 = R(2,2)*(i2 - I_bar(2)) + offset2;
            reste2 = reste3 - term2^2;
            
            if reste2 >= 0
              
                offset1 = R(1,2)*(i2 - I_bar(2)) + R(1,3)*(i3 - I_bar(3));
                g1 = ceil(-sqrt(reste2)/R(1,1) + I_bar(1) - offset1/R(1,1));
                d1 = floor(sqrt(reste2)/R(1,1) + I_bar(1) - offset1/R(1,1));
                
                for i1 = g1:d1
                 
                    I_test = [i1; i2; i3];
                    phi_test = (I_test - I_bar)' * Q * (I_test - I_bar);
                
                    if phi_test < chi
                        chi = phi_test; 
                        I_hat = I_test;
                    end
                end
            end
        end
    end
end

x_hat = (A'*A) \ (A'*b - A'*G*I_hat); 

disp('--- RESULTATS ---');
disp('La position réelle x_hat est :');
disp(x_hat);
disp('Les ambiguïtés entières I_hat trouvées sont :');
disp(I_hat);