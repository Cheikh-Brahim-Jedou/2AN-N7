/**
 */
package catalog;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type Metadonnee</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see catalog.CatalogPackage#getTypeMetadonnee()
 * @model
 * @generated
 */
public enum TypeMetadonnee implements Enumerator {
	/**
	 * The '<em><b>TEXTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXTE_VALUE
	 * @generated
	 * @ordered
	 */
	TEXTE(0, "TEXTE", "TEXTE"),

	/**
	 * The '<em><b>NOMBRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOMBRE_VALUE
	 * @generated
	 * @ordered
	 */
	NOMBRE(1, "NOMBRE", "NOMBRE"),

	/**
	 * The '<em><b>BOOLEEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEEN_VALUE
	 * @generated
	 * @ordered
	 */
	BOOLEEN(2, "BOOLEEN", "BOOLEEN");

	/**
	 * The '<em><b>TEXTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXTE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEXTE_VALUE = 0;

	/**
	 * The '<em><b>NOMBRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOMBRE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOMBRE_VALUE = 1;

	/**
	 * The '<em><b>BOOLEEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOOLEEN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEEN_VALUE = 2;

	/**
	 * An array of all the '<em><b>Type Metadonnee</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TypeMetadonnee[] VALUES_ARRAY =
		new TypeMetadonnee[] {
			TEXTE,
			NOMBRE,
			BOOLEEN,
		};

	/**
	 * A public read-only list of all the '<em><b>Type Metadonnee</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TypeMetadonnee> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type Metadonnee</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypeMetadonnee get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeMetadonnee result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Metadonnee</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypeMetadonnee getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypeMetadonnee result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Metadonnee</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypeMetadonnee get(int value) {
		switch (value) {
			case TEXTE_VALUE: return TEXTE;
			case NOMBRE_VALUE: return NOMBRE;
			case BOOLEEN_VALUE: return BOOLEEN;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TypeMetadonnee(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //TypeMetadonnee
