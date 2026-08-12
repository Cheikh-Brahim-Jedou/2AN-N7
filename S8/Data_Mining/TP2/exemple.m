% Chargement d'une coupe réelle
load('DataSagittale.mat'); 
% On suppose que la variable chargée se nomme IM. 
% Si le fichier contient une variable 'X' ou 'Data', ajuste le nom.
img_double = double(IM); 
[h, w] = size(img_double);

% Transformation de l'image en vecteur de caractéristiques
% Pour le clustering spectral simple, on utilise les intensités des pixels
S_real = img_double(:); 

% Paramètres pour l'image (à ajuster selon les résultats)
k_real = 3;     % Ex: Fond, Tissu sain, Tissu hyperfixant (tumeur)
sigma_real = 5; 

% Calcul de la segmentation
labels_real = classification(S_real, k_real, sigma_real);

% Reconstruction de l'image segmentée
segmentation = reshape(labels_real, [h, w]);

% Affichage final
figure;
subplot(1,2,1); imagesc(IM); colormap gray; axis image;
title('Image TEP Originale');
subplot(1,2,2); imagesc(segmentation); colormap jet; axis image;
title('Segmentation Spectrale');