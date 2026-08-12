/**
 */
package layout;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see layout.LayoutFactory
 * @model kind="package"
 * @generated
 */
public interface LayoutPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "layout";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/layout";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "layout";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayoutPackage eINSTANCE = layout.impl.LayoutPackageImpl.init();

	/**
	 * The meta object id for the '{@link layout.impl.LayoutImpl <em>Layout</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.LayoutImpl
	 * @see layout.impl.LayoutPackageImpl#getLayout()
	 * @generated
	 */
	int LAYOUT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Boards</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__BOARDS = 2;

	/**
	 * The feature id for the '<em><b>Netlist</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT__NETLIST = 3;

	/**
	 * The number of structural features of the '<em>Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Layout</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAYOUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link layout.impl.BoardImpl <em>Board</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.BoardImpl
	 * @see layout.impl.LayoutPackageImpl#getBoard()
	 * @generated
	 */
	int BOARD = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__NAME = 0;

	/**
	 * The feature id for the '<em><b>Largeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__LARGEUR = 1;

	/**
	 * The feature id for the '<em><b>Hauteur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__HAUTEUR = 2;

	/**
	 * The feature id for the '<em><b>Couches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD__COUCHES = 3;

	/**
	 * The number of structural features of the '<em>Board</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Board</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOARD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link layout.impl.CoucheexterneImpl <em>Coucheexterne</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.CoucheexterneImpl
	 * @see layout.impl.LayoutPackageImpl#getCoucheexterne()
	 * @generated
	 */
	int COUCHEEXTERNE = 3;

	/**
	 * The meta object id for the '{@link layout.impl.CoucheImpl <em>Couche</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.CoucheImpl
	 * @see layout.impl.LayoutPackageImpl#getCouche()
	 * @generated
	 */
	int COUCHE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Numero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE__NUMERO = 1;

	/**
	 * The feature id for the '<em><b>Pistes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE__PISTES = 2;

	/**
	 * The number of structural features of the '<em>Couche</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Couche</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEEXTERNE__NAME = COUCHE__NAME;

	/**
	 * The feature id for the '<em><b>Numero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEEXTERNE__NUMERO = COUCHE__NUMERO;

	/**
	 * The feature id for the '<em><b>Pistes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEEXTERNE__PISTES = COUCHE__PISTES;

	/**
	 * The feature id for the '<em><b>Composant Places</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEEXTERNE__COMPOSANT_PLACES = COUCHE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Coucheexterne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEEXTERNE_FEATURE_COUNT = COUCHE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Coucheexterne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEEXTERNE_OPERATION_COUNT = COUCHE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link layout.impl.CoucheinterneImpl <em>Coucheinterne</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.CoucheinterneImpl
	 * @see layout.impl.LayoutPackageImpl#getCoucheinterne()
	 * @generated
	 */
	int COUCHEINTERNE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEINTERNE__NAME = COUCHE__NAME;

	/**
	 * The feature id for the '<em><b>Numero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEINTERNE__NUMERO = COUCHE__NUMERO;

	/**
	 * The feature id for the '<em><b>Pistes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEINTERNE__PISTES = COUCHE__PISTES;

	/**
	 * The number of structural features of the '<em>Coucheinterne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEINTERNE_FEATURE_COUNT = COUCHE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Coucheinterne</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUCHEINTERNE_OPERATION_COUNT = COUCHE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link layout.impl.ComposantPlaceImpl <em>Composant Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.ComposantPlaceImpl
	 * @see layout.impl.LayoutPackageImpl#getComposantPlace()
	 * @generated
	 */
	int COMPOSANT_PLACE = 5;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_PLACE__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_PLACE__Y = 1;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_PLACE__ROTATION = 2;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_PLACE__INSTANCE = 3;

	/**
	 * The number of structural features of the '<em>Composant Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_PLACE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Composant Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSANT_PLACE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link layout.impl.PisteImpl <em>Piste</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.PisteImpl
	 * @see layout.impl.LayoutPackageImpl#getPiste()
	 * @generated
	 */
	int PISTE = 6;

	/**
	 * The feature id for the '<em><b>Largeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE__LARGEUR = 0;

	/**
	 * The feature id for the '<em><b>Net</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE__NET = 1;

	/**
	 * The feature id for the '<em><b>Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE__POINTS = 2;

	/**
	 * The number of structural features of the '<em>Piste</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Piste</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PISTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link layout.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see layout.impl.PointImpl
	 * @see layout.impl.LayoutPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 7;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link layout.Layout <em>Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Layout</em>'.
	 * @see layout.Layout
	 * @generated
	 */
	EClass getLayout();

	/**
	 * Returns the meta object for the attribute '{@link layout.Layout#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see layout.Layout#getName()
	 * @see #getLayout()
	 * @generated
	 */
	EAttribute getLayout_Name();

	/**
	 * Returns the meta object for the attribute '{@link layout.Layout#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see layout.Layout#getDescription()
	 * @see #getLayout()
	 * @generated
	 */
	EAttribute getLayout_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.Layout#getBoards <em>Boards</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boards</em>'.
	 * @see layout.Layout#getBoards()
	 * @see #getLayout()
	 * @generated
	 */
	EReference getLayout_Boards();

	/**
	 * Returns the meta object for the reference '{@link layout.Layout#getNetlist <em>Netlist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Netlist</em>'.
	 * @see layout.Layout#getNetlist()
	 * @see #getLayout()
	 * @generated
	 */
	EReference getLayout_Netlist();

	/**
	 * Returns the meta object for class '{@link layout.Board <em>Board</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Board</em>'.
	 * @see layout.Board
	 * @generated
	 */
	EClass getBoard();

	/**
	 * Returns the meta object for the attribute '{@link layout.Board#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see layout.Board#getName()
	 * @see #getBoard()
	 * @generated
	 */
	EAttribute getBoard_Name();

	/**
	 * Returns the meta object for the attribute '{@link layout.Board#getLargeur <em>Largeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Largeur</em>'.
	 * @see layout.Board#getLargeur()
	 * @see #getBoard()
	 * @generated
	 */
	EAttribute getBoard_Largeur();

	/**
	 * Returns the meta object for the attribute '{@link layout.Board#getHauteur <em>Hauteur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hauteur</em>'.
	 * @see layout.Board#getHauteur()
	 * @see #getBoard()
	 * @generated
	 */
	EAttribute getBoard_Hauteur();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.Board#getCouches <em>Couches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Couches</em>'.
	 * @see layout.Board#getCouches()
	 * @see #getBoard()
	 * @generated
	 */
	EReference getBoard_Couches();

	/**
	 * Returns the meta object for class '{@link layout.Couche <em>Couche</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Couche</em>'.
	 * @see layout.Couche
	 * @generated
	 */
	EClass getCouche();

	/**
	 * Returns the meta object for the attribute '{@link layout.Couche#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see layout.Couche#getName()
	 * @see #getCouche()
	 * @generated
	 */
	EAttribute getCouche_Name();

	/**
	 * Returns the meta object for the attribute '{@link layout.Couche#getNumero <em>Numero</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numero</em>'.
	 * @see layout.Couche#getNumero()
	 * @see #getCouche()
	 * @generated
	 */
	EAttribute getCouche_Numero();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.Couche#getPistes <em>Pistes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pistes</em>'.
	 * @see layout.Couche#getPistes()
	 * @see #getCouche()
	 * @generated
	 */
	EReference getCouche_Pistes();

	/**
	 * Returns the meta object for class '{@link layout.Coucheexterne <em>Coucheexterne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coucheexterne</em>'.
	 * @see layout.Coucheexterne
	 * @generated
	 */
	EClass getCoucheexterne();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.Coucheexterne#getComposantPlaces <em>Composant Places</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Composant Places</em>'.
	 * @see layout.Coucheexterne#getComposantPlaces()
	 * @see #getCoucheexterne()
	 * @generated
	 */
	EReference getCoucheexterne_ComposantPlaces();

	/**
	 * Returns the meta object for class '{@link layout.Coucheinterne <em>Coucheinterne</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coucheinterne</em>'.
	 * @see layout.Coucheinterne
	 * @generated
	 */
	EClass getCoucheinterne();

	/**
	 * Returns the meta object for class '{@link layout.ComposantPlace <em>Composant Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composant Place</em>'.
	 * @see layout.ComposantPlace
	 * @generated
	 */
	EClass getComposantPlace();

	/**
	 * Returns the meta object for the attribute '{@link layout.ComposantPlace#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see layout.ComposantPlace#getX()
	 * @see #getComposantPlace()
	 * @generated
	 */
	EAttribute getComposantPlace_X();

	/**
	 * Returns the meta object for the attribute '{@link layout.ComposantPlace#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see layout.ComposantPlace#getY()
	 * @see #getComposantPlace()
	 * @generated
	 */
	EAttribute getComposantPlace_Y();

	/**
	 * Returns the meta object for the attribute '{@link layout.ComposantPlace#getRotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see layout.ComposantPlace#getRotation()
	 * @see #getComposantPlace()
	 * @generated
	 */
	EAttribute getComposantPlace_Rotation();

	/**
	 * Returns the meta object for the reference '{@link layout.ComposantPlace#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see layout.ComposantPlace#getInstance()
	 * @see #getComposantPlace()
	 * @generated
	 */
	EReference getComposantPlace_Instance();

	/**
	 * Returns the meta object for class '{@link layout.Piste <em>Piste</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Piste</em>'.
	 * @see layout.Piste
	 * @generated
	 */
	EClass getPiste();

	/**
	 * Returns the meta object for the attribute '{@link layout.Piste#getLargeur <em>Largeur</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Largeur</em>'.
	 * @see layout.Piste#getLargeur()
	 * @see #getPiste()
	 * @generated
	 */
	EAttribute getPiste_Largeur();

	/**
	 * Returns the meta object for the reference '{@link layout.Piste#getNet <em>Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Net</em>'.
	 * @see layout.Piste#getNet()
	 * @see #getPiste()
	 * @generated
	 */
	EReference getPiste_Net();

	/**
	 * Returns the meta object for the containment reference list '{@link layout.Piste#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Points</em>'.
	 * @see layout.Piste#getPoints()
	 * @see #getPiste()
	 * @generated
	 */
	EReference getPiste_Points();

	/**
	 * Returns the meta object for class '{@link layout.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see layout.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link layout.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see layout.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link layout.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see layout.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LayoutFactory getLayoutFactory();

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
		 * The meta object literal for the '{@link layout.impl.LayoutImpl <em>Layout</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.LayoutImpl
		 * @see layout.impl.LayoutPackageImpl#getLayout()
		 * @generated
		 */
		EClass LAYOUT = eINSTANCE.getLayout();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT__NAME = eINSTANCE.getLayout_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LAYOUT__DESCRIPTION = eINSTANCE.getLayout_Description();

		/**
		 * The meta object literal for the '<em><b>Boards</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT__BOARDS = eINSTANCE.getLayout_Boards();

		/**
		 * The meta object literal for the '<em><b>Netlist</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LAYOUT__NETLIST = eINSTANCE.getLayout_Netlist();

		/**
		 * The meta object literal for the '{@link layout.impl.BoardImpl <em>Board</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.BoardImpl
		 * @see layout.impl.LayoutPackageImpl#getBoard()
		 * @generated
		 */
		EClass BOARD = eINSTANCE.getBoard();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOARD__NAME = eINSTANCE.getBoard_Name();

		/**
		 * The meta object literal for the '<em><b>Largeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOARD__LARGEUR = eINSTANCE.getBoard_Largeur();

		/**
		 * The meta object literal for the '<em><b>Hauteur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOARD__HAUTEUR = eINSTANCE.getBoard_Hauteur();

		/**
		 * The meta object literal for the '<em><b>Couches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOARD__COUCHES = eINSTANCE.getBoard_Couches();

		/**
		 * The meta object literal for the '{@link layout.impl.CoucheImpl <em>Couche</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.CoucheImpl
		 * @see layout.impl.LayoutPackageImpl#getCouche()
		 * @generated
		 */
		EClass COUCHE = eINSTANCE.getCouche();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUCHE__NAME = eINSTANCE.getCouche_Name();

		/**
		 * The meta object literal for the '<em><b>Numero</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUCHE__NUMERO = eINSTANCE.getCouche_Numero();

		/**
		 * The meta object literal for the '<em><b>Pistes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUCHE__PISTES = eINSTANCE.getCouche_Pistes();

		/**
		 * The meta object literal for the '{@link layout.impl.CoucheexterneImpl <em>Coucheexterne</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.CoucheexterneImpl
		 * @see layout.impl.LayoutPackageImpl#getCoucheexterne()
		 * @generated
		 */
		EClass COUCHEEXTERNE = eINSTANCE.getCoucheexterne();

		/**
		 * The meta object literal for the '<em><b>Composant Places</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUCHEEXTERNE__COMPOSANT_PLACES = eINSTANCE.getCoucheexterne_ComposantPlaces();

		/**
		 * The meta object literal for the '{@link layout.impl.CoucheinterneImpl <em>Coucheinterne</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.CoucheinterneImpl
		 * @see layout.impl.LayoutPackageImpl#getCoucheinterne()
		 * @generated
		 */
		EClass COUCHEINTERNE = eINSTANCE.getCoucheinterne();

		/**
		 * The meta object literal for the '{@link layout.impl.ComposantPlaceImpl <em>Composant Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.ComposantPlaceImpl
		 * @see layout.impl.LayoutPackageImpl#getComposantPlace()
		 * @generated
		 */
		EClass COMPOSANT_PLACE = eINSTANCE.getComposantPlace();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSANT_PLACE__X = eINSTANCE.getComposantPlace_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSANT_PLACE__Y = eINSTANCE.getComposantPlace_Y();

		/**
		 * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSANT_PLACE__ROTATION = eINSTANCE.getComposantPlace_Rotation();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSANT_PLACE__INSTANCE = eINSTANCE.getComposantPlace_Instance();

		/**
		 * The meta object literal for the '{@link layout.impl.PisteImpl <em>Piste</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.PisteImpl
		 * @see layout.impl.LayoutPackageImpl#getPiste()
		 * @generated
		 */
		EClass PISTE = eINSTANCE.getPiste();

		/**
		 * The meta object literal for the '<em><b>Largeur</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PISTE__LARGEUR = eINSTANCE.getPiste_Largeur();

		/**
		 * The meta object literal for the '<em><b>Net</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PISTE__NET = eINSTANCE.getPiste_Net();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PISTE__POINTS = eINSTANCE.getPiste_Points();

		/**
		 * The meta object literal for the '{@link layout.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see layout.impl.PointImpl
		 * @see layout.impl.LayoutPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

	}

} //LayoutPackage
