/**
 */
package netlist;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link netlist.Net#getName <em>Name</em>}</li>
 *   <li>{@link netlist.Net#getConnexions <em>Connexions</em>}</li>
 * </ul>
 *
 * @see netlist.NetlistPackage#getNet()
 * @model
 * @generated
 */
public interface Net extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see netlist.NetlistPackage#getNet_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link netlist.Net#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Connexions</b></em>' reference list.
	 * The list contents are of type {@link netlist.Connexion}.
	 * It is bidirectional and its opposite is '{@link netlist.Connexion#getNet <em>Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connexions</em>' reference list.
	 * @see netlist.NetlistPackage#getNet_Connexions()
	 * @see netlist.Connexion#getNet
	 * @model opposite="net"
	 * @generated
	 */
	EList<Connexion> getConnexions();

} // Net
