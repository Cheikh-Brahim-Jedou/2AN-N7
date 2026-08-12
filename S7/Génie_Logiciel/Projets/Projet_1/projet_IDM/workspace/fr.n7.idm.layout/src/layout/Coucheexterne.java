/**
 */
package layout;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coucheexterne</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link layout.Coucheexterne#getComposantPlaces <em>Composant Places</em>}</li>
 * </ul>
 *
 * @see layout.LayoutPackage#getCoucheexterne()
 * @model
 * @generated
 */
public interface Coucheexterne extends Couche {
	/**
	 * Returns the value of the '<em><b>Composant Places</b></em>' containment reference list.
	 * The list contents are of type {@link layout.ComposantPlace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composant Places</em>' containment reference list.
	 * @see layout.LayoutPackage#getCoucheexterne_ComposantPlaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComposantPlace> getComposantPlaces();

} // Coucheexterne
