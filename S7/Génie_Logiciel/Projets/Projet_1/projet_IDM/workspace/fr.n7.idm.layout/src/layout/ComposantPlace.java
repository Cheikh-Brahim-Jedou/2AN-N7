/**
 */
package layout;

import netlist.InstanceComposant;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composant Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link layout.ComposantPlace#getX <em>X</em>}</li>
 *   <li>{@link layout.ComposantPlace#getY <em>Y</em>}</li>
 *   <li>{@link layout.ComposantPlace#getRotation <em>Rotation</em>}</li>
 *   <li>{@link layout.ComposantPlace#getInstance <em>Instance</em>}</li>
 * </ul>
 *
 * @see layout.LayoutPackage#getComposantPlace()
 * @model
 * @generated
 */
public interface ComposantPlace extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(double)
	 * @see layout.LayoutPackage#getComposantPlace_X()
	 * @model required="true"
	 * @generated
	 */
	double getX();

	/**
	 * Sets the value of the '{@link layout.ComposantPlace#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(double value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(double)
	 * @see layout.LayoutPackage#getComposantPlace_Y()
	 * @model required="true"
	 * @generated
	 */
	double getY();

	/**
	 * Sets the value of the '{@link layout.ComposantPlace#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(double value);

	/**
	 * Returns the value of the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rotation</em>' attribute.
	 * @see #setRotation(double)
	 * @see layout.LayoutPackage#getComposantPlace_Rotation()
	 * @model required="true"
	 * @generated
	 */
	double getRotation();

	/**
	 * Sets the value of the '{@link layout.ComposantPlace#getRotation <em>Rotation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rotation</em>' attribute.
	 * @see #getRotation()
	 * @generated
	 */
	void setRotation(double value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' reference.
	 * @see #setInstance(InstanceComposant)
	 * @see layout.LayoutPackage#getComposantPlace_Instance()
	 * @model required="true"
	 * @generated
	 */
	InstanceComposant getInstance();

	/**
	 * Sets the value of the '{@link layout.ComposantPlace#getInstance <em>Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(InstanceComposant value);

} // ComposantPlace
