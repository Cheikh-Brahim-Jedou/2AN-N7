/**
 */
package catalog;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metadonnee</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link catalog.Metadonnee#getCle <em>Cle</em>}</li>
 *   <li>{@link catalog.Metadonnee#getValeur <em>Valeur</em>}</li>
 *   <li>{@link catalog.Metadonnee#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see catalog.CatalogPackage#getMetadonnee()
 * @model
 * @generated
 */
public interface Metadonnee extends EObject {
	/**
	 * Returns the value of the '<em><b>Cle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cle</em>' attribute.
	 * @see #setCle(String)
	 * @see catalog.CatalogPackage#getMetadonnee_Cle()
	 * @model required="true"
	 * @generated
	 */
	String getCle();

	/**
	 * Sets the value of the '{@link catalog.Metadonnee#getCle <em>Cle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cle</em>' attribute.
	 * @see #getCle()
	 * @generated
	 */
	void setCle(String value);

	/**
	 * Returns the value of the '<em><b>Valeur</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valeur</em>' attribute.
	 * @see #setValeur(String)
	 * @see catalog.CatalogPackage#getMetadonnee_Valeur()
	 * @model required="true"
	 * @generated
	 */
	String getValeur();

	/**
	 * Sets the value of the '{@link catalog.Metadonnee#getValeur <em>Valeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valeur</em>' attribute.
	 * @see #getValeur()
	 * @generated
	 */
	void setValeur(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link catalog.TypeMetadonnee}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see catalog.TypeMetadonnee
	 * @see #setType(TypeMetadonnee)
	 * @see catalog.CatalogPackage#getMetadonnee_Type()
	 * @model required="true"
	 * @generated
	 */
	TypeMetadonnee getType();

	/**
	 * Sets the value of the '{@link catalog.Metadonnee#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see catalog.TypeMetadonnee
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeMetadonnee value);

} // Metadonnee
