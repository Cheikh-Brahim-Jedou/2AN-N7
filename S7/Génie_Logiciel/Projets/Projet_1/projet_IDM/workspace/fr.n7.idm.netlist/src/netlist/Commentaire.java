/**
 */
package netlist;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Commentaire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link netlist.Commentaire#getTexte <em>Texte</em>}</li>
 *   <li>{@link netlist.Commentaire#getCible <em>Cible</em>}</li>
 * </ul>
 *
 * @see netlist.NetlistPackage#getCommentaire()
 * @model
 * @generated
 */
public interface Commentaire extends EObject {
	/**
	 * Returns the value of the '<em><b>Texte</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texte</em>' attribute.
	 * @see #setTexte(String)
	 * @see netlist.NetlistPackage#getCommentaire_Texte()
	 * @model required="true"
	 * @generated
	 */
	String getTexte();

	/**
	 * Sets the value of the '{@link netlist.Commentaire#getTexte <em>Texte</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texte</em>' attribute.
	 * @see #getTexte()
	 * @generated
	 */
	void setTexte(String value);

	/**
	 * Returns the value of the '<em><b>Cible</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cible</em>' reference.
	 * @see #setCible(EObject)
	 * @see netlist.NetlistPackage#getCommentaire_Cible()
	 * @model
	 * @generated
	 */
	EObject getCible();

	/**
	 * Sets the value of the '{@link netlist.Commentaire#getCible <em>Cible</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cible</em>' reference.
	 * @see #getCible()
	 * @generated
	 */
	void setCible(EObject value);

} // Commentaire
