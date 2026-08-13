import pandas as pd
import numpy as np
import networkx as nx
import matplotlib.pyplot as plt
from itertools import combinations
from scipy.spatial.distance import euclidean

# Chargement des fichiers
def charger_topologies():
    topologies = {
        'faible': pd.read_csv('data/topology_low.csv'),
        'moyenne': pd.read_csv('data/topology_avg.csv'),
        'forte': pd.read_csv('data/topology_high.csv')
    }
    return topologies

# Construction du graphe
def construire_graphe(donnees, portee, avec_poids=False):
    graphe = nx.Graph()
    nb_satellites = len(donnees)
    graphe.add_nodes_from(range(nb_satellites))
    
    positions = donnees[['x', 'y', 'z']].values
    
    for i, j in combinations(range(nb_satellites), 2):
        distance = euclidean(positions[i], positions[j])
        if distance/1000 <= portee:
            if avec_poids:
                graphe.add_edge(i, j, weight=distance**2)
            else:
                graphe.add_edge(i, j)
    
    return graphe

# Calcul des métriques
def calculer_metriques(graphe, nom_config):
    liste_degres = [deg for noeud, deg in graphe.degree()]
    coefs_clustering = list(nx.clustering(graphe).values())
    
    # Calculer les chemins et compter le nombre de plus courts chemins
    if nx.is_connected(graphe):
        longueurs_chemins = []
        nb_plus_courts_chemins = 0
        
        for depart in graphe.nodes():
            chemins = nx.single_source_shortest_path_length(graphe, depart)
            longueurs_chemins.extend(chemins.values())
            
            # Compter les plus courts chemins depuis ce noeud
            for arrivee in graphe.nodes():
                if depart != arrivee:
                    nb_chemins = len(list(nx.all_shortest_paths(graphe, depart, arrivee)))
                    nb_plus_courts_chemins += nb_chemins
    else:
        plus_grande_composante = max(nx.connected_components(graphe), key=len)
        sous_graphe = graphe.subgraph(plus_grande_composante)
        longueurs_chemins = []
        nb_plus_courts_chemins = 0
        
        for depart in plus_grande_composante:
            chemins = nx.single_source_shortest_path_length(sous_graphe, depart)
            longueurs_chemins.extend(chemins.values())
            
            # Compter les plus courts chemins depuis ce noeud
            for arrivee in plus_grande_composante:
                if depart != arrivee:
                    nb_chemins = len(list(nx.all_shortest_paths(sous_graphe, depart, arrivee)))
                    nb_plus_courts_chemins += nb_chemins
    
    metriques = {
        'nom': nom_config,
        'nb_noeuds': graphe.number_of_nodes(),
        'nb_aretes': graphe.number_of_edges(),
        'degre_moyen': np.mean(liste_degres),
        'distribution_degres': liste_degres,
        'clustering_moyen': np.mean(coefs_clustering),
        'distribution_clustering': coefs_clustering,
        'nombre_cliques': sum(1 for clique in nx.find_cliques(graphe)),
        'taille_max_clique': len(max(nx.find_cliques(graphe), key=len)),
        'nb_composantes': nx.number_connected_components(graphe),
        'taille_plus_grande_comp': len(max(nx.connected_components(graphe), key=len)),
        'longueur_moy_chemins': np.mean([l for l in longueurs_chemins if l > 0]),
        'dist_chemins': [l for l in longueurs_chemins if l > 0],
        'nb_plus_courts_chemins': nb_plus_courts_chemins  # AJOUT
    }
    
    return metriques

# Métriques pondérées
def calculer_metriques_ponderees(graphe, nom_config):
    metriques = calculer_metriques(graphe, nom_config)
    
    if nx.is_connected(graphe):
        chemins_ponderes = []
        for depart in graphe.nodes():
            longueurs = nx.single_source_dijkstra_path_length(graphe, depart)
            chemins_ponderes.extend(longueurs.values())
    else:
        plus_grande_comp = max(nx.connected_components(graphe), key=len)
        sous_graphe = graphe.subgraph(plus_grande_comp)
        chemins_ponderes = []
        for depart in plus_grande_comp:
            longueurs = nx.single_source_dijkstra_path_length(sous_graphe, depart)
            chemins_ponderes.extend(longueurs.values())
    
    metriques['longueur_moy_ponderee'] = np.mean([l for l in chemins_ponderes if l > 0])
    metriques['dist_chemins_ponderes'] = [l for l in chemins_ponderes if l > 0]
    
    return metriques

# Sauvegarde des résultats avec distributions
def sauvegarder_resultats(tous_resultats, fichier='results/resultats.txt'):
    with open(fichier, 'w', encoding='utf-8') as f:
        f.write("     ANALYSE DE L'ESSAIM DE NANOSATELLITES LUNAIRES\n")

        
        for res in tous_resultats:
            f.write("\n" + "=" * 70 + "\n")
            f.write(f"  {res['nom']}\n")
            f.write("=" * 70 + "\n\n")
            
            # Caractéristiques générales
            f.write("CARACTERISTIQUES GENERALES\n\n")
            f.write(f"   Nombre de satellites : {res['nb_noeuds']}\n")
            f.write(f"   Nombre de connexions : {res['nb_aretes']}\n")
            densite = res['nb_aretes']/(res['nb_noeuds']*(res['nb_noeuds']-1)/2)
            f.write(f"   Densité du réseau : {densite:.4f}\n\n")
            
            # Analyse des degrés
            f.write("ANALYSE DES DEGRES\n\n")
            f.write(f"   Degré moyen : {res['degre_moyen']:.2f}\n")
            f.write(f"   Degré minimum : {min(res['distribution_degres'])}\n")
            f.write(f"   Degré maximum : {max(res['distribution_degres'])}\n")
            f.write(f"   Ecart type : {np.std(res['distribution_degres']):.2f}\n\n")
            
            # Distribution des degrés
            f.write("   Distribution des degrés :\n")
            histo_deg, bins_deg = np.histogram(res['distribution_degres'], bins=10)
            for i in range(len(histo_deg)):
                if histo_deg[i] > 0:
                    f.write(f"      [{bins_deg[i]:.1f} - {bins_deg[i+1]:.1f}] : {histo_deg[i]} satellites\n")
            f.write("\n")
            
            # Clustering
            f.write("COEFFICIENT DE CLUSTERING\n\n")
            f.write(f"   Clustering moyen : {res['clustering_moyen']:.4f}\n")
            f.write(f"   Clustering minimum : {min(res['distribution_clustering']):.4f}\n")
            f.write(f"   Clustering maximum : {max(res['distribution_clustering']):.4f}\n")
            f.write(f"   Ecart type : {np.std(res['distribution_clustering']):.4f}\n\n")
            
            # Distribution du clustering
            f.write("   Distribution du clustering :\n")
            histo_clust, bins_clust = np.histogram(res['distribution_clustering'], bins=10)
            for i in range(len(histo_clust)):
                if histo_clust[i] > 0:
                    f.write(f"      [{bins_clust[i]:.2f} - {bins_clust[i+1]:.2f}] : {histo_clust[i]} satellites\n")
            f.write("\n")
            
            # Cliques
            f.write("CLIQUES\n\n")
            f.write(f"   Nombre total de cliques : {res['nombre_cliques']}\n")
            f.write(f"   Taille de la plus grande clique : {res['taille_max_clique']} satellites\n\n")
            
            # Composantes connexes
            f.write("COMPOSANTES CONNEXES\n\n")
            f.write(f"   Nombre de composantes : {res['nb_composantes']}\n")
            f.write(f"   Taille de la plus grande composante : {res['taille_plus_grande_comp']} satellites\n")
            pourcentage = 100*res['taille_plus_grande_comp']/res['nb_noeuds']
            f.write(f"   Pourcentage dans la composante principale : {pourcentage:.1f}%\n\n")
            
            # Plus courts chemins
            f.write("PLUS COURTS CHEMINS\n\n")
            f.write(f"   Longueur moyenne : {res['longueur_moy_chemins']:.2f} sauts\n")
            f.write(f"   Longueur minimale : {min(res['dist_chemins'])} saut\n")
            f.write(f"   Longueur maximale (diamètre) : {max(res['dist_chemins'])} sauts\n")
            f.write(f"   Nombre total de plus courts chemins : {res['nb_plus_courts_chemins']}\n\n")  # AJOUT
            
            # Distribution des chemins
            f.write("   Distribution des longueurs de chemins :\n")
            chemins_uniques = [x for x in res['dist_chemins'] if x > 0]
            if chemins_uniques:
                histo_chem, bins_chem = np.histogram(chemins_uniques, 
                                                      bins=range(1, max(chemins_uniques)+2))
                for i in range(len(histo_chem)):
                    if histo_chem[i] > 0:
                        f.write(f"      {int(bins_chem[i])} saut(s) : {histo_chem[i]} chemins\n")
            f.write("\n")
            
            # Chemins pondérés
            if 'longueur_moy_ponderee' in res:
                f.write("CHEMINS PONDERES (distance au carré)\n\n")
                f.write(f"   Longueur moyenne pondérée : {res['longueur_moy_ponderee']:.2f}\n")
                f.write(f"   Longueur minimale : {min(res['dist_chemins_ponderes']):.2f}\n")
                f.write(f"   Longueur maximale : {max(res['dist_chemins_ponderes']):.2f}\n\n")
                
                # Distribution des chemins pondérés
                f.write("   Distribution des distances pondérées :\n")
                chemins_pond = [x for x in res['dist_chemins_ponderes'] if x > 0]
                if chemins_pond:
                    histo_pond, bins_pond = np.histogram(chemins_pond, bins=10)
                    for i in range(len(histo_pond)):
                        if histo_pond[i] > 0:
                            f.write(f"      [{bins_pond[i]:.0f} - {bins_pond[i+1]:.0f}] : {histo_pond[i]} chemins\n")
                f.write("\n")
            
            f.write("\n")
        
        # Tableau comparatif
        f.write("\n" + "=" * 70 + "\n")
        f.write("TABLEAU COMPARATIF\n")
        f.write("=" * 70 + "\n\n")
        
        f.write(f"{'Configuration':<30} {'Liens':<10} {'Degré':<10} {'Clustering':<12} {'Nb chemins':<15}\n")
        f.write("-" * 70 + "\n")
        
        for res in tous_resultats[:9]:
            f.write(f"{res['nom']:<30} {res['nb_aretes']:<10} {res['degre_moyen']:<10.2f} {res['clustering_moyen']:<12.4f} {res['nb_plus_courts_chemins']:<15}\n")

# Visualisation des graphes
def dessiner_graphe(graphe, donnees, nom):
    fig = plt.figure(figsize=(10, 8))
    ax = fig.add_subplot(111, projection='3d')
    positions = donnees[['x', 'y', 'z']].values
    
    for i, j in graphe.edges():
        ax.plot([positions[i][0], positions[j][0]], 
                [positions[i][1], positions[j][1]], 
                [positions[i][2], positions[j][2]], 
                'b-', alpha=0.1, lw=0.5)
    
    ax.scatter(positions[:, 0], positions[:, 1], positions[:, 2], 
               c='red', s=20, alpha=0.6)
    ax.set_title(nom)
    ax.set_xlabel('X (km)')
    ax.set_ylabel('Y (km)')
    ax.set_zlabel('Z (km)')
    plt.savefig(f'results/{nom}.png', dpi=150, bbox_inches='tight')
    plt.close()

def creer_graphiques_resume(tous_resultats):
    fig, axes = plt.subplots(2, 2, figsize=(12, 10))
    
    noms = [r['nom'] for r in tous_resultats[:9]]
    degres_moyens = [r['degre_moyen'] for r in tous_resultats[:9]]
    clusterings = [r['clustering_moyen'] for r in tous_resultats[:9]]
    distances = [r['longueur_moy_chemins'] for r in tous_resultats[:9]]
    nb_chemins = [r['nb_plus_courts_chemins'] for r in tous_resultats[:9]]  # AJOUT
    
    axes[0,0].bar(range(9), degres_moyens, color='steelblue')
    axes[0,0].set_title('Degré Moyen')
    axes[0,0].set_xticks(range(9))
    axes[0,0].set_xticklabels(noms, rotation=45, ha='right', fontsize=8)
    
    axes[0,1].bar(range(9), clusterings, color='coral')
    axes[0,1].set_title('Coefficient de Clustering')
    axes[0,1].set_xticks(range(9))
    axes[0,1].set_xticklabels(noms, rotation=45, ha='right', fontsize=8)
    
    axes[1,0].bar(range(9), distances, color='lightgreen')
    axes[1,0].set_title('Distance Moyenne')
    axes[1,0].set_xticks(range(9))
    axes[1,0].set_xticklabels(noms, rotation=45, ha='right', fontsize=8)
    
    axes[1,1].bar(range(9), nb_chemins, color='plum')  # MODIFIÉ
    axes[1,1].set_title('Nombre de Plus Courts Chemins')  # MODIFIÉ
    axes[1,1].set_xticks(range(9))
    axes[1,1].set_xticklabels(noms, rotation=45, ha='right', fontsize=8)
    
    plt.tight_layout()
    plt.savefig('results/graphiques.png', dpi=150)
    plt.close()

# Programme principal
def main():
    import os
    os.makedirs('results', exist_ok=True)   
    donnees_topo = charger_topologies()  
    resultats = []
    
    # Graphes non pondérés
    for densite in ['faible', 'moyenne', 'forte']:
        for portee_km in [20, 40, 60]:
            nom_config = f"Densité {densite} Portée {portee_km}km"           
            mon_graphe = construire_graphe(donnees_topo[densite], portee_km)
            dessiner_graphe(mon_graphe, donnees_topo[densite], nom_config.replace(' ', '_'))
            resultats.append(calculer_metriques(mon_graphe, nom_config))
           
    
    # Graphes pondérés (60km)
    for densite in ['faible', 'moyenne', 'forte']:
        nom_config = f"Densité {densite}  Portée 60km (pondéré)"       
        mon_graphe = construire_graphe(donnees_topo[densite], 60, avec_poids=True)
        resultats.append(calculer_metriques_ponderees(mon_graphe, nom_config))
       
    
    sauvegarder_resultats(resultats)
    creer_graphiques_resume(resultats)

if __name__ == "__main__":
    main()