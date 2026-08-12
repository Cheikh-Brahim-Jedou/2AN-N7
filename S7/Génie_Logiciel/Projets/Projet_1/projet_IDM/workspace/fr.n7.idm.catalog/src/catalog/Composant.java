/**
 */
package catalog;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link catalog.Composant#getName <em>Name</em>}</li>
 *   <li>{@link catalog.Composant#getFabricant <em>Fabricant</em>}</li>
 *   <li>{@link catalog.Composant#getMetadonnees <em>Metadonnees</em>}</li>
 *   <li>{@link catalog.Composant#getEmpreinte <em>Empreinte</em>}</li>
 *   <li>{@link catalog.Composant#getPorts <em>Ports</em>}</li>
 *   <li>{@link catalog.Composant#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see catalog.CatalogPackage#getComposant()
 * @model
 * @generated
 */
public interface Composant extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see catalog.CatalogPackage#getComposant_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link catalog.Composant#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Fabricant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fabricant</em>' attribute.
	 * @see #setFabricant(String)
	 * @see catalog.CatalogPackage#getComposant_Fabricant()
	 * @model required="true"
	 * @generated
	 */
	String getFabricant();

	/**
	 * Sets the value of the '{@link catalog.Composant#getFabricant <em>Fabricant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fabricant</em>' attribute.
	 * @see #getFabricant()
	 * @generated
	 */
	void setFabricant(String value);

	/**
	 * Returns the value of the '<em><b>Metadonnees</b></em>' containment reference list.
	 * The list contents are of type {@link catalog.Metadonnee}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metadonnees</em>' containment reference list.
	 * @see catalog.CatalogPackage#getComposant_Metadonnees()
	 * @model containment="true"
	 * @generated
	 */
	EList<Metadonnee> getMetadonnees();

	/**
	 * Returns the value of the '<em><b>Empreinte</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Empreinte</em>' containment reference.
	 * @see #setEmpreinte(Empreinte)
	 * @see catalog.CatalogPackage#getComposant_Empreinte()
	 * @model containment="true"
	 * @generated
	 */
	Empreinte getEmpreinte();

	/**
	 * Sets the value of the '{@link catalog.Composant#getEmpreinte <em>Empreinte</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Empreinte</em>' containment reference.
	 * @see #getEmpreinte()
	 * @generated
	 */
	void setEmpreinte(Empreinte value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link catalog.Port}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see catalog.CatalogPackage#getComposant_Ports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Port> getPorts();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see catalog.CatalogPackage#getComposant_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link catalog.Composant#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // Composant
