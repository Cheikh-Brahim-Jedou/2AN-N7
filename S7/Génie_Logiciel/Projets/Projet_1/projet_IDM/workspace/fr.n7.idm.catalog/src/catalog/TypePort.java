/**
 */
package catalog;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Type Port</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see catalog.CatalogPackage#getTypePort()
 * @model
 * @generated
 */
public enum TypePort implements Enumerator {
	/**
	 * The '<em><b>ENTREE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTREE_VALUE
	 * @generated
	 * @ordered
	 */
	ENTREE(0, "ENTREE", "ENTREE"),

	/**
	 * The '<em><b>SORTIE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SORTIE_VALUE
	 * @generated
	 * @ordered
	 */
	SORTIE(1, "SORTIE", "SORTIE"),

	/**
	 * The '<em><b>BIDIRECTIONNEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIDIRECTIONNEL_VALUE
	 * @generated
	 * @ordered
	 */
	BIDIRECTIONNEL(2, "BIDIRECTIONNEL", "BIDIRECTIONNEL"),

	/**
	 * The '<em><b>ALIMENTATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALIMENTATION_VALUE
	 * @generated
	 * @ordered
	 */
	ALIMENTATION(3, "ALIMENTATION", "ALIMENTATION"),

	/**
	 * The '<em><b>MASSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASSE_VALUE
	 * @generated
	 * @ordered
	 */
	MASSE(4, "MASSE", "MASSE"),

	/**
	 * The '<em><b>NON CONNECTE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_CONNECTE_VALUE
	 * @generated
	 * @ordered
	 */
	NON_CONNECTE(5, "NON_CONNECTE", "NON_CONNECTE");

	/**
	 * The '<em><b>ENTREE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTREE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENTREE_VALUE = 0;

	/**
	 * The '<em><b>SORTIE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SORTIE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SORTIE_VALUE = 1;

	/**
	 * The '<em><b>BIDIRECTIONNEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BIDIRECTIONNEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BIDIRECTIONNEL_VALUE = 2;

	/**
	 * The '<em><b>ALIMENTATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ALIMENTATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ALIMENTATION_VALUE = 3;

	/**
	 * The '<em><b>MASSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASSE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MASSE_VALUE = 4;

	/**
	 * The '<em><b>NON CONNECTE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_CONNECTE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NON_CONNECTE_VALUE = 5;

	/**
	 * An array of all the '<em><b>Type Port</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TypePort[] VALUES_ARRAY =
		new TypePort[] {
			ENTREE,
			SORTIE,
			BIDIRECTIONNEL,
			ALIMENTATION,
			MASSE,
			NON_CONNECTE,
		};

	/**
	 * A public read-only list of all the '<em><b>Type Port</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TypePort> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Type Port</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypePort get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypePort result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Port</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypePort getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TypePort result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Type Port</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static TypePort get(int value) {
		switch (value) {
			case ENTREE_VALUE: return ENTREE;
			case SORTIE_VALUE: return SORTIE;
			case BIDIRECTIONNEL_VALUE: return BIDIRECTIONNEL;
			case ALIMENTATION_VALUE: return ALIMENTATION;
			case MASSE_VALUE: return MASSE;
			case NON_CONNECTE_VALUE: return NON_CONNECTE;
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
	private TypePort(int value, String name, String literal) {
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
	
} //TypePort
