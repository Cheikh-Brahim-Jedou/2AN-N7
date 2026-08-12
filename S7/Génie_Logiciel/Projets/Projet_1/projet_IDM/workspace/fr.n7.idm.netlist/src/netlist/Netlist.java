/**
 */
package netlist;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Netlist</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link netlist.Netlist#getName <em>Name</em>}</li>
 *   <li>{@link netlist.Netlist#getDescription <em>Description</em>}</li>
 *   <li>{@link netlist.Netlist#getInstances <em>Instances</em>}</li>
 *   <li>{@link netlist.Netlist#getNets <em>Nets</em>}</li>
 *   <li>{@link netlist.Netlist#getCommentaires <em>Commentaires</em>}</li>
 * </ul>
 *
 * @see netlist.NetlistPackage#getNetlist()
 * @model
 * @generated
 */
public interface Netlist extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see netlist.NetlistPackage#getNetlist_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link netlist.Netlist#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see netlist.NetlistPackage#getNetlist_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link netlist.Netlist#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link netlist.InstanceComposant}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see netlist.NetlistPackage#getNetlist_Instances()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstanceComposant> getInstances();

	/**
	 * Returns the value of the '<em><b>Nets</b></em>' containment reference list.
	 * The list contents are of type {@link netlist.Net}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nets</em>' containment reference list.
	 * @see netlist.NetlistPackage#getNetlist_Nets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Net> getNets();

	/**
	 * Returns the value of the '<em><b>Commentaires</b></em>' containment reference list.
	 * The list contents are of type {@link netlist.Commentaire}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commentaires</em>' containment reference list.
	 * @see netlist.NetlistPackage#getNetlist_Commentaires()
	 * @model containment="true"
	 * @generated
	 */
	EList<Commentaire> getCommentaires();

} // Netlist
