/**
 */
package netlist.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import netlist.Netlist;
import netlist.NetlistFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Netlist</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NetlistTest extends TestCase {

	/**
	 * The fixture for this Netlist test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Netlist fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NetlistTest.class);
	}

	/**
	 * Constructs a new Netlist test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetlistTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Netlist test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Netlist fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Netlist test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Netlist getFixture() {
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
		setFixture(NetlistFactory.eINSTANCE.createNetlist());
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

} //NetlistTest
