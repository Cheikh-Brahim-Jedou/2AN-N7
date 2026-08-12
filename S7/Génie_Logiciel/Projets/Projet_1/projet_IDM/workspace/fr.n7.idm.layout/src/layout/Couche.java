/**
 */
package layout;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Couche</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link layout.Couche#getName <em>Name</em>}</li>
 *   <li>{@link layout.Couche#getNumero <em>Numero</em>}</li>
 *   <li>{@link layout.Couche#getPistes <em>Pistes</em>}</li>
 * </ul>
 *
 * @see layout.LayoutPackage#getCouche()
 * @model abstract="true"
 * @generated
 */
public interface Couche extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see layout.LayoutPackage#getCouche_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link layout.Couche#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Numero</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numero</em>' attribute.
	 * @see #setNumero(int)
	 * @see layout.LayoutPackage#getCouche_Numero()
	 * @model required="true"
	 * @generated
	 */
	int getNumero();

	/**
	 * Sets the value of the '{@link layout.Couche#getNumero <em>Numero</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numero</em>' attribute.
	 * @see #getNumero()
	 * @generated
	 */
	void setNumero(int value);

	/**
	 * Returns the value of the '<em><b>Pistes</b></em>' containment reference list.
	 * The list contents are of type {@link layout.Piste}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pistes</em>' containment reference list.
	 * @see layout.LayoutPackage#getCouche_Pistes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Piste> getPistes();

} // Couche
