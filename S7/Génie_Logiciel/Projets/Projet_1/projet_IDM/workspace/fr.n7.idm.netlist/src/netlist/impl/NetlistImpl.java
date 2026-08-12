/**
 */
package netlist.impl;

import java.util.Collection;

import netlist.Commentaire;
import netlist.InstanceComposant;
import netlist.Net;
import netlist.Netlist;
import netlist.NetlistPackage;

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
 * An implementation of the model object '<em><b>Netlist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link netlist.impl.NetlistImpl#getName <em>Name</em>}</li>
 *   <li>{@link netlist.impl.NetlistImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link netlist.impl.NetlistImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link netlist.impl.NetlistImpl#getNets <em>Nets</em>}</li>
 *   <li>{@link netlist.impl.NetlistImpl#getCommentaires <em>Commentaires</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NetlistImpl extends MinimalEObjectImpl.Container implements Netlist {
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceComposant> instances;

	/**
	 * The cached value of the '{@link #getNets() <em>Nets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNets()
	 * @generated
	 * @ordered
	 */
	protected EList<Net> nets;

	/**
	 * The cached value of the '{@link #getCommentaires() <em>Commentaires</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommentaires()
	 * @generated
	 * @ordered
	 */
	protected EList<Commentaire> commentaires;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetlistImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetlistPackage.Literals.NETLIST;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetlistPackage.NETLIST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetlistPackage.NETLIST__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InstanceComposant> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<InstanceComposant>(InstanceComposant.class, this, NetlistPackage.NETLIST__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Net> getNets() {
		if (nets == null) {
			nets = new EObjectContainmentEList<Net>(Net.class, this, NetlistPackage.NETLIST__NETS);
		}
		return nets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Commentaire> getCommentaires() {
		if (commentaires == null) {
			commentaires = new EObjectContainmentEList<Commentaire>(Commentaire.class, this, NetlistPackage.NETLIST__COMMENTAIRES);
		}
		return commentaires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetlistPackage.NETLIST__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
			case NetlistPackage.NETLIST__NETS:
				return ((InternalEList<?>)getNets()).basicRemove(otherEnd, msgs);
			case NetlistPackage.NETLIST__COMMENTAIRES:
				return ((InternalEList<?>)getCommentaires()).basicRemove(otherEnd, msgs);
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
			case NetlistPackage.NETLIST__NAME:
				return getName();
			case NetlistPackage.NETLIST__DESCRIPTION:
				return getDescription();
			case NetlistPackage.NETLIST__INSTANCES:
				return getInstances();
			case NetlistPackage.NETLIST__NETS:
				return getNets();
			case NetlistPackage.NETLIST__COMMENTAIRES:
				return getCommentaires();
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
			case NetlistPackage.NETLIST__NAME:
				setName((String)newValue);
				return;
			case NetlistPackage.NETLIST__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case NetlistPackage.NETLIST__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends InstanceComposant>)newValue);
				return;
			case NetlistPackage.NETLIST__NETS:
				getNets().clear();
				getNets().addAll((Collection<? extends Net>)newValue);
				return;
			case NetlistPackage.NETLIST__COMMENTAIRES:
				getCommentaires().clear();
				getCommentaires().addAll((Collection<? extends Commentaire>)newValue);
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
			case NetlistPackage.NETLIST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NetlistPackage.NETLIST__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case NetlistPackage.NETLIST__INSTANCES:
				getInstances().clear();
				return;
			case NetlistPackage.NETLIST__NETS:
				getNets().clear();
				return;
			case NetlistPackage.NETLIST__COMMENTAIRES:
				getCommentaires().clear();
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
			case NetlistPackage.NETLIST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NetlistPackage.NETLIST__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case NetlistPackage.NETLIST__INSTANCES:
				return instances != null && !instances.isEmpty();
			case NetlistPackage.NETLIST__NETS:
				return nets != null && !nets.isEmpty();
			case NetlistPackage.NETLIST__COMMENTAIRES:
				return commentaires != null && !commentaires.isEmpty();
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
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //NetlistImpl
