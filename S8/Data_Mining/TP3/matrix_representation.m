function [Q,L]=matrix_representation(A,n)
% Représentation sous forme de matrice du graphe Internet
% A contient les arcs du graphe orienté.
% n représente le nombre de sommets.
% Q est la matrice du graphe Internet.

% Initialisation
  Q=sparse(n,n);

  nb_arcs = size(A, 1); 
  L = sparse(A(:,1),A(:,2), ones(nb_arcs,1),n,n);

  N= sum(L,1);
  N= max(N, ones(size(N)));
  Q= L*spdiags(1./N,0,n,n);



end
