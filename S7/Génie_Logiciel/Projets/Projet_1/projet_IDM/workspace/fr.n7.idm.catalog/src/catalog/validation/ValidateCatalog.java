package catalog.validation;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import catalog.CatalogPackage;

/**
 * Programme principal pour valider des fichiers .catalog
 * 
 * Usage: java ValidateCatalog fichier1.catalog fichier2.catalog ...
 */
public class ValidateCatalog {
    
    private static void afficherErreurs(String prefix, List<ValidationResult.ValidationError> errors) {
        System.out.print(prefix + ": ");
        if (errors.isEmpty()) {
            System.out.println("OK");
        } else {
            System.out.println(errors.size() + " erreur(s) trouvée(s)");
            for (ValidationResult.ValidationError error : errors) {
                System.out.println("  => " + error.toString());
            }
        }
    }
    
    private static void afficherResultat(ValidationResult resultat) {
        afficherErreurs("- Catalogue", resultat.getRecordedErrorsFor(CatalogPackage.CATALOGUE));
        afficherErreurs("- Composant", resultat.getRecordedErrorsFor(CatalogPackage.COMPOSANT));
        afficherErreurs("- Metadonnee", resultat.getRecordedErrorsFor(CatalogPackage.METADONNEE));
        afficherErreurs("- Port", resultat.getRecordedErrorsFor(CatalogPackage.PORT));
        afficherErreurs("- Empreinte", resultat.getRecordedErrorsFor(CatalogPackage.EMPREINTE));
    }
    
    public static void main(String... args) {
        // Charger le méta-modèle
        @SuppressWarnings("unused")
        CatalogPackage packageInstance = CatalogPackage.eINSTANCE;
        
        // Enregistrer l'extension .catalog
        Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
        Map<String, Object> m = reg.getExtensionToFactoryMap();
        m.put("xmi", new XMIResourceFactoryImpl());
        
        ResourceSet resSet = new ResourceSetImpl();
        CatalogValidator validator = new CatalogValidator();
        
        for (String model : args) {
            URI modelURI = URI.createURI(model);
            Resource resource = resSet.getResource(modelURI, true);
            ValidationResult resultat = validator.validate(resource);
            
            System.out.println("\n=== Validation de " + model + " ===");
            afficherResultat(resultat);
        }
        
        System.out.println("\nValidation terminée.");
    }
}