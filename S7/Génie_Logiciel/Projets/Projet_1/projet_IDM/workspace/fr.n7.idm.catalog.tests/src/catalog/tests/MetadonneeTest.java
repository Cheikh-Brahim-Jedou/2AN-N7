/**
 */
package catalog.tests;

import catalog.CatalogFactory;
import catalog.Metadonnee;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Metadonnee</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetadonneeTest extends TestCase {

	/**
	 * The fixture for this Metadonnee test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Metadonnee fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(MetadonneeTest.class);
	}

	/**
	 * Constructs a new Metadonnee test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetadonneeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Metadonnee test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Metadonnee fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Metadonnee test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Metadonnee getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(CatalogFactory.eINSTANCE.createMetadonnee());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //MetadonneeTest
