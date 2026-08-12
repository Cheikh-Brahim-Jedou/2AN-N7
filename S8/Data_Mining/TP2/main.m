
load('ToyExample.mat'); 

S = Data; 
k = 2;

sigma_valeurs = 0.5; 

figure;

    sigma = sigma_valeurs;
    
    labels = classification(S, k, sigma);
    
    
    subplot(1, 3);
    scatter(S(:,1), S(:,2), 15, labels, 'filled');
    title(['\sigma = ' num2str(sigma)]);
