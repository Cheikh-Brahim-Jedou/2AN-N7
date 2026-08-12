/**
 */
package catalog.impl;

import catalog.CatalogPackage;
import catalog.Composant;
import catalog.Empreinte;
import catalog.Metadonnee;
import catalog.Port;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link catalog.impl.ComposantImpl#getName <em>Name</em>}</li>
 *   <li>{@link catalog.impl.ComposantImpl#getFabricant <em>Fabricant</em>}</li>
 *   <li>{@link catalog.impl.ComposantImpl#getMetadonnees <em>Metadonnees</em>}</li>
 *   <li>{@link catalog.impl.ComposantImpl#getEmpreinte <em>Empreinte</em>}</li>
 *   <li>{@link catalog.impl.ComposantImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link catalog.impl.ComposantImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComposantImpl extends MinimalEObjectImpl.Container implements Composant {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFabricant() <em>Fabricant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFabricant()
	 * @generated
	 * @ordered
	 */
	protected static final String FABRICANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFabricant() <em>Fabricant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFabricant()
	 * @generated
	 * @ordered
	 */
	protected String fabricant = FABRICANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMetadonnees() <em>Metadonnees</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadonnees()
	 * @generated
	 * @ordered
	 */
	protected EList<Metadonnee> metadonnees;

	/**
	 * The cached value of the '{@link #getEmpreinte() <em>Empreinte</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmpreinte()
	 * @generated
	 * @ordered
	 */
	protected Empreinte empreinte;

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> ports;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CatalogPackage.Literals.COMPOSANT;
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CatalogPackage.COMPOSANT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFabricant() {
		return fabricant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFabricant(String newFabricant) {
		String oldFabricant = fabricant;
		fabricant = newFabricant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CatalogPackage.COMPOSANT__FABRICANT, oldFabricant, fabricant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Metadonnee> getMetadonnees() {
		if (metadonnees == null) {
			metadonnees = new EObjectContainmentEList<Metadonnee>(Metadonnee.class, this, CatalogPackage.COMPOSANT__METADONNEES);
		}
		return metadonnees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Empreinte getEmpreinte() {
		return empreinte;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEmpreinte(Empreinte newEmpreinte, NotificationChain msgs) {
		Empreinte oldEmpreinte = empreinte;
		empreinte = newEmpreinte;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CatalogPackage.COMPOSANT__EMPREINTE, oldEmpreinte, newEmpreinte);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEmpreinte(Empreinte newEmpreinte) {
		if (newEmpreinte != empreinte) {
			NotificationChain msgs = null;
			if (empreinte != null)
				msgs = ((InternalEObject)empreinte).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CatalogPackage.COMPOSANT__EMPREINTE, null, msgs);
			if (newEmpreinte != null)
				msgs = ((InternalEObject)newEmpreinte).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CatalogPackage.COMPOSANT__EMPREINTE, null, msgs);
			msgs = basicSetEmpreinte(newEmpreinte, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CatalogPackage.COMPOSANT__EMPREINTE, newEmpreinte, newEmpreinte));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Port> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentEList<Port>(Port.class, this, CatalogPackage.COMPOSANT__PORTS);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CatalogPackage.COMPOSANT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CatalogPackage.COMPOSANT__METADONNEES:
				return ((InternalEList<?>)getMetadonnees()).basicRemove(otherEnd, msgs);
			case CatalogPackage.COMPOSANT__EMPREINTE:
				return basicSetEmpreinte(null, msgs);
			case CatalogPackage.COMPOSANT__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CatalogPackage.COMPOSANT__NAME:
				return getName();
			case CatalogPackage.COMPOSANT__FABRICANT:
				return getFabricant();
			case CatalogPackage.COMPOSANT__METADONNEES:
				return getMetadonnees();
			case CatalogPackage.COMPOSANT__EMPREINTE:
				return getEmpreinte();
			case CatalogPackage.COMPOSANT__PORTS:
				return getPorts();
			case CatalogPackage.COMPOSANT__ID:
				return getId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CatalogPackage.COMPOSANT__NAME:
				setName((String)newValue);
				return;
			case CatalogPackage.COMPOSANT__FABRICANT:
				setFabricant((String)newValue);
				return;
			case CatalogPackage.COMPOSANT__METADONNEES:
				getMetadonnees().clear();
				getMetadonnees().addAll((Collection<? extends Metadonnee>)newValue);
				return;
			case CatalogPackage.COMPOSANT__EMPREINTE:
				setEmpreinte((Empreinte)newValue);
				return;
			case CatalogPackage.COMPOSANT__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case CatalogPackage.COMPOSANT__ID:
				setId((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CatalogPackage.COMPOSANT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CatalogPackage.COMPOSANT__FABRICANT:
				setFabricant(FABRICANT_EDEFAULT);
				return;
			case CatalogPackage.COMPOSANT__METADONNEES:
				getMetadonnees().clear();
				return;
			case CatalogPackage.COMPOSANT__EMPREINTE:
				setEmpreinte((Empreinte)null);
				return;
			case CatalogPackage.COMPOSANT__PORTS:
				getPorts().clear();
				return;
			case CatalogPackage.COMPOSANT__ID:
				setId(ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CatalogPackage.COMPOSANT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CatalogPackage.COMPOSANT__FABRICANT:
				return FABRICANT_EDEFAULT == null ? fabricant != null : !FABRICANT_EDEFAULT.equals(fabricant);
			case CatalogPackage.COMPOSANT__METADONNEES:
				return metadonnees != null && !metadonnees.isEmpty();
			case CatalogPackage.COMPOSANT__EMPREINTE:
				return empreinte != null;
			case CatalogPackage.COMPOSANT__PORTS:
				return ports != null && !ports.isEmpty();
			case CatalogPackage.COMPOSANT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", fabricant: ");
		result.append(fabricant);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //ComposantImpl
