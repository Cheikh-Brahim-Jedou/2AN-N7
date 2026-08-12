/**
 */
package catalog;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Forme Figure</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see catalog.CatalogPackage#getFormeFigure()
 * @model
 * @generated
 */
public enum FormeFigure implements Enumerator {
	/**
	 * The '<em><b>RECTANGLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECTANGLE_VALUE
	 * @generated
	 * @ordered
	 */
	RECTANGLE(0, "RECTANGLE", "RECTANGLE"),

	/**
	 * The '<em><b>CERCLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CERCLE_VALUE
	 * @generated
	 * @ordered
	 */
	CERCLE(1, "CERCLE", "CERCLE"),

	/**
	 * The '<em><b>PERSONNALISE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PERSONNALISE_VALUE
	 * @generated
	 * @ordered
	 */
	PERSONNALISE(2, "PERSONNALISE", "PERSONNALISE");

	/**
	 * The '<em><b>RECTANGLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECTANGLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RECTANGLE_VALUE = 0;

	/**
	 * The '<em><b>CERCLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CERCLE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CERCLE_VALUE = 1;

	/**
	 * The '<em><b>PERSONNALISE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PERSONNALISE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PERSONNALISE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Forme Figure</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FormeFigure[] VALUES_ARRAY =
		new FormeFigure[] {
			RECTANGLE,
			CERCLE,
			PERSONNALISE,
		};

	/**
	 * A public read-only list of all the '<em><b>Forme Figure</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FormeFigure> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Forme Figure</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FormeFigure get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FormeFigure result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Forme Figure</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FormeFigure getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FormeFigure result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Forme Figure</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FormeFigure get(int value) {
		switch (value) {
			case RECTANGLE_VALUE: return RECTANGLE;
			case CERCLE_VALUE: return CERCLE;
			case PERSONNALISE_VALUE: return PERSONNALISE;
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
	private FormeFigure(int value, String name, String literal) {
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
	
} //FormeFigure
