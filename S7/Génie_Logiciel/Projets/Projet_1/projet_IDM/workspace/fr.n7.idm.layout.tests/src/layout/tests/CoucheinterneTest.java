/**
 */
package layout.tests;

import junit.textui.TestRunner;

import layout.Coucheinterne;
import layout.LayoutFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Coucheinterne</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoucheinterneTest extends CoucheTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CoucheinterneTest.class);
	}

	/**
	 * Constructs a new Coucheinterne test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoucheinterneTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Coucheinterne test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Coucheinterne getFixture() {
		return (Coucheinterne)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(LayoutFactory.eINSTANCE.createCoucheinterne());
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

} //CoucheinterneTest
