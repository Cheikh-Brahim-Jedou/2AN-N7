/**
 */
package netlist;

import catalog.Composant;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Composant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link netlist.InstanceComposant#getConnexions <em>Connexions</em>}</li>
 *   <li>{@link netlist.InstanceComposant#getComposant <em>Composant</em>}</li>
 *   <li>{@link netlist.InstanceComposant#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see netlist.NetlistPackage#getInstanceComposant()
 * @model
 * @generated
 */
public interface InstanceComposant extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see netlist.NetlistPackage#getInstanceComposant_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link netlist.InstanceComposant#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Composant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composant</em>' reference.
	 * @see #setComposant(Composant)
	 * @see netlist.NetlistPackage#getInstanceComposant_Composant()
	 * @model required="true"
	 * @generated
	 */
	Composant getComposant();

	/**
	 * Sets the value of the '{@link netlist.InstanceComposant#getComposant <em>Composant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composant</em>' reference.
	 * @see #getComposant()
	 * @generated
	 */
	void setComposant(Composant value);

	/**
	 * Returns the value of the '<em><b>Connexions</b></em>' containment reference list.
	 * The list contents are of type {@link netlist.Connexion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connexions</em>' containment reference list.
	 * @see netlist.NetlistPackage#getInstanceComposant_Connexions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Connexion> getConnexions();

} // InstanceComposant
