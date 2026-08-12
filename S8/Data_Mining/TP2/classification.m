
function result = classification(S, k, sigma)
  
    
    S_sq = sum(S.^2, 2);
    dist_sq = S_sq + S_sq' -2*(S*S');
    A = exp(-dist_sq / (2 * sigma^2));
    A = A - diag(diag(A));
    
    D_vec = sum(A, 2);
    D_inv = 1 ./ sqrt(D_vec);
    D_inv(isinf(D_inv)) = 0; 
    D_inv_sqrt = diag(D_inv);
    
    L = D_inv_sqrt * A * D_inv_sqrt;
    
    [X, ~] = eigs(L, k, 'la');
    
    normes_lignes = sqrt(sum(X.^2, 2));
    normes_lignes(normes_lignes == 0) = 1e-10; 
    Y = X ./ normes_lignes;
    
    result = kmeans(Y, k);
end