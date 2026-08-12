/**
 */
package layout;

import netlist.Net;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Piste</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link layout.Piste#getLargeur <em>Largeur</em>}</li>
 *   <li>{@link layout.Piste#getNet <em>Net</em>}</li>
 *   <li>{@link layout.Piste#getPoints <em>Points</em>}</li>
 * </ul>
 *
 * @see layout.LayoutPackage#getPiste()
 * @model
 * @generated
 */
public interface Piste extends EObject {
	/**
	 * Returns the value of the '<em><b>Largeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Largeur</em>' attribute.
	 * @see #setLargeur(double)
	 * @see layout.LayoutPackage#getPiste_Largeur()
	 * @model required="true"
	 * @generated
	 */
	double getLargeur();

	/**
	 * Sets the value of the '{@link layout.Piste#getLargeur <em>Largeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Largeur</em>' attribute.
	 * @see #getLargeur()
	 * @generated
	 */
	void setLargeur(double value);

	/**
	 * Returns the value of the '<em><b>Net</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Net</em>' reference.
	 * @see #setNet(Net)
	 * @see layout.LayoutPackage#getPiste_Net()
	 * @model
	 * @generated
	 */
	Net getNet();

	/**
	 * Sets the value of the '{@link layout.Piste#getNet <em>Net</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Net</em>' reference.
	 * @see #getNet()
	 * @generated
	 */
	void setNet(Net value);

	/**
	 * Returns the value of the '<em><b>Points</b></em>' containment reference list.
	 * The list contents are of type {@link layout.Point}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' containment reference list.
	 * @see layout.LayoutPackage#getPiste_Points()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Point> getPoints();

} // Piste
