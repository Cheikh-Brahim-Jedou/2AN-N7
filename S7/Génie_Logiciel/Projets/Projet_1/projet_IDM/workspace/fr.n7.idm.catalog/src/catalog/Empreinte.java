/**
 */
package catalog;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Empreinte</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link catalog.Empreinte#getLargeur <em>Largeur</em>}</li>
 *   <li>{@link catalog.Empreinte#getHauteur <em>Hauteur</em>}</li>
 *   <li>{@link catalog.Empreinte#getForme <em>Forme</em>}</li>
 * </ul>
 *
 * @see catalog.CatalogPackage#getEmpreinte()
 * @model
 * @generated
 */
public interface Empreinte extends EObject {
	/**
	 * Returns the value of the '<em><b>Largeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Largeur</em>' attribute.
	 * @see #setLargeur(double)
	 * @see catalog.CatalogPackage#getEmpreinte_Largeur()
	 * @model required="true"
	 * @generated
	 */
	double getLargeur();

	/**
	 * Sets the value of the '{@link catalog.Empreinte#getLargeur <em>Largeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Largeur</em>' attribute.
	 * @see #getLargeur()
	 * @generated
	 */
	void setLargeur(double value);

	/**
	 * Returns the value of the '<em><b>Hauteur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hauteur</em>' attribute.
	 * @see #setHauteur(double)
	 * @see catalog.CatalogPackage#getEmpreinte_Hauteur()
	 * @model required="true"
	 * @generated
	 */
	double getHauteur();

	/**
	 * Sets the value of the '{@link catalog.Empreinte#getHauteur <em>Hauteur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hauteur</em>' attribute.
	 * @see #getHauteur()
	 * @generated
	 */
	void setHauteur(double value);

	/**
	 * Returns the value of the '<em><b>Forme</b></em>' attribute.
	 * The literals are from the enumeration {@link catalog.FormeFigure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forme</em>' attribute.
	 * @see catalog.FormeFigure
	 * @see #setForme(FormeFigure)
	 * @see catalog.CatalogPackage#getEmpreinte_Forme()
	 * @model required="true"
	 * @generated
	 */
	FormeFigure getForme();

	/**
	 * Sets the value of the '{@link catalog.Empreinte#getForme <em>Forme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forme</em>' attribute.
	 * @see catalog.FormeFigure
	 * @see #getForme()
	 * @generated
	 */
	void setForme(FormeFigure value);

} // Empreinte
