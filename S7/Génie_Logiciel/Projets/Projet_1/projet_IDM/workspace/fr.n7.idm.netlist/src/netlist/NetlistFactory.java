/**
 */
package netlist;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see netlist.NetlistPackage
 * @generated
 */
public interface NetlistFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NetlistFactory eINSTANCE = netlist.impl.NetlistFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Netlist</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Netlist</em>'.
	 * @generated
	 */
	Netlist createNetlist();

	/**
	 * Returns a new object of class '<em>Instance Composant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Composant</em>'.
	 * @generated
	 */
	InstanceComposant createInstanceComposant();

	/**
	 * Returns a new object of class '<em>Net</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Net</em>'.
	 * @generated
	 */
	Net createNet();

	/**
	 * Returns a new object of class '<em>Connexion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connexion</em>'.
	 * @generated
	 */
	Connexion createConnexion();

	/**
	 * Returns a new object of class '<em>Commentaire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Commentaire</em>'.
	 * @generated
	 */
	Commentaire createCommentaire();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NetlistPackage getNetlistPackage();

} //NetlistFactory
