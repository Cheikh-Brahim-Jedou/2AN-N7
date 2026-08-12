/**
 */
package catalog;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see catalog.CatalogFactory
 * @model kind="package"
 * @generated
 */
public interface CatalogPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "catalog";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/catalog";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "catalog";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CatalogPackage eINSTANCE = catalog.impl.CatalogPackageImpl.init();

	/**
	 * The meta object id for the '{@link catalog.impl.CatalogueImpl <em>Catalogue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see catalog.impl.CatalogueImpl
	 * @see catalog.impl.CatalogPackageImpl#getCatalogue()
	 * @generated
	 */
	int CATALOGUE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGUE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Composants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGUE__COMPOSANTS = 1;

	/**
	 * The number of structural features of the '<em>Catalogue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGUE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Catalogue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOGUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link catalog.impl.ComposantImpl <em>Composant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see catalog.impl.ComposantImpl
	 * @see catalog.impl.CatalogPackageImpl#getComposant()
	 * @generated
	 */
	int COMPOSANT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Fabricant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT__FABRICANT = 1;

	/**
	 * The feature id for the '<em><b>Metadonnees</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT__METADONNEES = 2;

	/**
	 * The feature id for the '<em><b>Empreinte</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT__EMPREINTE = 3;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT__PORTS = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT__ID = 5;

	/**
	 * The number of structural features of the '<em>Composant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Composant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link catalog.impl.MetadonneeImpl <em>Metadonnee</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see catalog.impl.MetadonneeImpl
	 * @see catalog.impl.CatalogPackageImpl#getMetadonnee()
	 * @generated
	 */
	int METADONNEE = 2;

	/**
	 * The feature id for the '<em><b>Cle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADONNEE__CLE = 0;

	/**
	 * The feature id for the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADONNEE__VALEUR = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADONNEE__TYPE = 2;

	/**
	 * The number of structural features of the '<em>Metadonnee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADONNEE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Metadonnee</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADONNEE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link catalog.impl.EmpreinteImpl <em>Empreinte</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see catalog.impl.EmpreinteImpl
	 * @see catalog.impl.CatalogPackageImpl#getEmpreinte()
	 * @generated
	 */
	int EMPREINTE = 3;

	/**
	 * The feature id for the '<em><b>Largeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPREINTE__LARGEUR = 0;

	/**
	 * The feature id for the '<em><b>Hauteur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPREINTE__HAUTEUR = 1;

	/**
	 * The feature id for the '<em><b>Forme</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPREINTE__FORME = 2;

	/**
	 * The number of structural features of the '<em>Empreinte</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPREINTE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Empreinte</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPREINTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link catalog.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see catalog.impl.PortImpl
	 * @see catalog.impl.CatalogPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__X = 1;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__Y = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link catalog.FormeFigure <em>Forme Figure</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see catalog.FormeFigure
	 * @see catalog.impl.CatalogPackageImpl#getFormeFigure()
	 * @generated
	 */
	int FORME_FIGURE = 5;

	/**
	 * The meta object id for the '{@link catalog.TypePort <em>Type Port</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see catalog.TypePort
	 * @see catalog.impl.CatalogPackageImpl#getTypePort()
	 * @generated
	 */
	int TYPE_PORT = 6;

	/**
	 * The meta object id for the '{@link catalog.TypeMetadonnee <em>Type Metadonnee</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see catalog.TypeMetadonnee
	 * @see catalog.impl.CatalogPackageImpl#getTypeMetadonnee()
	 * @generated
	 */
	int TYPE_METADONNEE = 7;


	/**
	 * Returns the meta object for class '{@link catalog.Catalogue <em>Catalogue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalogue</em>'.
	 * @see catalog.Catalogue
	 * @generated
	 */
	EClass getCatalogue();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Catalogue#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see catalog.Catalogue#getName()
	 * @see #getCatalogue()
	 * @generated
	 */
	EAttribute getCatalogue_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link catalog.Catalogue#getComposants <em>Composants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composants</em>'.
	 * @see catalog.Catalogue#getComposants()
	 * @see #getCatalogue()
	 * @generated
	 */
	EReference getCatalogue_Composants();

	/**
	 * Returns the meta object for class '{@link catalog.Composant <em>Composant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composant</em>'.
	 * @see catalog.Composant
	 * @generated
	 */
	EClass getComposant();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Composant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see catalog.Composant#getName()
	 * @see #getComposant()
	 * @generated
	 */
	EAttribute getComposant_Name();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Composant#getFabricant <em>Fabricant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fabricant</em>'.
	 * @see catalog.Composant#getFabricant()
	 * @see #getComposant()
	 * @generated
	 */
	EAttribute getComposant_Fabricant();

	/**
	 * Returns the meta object for the containment reference list '{@link catalog.Composant#getMetadonnees <em>Metadonnees</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Metadonnees</em>'.
	 * @see catalog.Composant#getMetadonnees()
	 * @see #getComposant()
	 * @generated
	 */
	EReference getComposant_Metadonnees();

	/**
	 * Returns the meta object for the containment reference '{@link catalog.Composant#getEmpreinte <em>Empreinte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Empreinte</em>'.
	 * @see catalog.Composant#getEmpreinte()
	 * @see #getComposant()
	 * @generated
	 */
	EReference getComposant_Empreinte();

	/**
	 * Returns the meta object for the containment reference list '{@link catalog.Composant#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see catalog.Composant#getPorts()
	 * @see #getComposant()
	 * @generated
	 */
	EReference getComposant_Ports();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Composant#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see catalog.Composant#getId()
	 * @see #getComposant()
	 * @generated
	 */
	EAttribute getComposant_Id();

	/**
	 * Returns the meta object for class '{@link catalog.Metadonnee <em>Metadonnee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metadonnee</em>'.
	 * @see catalog.Metadonnee
	 * @generated
	 */
	EClass getMetadonnee();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Metadonnee#getCle <em>Cle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cle</em>'.
	 * @see catalog.Metadonnee#getCle()
	 * @see #getMetadonnee()
	 * @generated
	 */
	EAttribute getMetadonnee_Cle();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Metadonnee#getValeur <em>Valeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valeur</em>'.
	 * @see catalog.Metadonnee#getValeur()
	 * @see #getMetadonnee()
	 * @generated
	 */
	EAttribute getMetadonnee_Valeur();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Metadonnee#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see catalog.Metadonnee#getType()
	 * @see #getMetadonnee()
	 * @generated
	 */
	EAttribute getMetadonnee_Type();

	/**
	 * Returns the meta object for class '{@link catalog.Empreinte <em>Empreinte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empreinte</em>'.
	 * @see catalog.Empreinte
	 * @generated
	 */
	EClass getEmpreinte();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Empreinte#getLargeur <em>Largeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Largeur</em>'.
	 * @see catalog.Empreinte#getLargeur()
	 * @see #getEmpreinte()
	 * @generated
	 */
	EAttribute getEmpreinte_Largeur();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Empreinte#getHauteur <em>Hauteur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hauteur</em>'.
	 * @see catalog.Empreinte#getHauteur()
	 * @see #getEmpreinte()
	 * @generated
	 */
	EAttribute getEmpreinte_Hauteur();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Empreinte#getForme <em>Forme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Forme</em>'.
	 * @see catalog.Empreinte#getForme()
	 * @see #getEmpreinte()
	 * @generated
	 */
	EAttribute getEmpreinte_Forme();

	/**
	 * Returns the meta object for class '{@link catalog.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see catalog.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Port#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see catalog.Port#getName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Name();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Port#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see catalog.Port#getX()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_X();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Port#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see catalog.Port#getY()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Y();

	/**
	 * Returns the meta object for the attribute '{@link catalog.Port#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see catalog.Port#getType()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Type();

	/**
	 * Returns the meta object for enum '{@link catalog.FormeFigure <em>Forme Figure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Forme Figure</em>'.
	 * @see catalog.FormeFigure
	 * @generated
	 */
	EEnum getFormeFigure();

	/**
	 * Returns the meta object for enum '{@link catalog.TypePort <em>Type Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Port</em>'.
	 * @see catalog.TypePort
	 * @generated
	 */
	EEnum getTypePort();

	/**
	 * Returns the meta object for enum '{@link catalog.TypeMetadonnee <em>Type Metadonnee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Type Metadonnee</em>'.
	 * @see catalog.TypeMetadonnee
	 * @generated
	 */
	EEnum getTypeMetadonnee();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CatalogFactory getCatalogFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link catalog.impl.CatalogueImpl <em>Catalogue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see catalog.impl.CatalogueImpl
		 * @see catalog.impl.CatalogPackageImpl#getCatalogue()
		 * @generated
		 */
		EClass CATALOGUE = eINSTANCE.getCatalogue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOGUE__NAME = eINSTANCE.getCatalogue_Name();

		/**
		 * The meta object literal for the '<em><b>Composants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATALOGUE__COMPOSANTS = eINSTANCE.getCatalogue_Composants();

		/**
		 * The meta object literal for the '{@link catalog.impl.ComposantImpl <em>Composant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see catalog.impl.ComposantImpl
		 * @see catalog.impl.CatalogPackageImpl#getComposant()
		 * @generated
		 */
		EClass COMPOSANT = eINSTANCE.getComposant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSANT__NAME = eINSTANCE.getComposant_Name();

		/**
		 * The meta object literal for the '<em><b>Fabricant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSANT__FABRICANT = eINSTANCE.getComposant_Fabricant();

		/**
		 * The meta object literal for the '<em><b>Metadonnees</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSANT__METADONNEES = eINSTANCE.getComposant_Metadonnees();

		/**
		 * The meta object literal for the '<em><b>Empreinte</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSANT__EMPREINTE = eINSTANCE.getComposant_Empreinte();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSANT__PORTS = eINSTANCE.getComposant_Ports();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSANT__ID = eINSTANCE.getComposant_Id();

		/**
		 * The meta object literal for the '{@link catalog.impl.MetadonneeImpl <em>Metadonnee</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see catalog.impl.MetadonneeImpl
		 * @see catalog.impl.CatalogPackageImpl#getMetadonnee()
		 * @generated
		 */
		EClass METADONNEE = eINSTANCE.getMetadonnee();

		/**
		 * The meta object literal for the '<em><b>Cle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METADONNEE__CLE = eINSTANCE.getMetadonnee_Cle();

		/**
		 * The meta object literal for the '<em><b>Valeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METADONNEE__VALEUR = eINSTANCE.getMetadonnee_Valeur();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METADONNEE__TYPE = eINSTANCE.getMetadonnee_Type();

		/**
		 * The meta object literal for the '{@link catalog.impl.EmpreinteImpl <em>Empreinte</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see catalog.impl.EmpreinteImpl
		 * @see catalog.impl.CatalogPackageImpl#getEmpreinte()
		 * @generated
		 */
		EClass EMPREINTE = eINSTANCE.getEmpreinte();

		/**
		 * The meta object literal for the '<em><b>Largeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPREINTE__LARGEUR = eINSTANCE.getEmpreinte_Largeur();

		/**
		 * The meta object literal for the '<em><b>Hauteur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPREINTE__HAUTEUR = eINSTANCE.getEmpreinte_Hauteur();

		/**
		 * The meta object literal for the '<em><b>Forme</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPREINTE__FORME = eINSTANCE.getEmpreinte_Forme();

		/**
		 * The meta object literal for the '{@link catalog.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see catalog.impl.PortImpl
		 * @see catalog.impl.CatalogPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__NAME = eINSTANCE.getPort_Name();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__X = eINSTANCE.getPort_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__Y = eINSTANCE.getPort_Y();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__TYPE = eINSTANCE.getPort_Type();

		/**
		 * The meta object literal for the '{@link catalog.FormeFigure <em>Forme Figure</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see catalog.FormeFigure
		 * @see catalog.impl.CatalogPackageImpl#getFormeFigure()
		 * @generated
		 */
		EEnum FORME_FIGURE = eINSTANCE.getFormeFigure();

		/**
		 * The meta object literal for the '{@link catalog.TypePort <em>Type Port</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see catalog.TypePort
		 * @see catalog.impl.CatalogPackageImpl#getTypePort()
		 * @generated
		 */
		EEnum TYPE_PORT = eINSTANCE.getTypePort();

		/**
		 * The meta object literal for the '{@link catalog.TypeMetadonnee <em>Type Metadonnee</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see catalog.TypeMetadonnee
		 * @see catalog.impl.CatalogPackageImpl#getTypeMetadonnee()
		 * @generated
		 */
		EEnum TYPE_METADONNEE = eINSTANCE.getTypeMetadonnee();

	}

} //CatalogPackage
