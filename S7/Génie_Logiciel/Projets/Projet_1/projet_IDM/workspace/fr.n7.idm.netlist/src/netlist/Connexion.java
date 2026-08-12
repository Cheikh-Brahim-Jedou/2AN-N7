/**
 */
package netlist;

import catalog.Port;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connexion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link netlist.Connexion#getNet <em>Net</em>}</li>
 *   <li>{@link netlist.Connexion#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @see netlist.NetlistPackage#getConnexion()
 * @model
 * @generated
 */
public interface Connexion extends EObject {
	/**
	 * Returns the value of the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' reference.
	 * @see #setPort(Port)
	 * @see netlist.NetlistPackage#getConnexion_Port()
	 * @model required="true"
	 * @generated
	 */
	Port getPort();

	/**
	 * Sets the value of the '{@link netlist.Connexion#getPort <em>Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' reference.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(Port value);

	/**
	 * Returns the value of the '<em><b>Net</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link netlist.Net#getConnexions <em>Connexions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net</em>' reference.
	 * @see #setNet(Net)
	 * @see netlist.NetlistPackage#getConnexion_Net()
	 * @see netlist.Net#getConnexions
	 * @model opposite="connexions" required="true"
	 * @generated
	 */
	Net getNet();

	/**
	 * Sets the value of the '{@link netlist.Connexion#getNet <em>Net</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net</em>' reference.
	 * @see #getNet()
	 * @generated
	 */
	void setNet(Net value);

} // Connexion
