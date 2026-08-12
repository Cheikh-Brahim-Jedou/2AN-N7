/**
 */
package catalog.impl;

import catalog.CatalogPackage;
import catalog.Empreinte;
import catalog.FormeFigure;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Empreinte</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link catalog.impl.EmpreinteImpl#getLargeur <em>Largeur</em>}</li>
 *   <li>{@link catalog.impl.EmpreinteImpl#getHauteur <em>Hauteur</em>}</li>
 *   <li>{@link catalog.impl.EmpreinteImpl#getForme <em>Forme</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EmpreinteImpl extends MinimalEObjectImpl.Container implements Empreinte {
	/**
	 * The default value of the '{@link #getLargeur() <em>Largeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLargeur()
	 * @generated
	 * @ordered
	 */
	protected static final double LARGEUR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLargeur() <em>Largeur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLargeur()
	 * @generated
	 * @ordered
	 */
	protected double largeur = LARGEUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getHauteur() <em>Hauteur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHauteur()
	 * @generated
	 * @ordered
	 */
	protected static final double HAUTEUR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getHauteur() <em>Hauteur</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHauteur()
	 * @generated
	 * @ordered
	 */
	protected double hauteur = HAUTEUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getForme() <em>Forme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForme()
	 * @generated
	 * @ordered
	 */
	protected static final FormeFigure FORME_EDEFAULT = FormeFigure.RECTANGLE;

	/**
	 * The cached value of the '{@link #getForme() <em>Forme</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForme()
	 * @generated
	 * @ordered
	 */
	protected FormeFigure forme = FORME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EmpreinteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CatalogPackage.Literals.EMPREINTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLargeur() {
		return largeur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLargeur(double newLargeur) {
		double oldLargeur = largeur;
		largeur = newLargeur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CatalogPackage.EMPREINTE__LARGEUR, oldLargeur, largeur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getHauteur() {
		return hauteur;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHauteur(double newHauteur) {
		double oldHauteur = hauteur;
		hauteur = newHauteur;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CatalogPackage.EMPREINTE__HAUTEUR, oldHauteur, hauteur));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FormeFigure getForme() {
		return forme;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForme(FormeFigure newForme) {
		FormeFigure oldForme = forme;
		forme = newForme == null ? FORME_EDEFAULT : newForme;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CatalogPackage.EMPREINTE__FORME, oldForme, forme));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CatalogPackage.EMPREINTE__LARGEUR:
				return getLargeur();
			case CatalogPackage.EMPREINTE__HAUTEUR:
				return getHauteur();
			case CatalogPackage.EMPREINTE__FORME:
				return getForme();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CatalogPackage.EMPREINTE__LARGEUR:
				setLargeur((Double)newValue);
				return;
			case CatalogPackage.EMPREINTE__HAUTEUR:
				setHauteur((Double)newValue);
				return;
			case CatalogPackage.EMPREINTE__FORME:
				setForme((FormeFigure)newValue);
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
			case CatalogPackage.EMPREINTE__LARGEUR:
				setLargeur(LARGEUR_EDEFAULT);
				return;
			case CatalogPackage.EMPREINTE__HAUTEUR:
				setHauteur(HAUTEUR_EDEFAULT);
				return;
			case CatalogPackage.EMPREINTE__FORME:
				setForme(FORME_EDEFAULT);
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
			case CatalogPackage.EMPREINTE__LARGEUR:
				return largeur != LARGEUR_EDEFAULT;
			case CatalogPackage.EMPREINTE__HAUTEUR:
				return hauteur != HAUTEUR_EDEFAULT;
			case CatalogPackage.EMPREINTE__FORME:
				return forme != FORME_EDEFAULT;
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
		result.append(" (largeur: ");
		result.append(largeur);
		result.append(", hauteur: ");
		result.append(hauteur);
		result.append(", forme: ");
		result.append(forme);
		result.append(')');
		return result.toString();
	}

} //EmpreinteImpl
