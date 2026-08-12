
/* ------------------------------------------------------- 
		Les packages Java qui doivent etre importes.
*/
import java.awt.*;
import java.awt.event.*;
import java.rmi.*;
import javax.swing.*;

/* ------------------------------------------------------- 
		Implementation de l'application
*/

public class GUI extends JFrame {
	TextField name, email;
	Choice pads;
	Label message;
	
	public GUI() {
		setSize(300,200);
		setLayout(new GridLayout(6,2));
		add(new Label("  Name : "));
		name = new TextField(30);
		add(name);
		add(new Label("  Email : "));
		email = new TextField(30);
		add(email);
		add(new Label("  Pad : "));
		pads = new Choice();
		pads.addItem("Pad1");
		pads.addItem("Pad2");
		add(pads);
		add(new Label(""));
		add(new Label(""));
		Button Abutton = new Button("add");
		Abutton.addActionListener(new AButtonAction());
		add(Abutton);
		Button Cbutton = new Button("consult");
		Cbutton.addActionListener(new CButtonAction());
		add(Cbutton);
		message = new Label();
		add(message);
	}

	class AButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String n, e, c;
			n = name.getText();
			e = email.getText();
			c = pads.getSelectedItem();
			message.setText("add("+n+","+e+","+c+")");
			
			try {
				// Créer un objet SRecordImpl avec les données
				SRecordImpl sr = new SRecordImpl(n, e);
				
				// Récupérer le serveur sélectionné directement via RMI lookup
				Pad selectedPad = (Pad)Naming.lookup("//localhost/" + c);
				
				if (selectedPad != null) {
					// Appeler la méthode add() à distance
					selectedPad.add(sr);
					message.setText("Personne ajoutée avec succès sur " + c);
				}
				
			} catch (RemoteException re) {
				message.setText("Erreur RMI lors de l'ajout: " + re.getMessage());
				re.printStackTrace();
			} catch (NotBoundException nbe) {
				message.setText("Serveur " + c + " non trouvé dans le registry");
				nbe.printStackTrace();
			} catch (Exception ex) {
				message.setText("Erreur: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	class CButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String n, c;
			n = name.getText();
			c = pads.getSelectedItem();
			message.setText("consult("+n+","+c+")        ");
			
			try {
				// Récupérer le serveur sélectionné directement via RMI lookup
				Pad selectedPad = (Pad)Naming.lookup("//localhost/" + c);
				
				if (selectedPad != null) {
					// Appeler consult() avec forward=true pour permettre la propagation
					RRecord result = selectedPad.consult(n, true);
					
					if (result != null) {
						// Récupérer les informations via des appels distants
						String foundName = result.getName();
						String foundEmail = result.getEmail();
						message.setText("Trouvé: " + foundName + " - " + foundEmail);
					} else {
						message.setText("Personne non trouvée sur " + c);
					}
				}
				
			} catch (RemoteException re) {
				message.setText("Erreur RMI lors de la recherche: " + re.getMessage());
				re.printStackTrace();
			} catch (NotBoundException nbe) {
				message.setText("Serveur " + c + " non trouvé dans le registry");
				nbe.printStackTrace();
			} catch (Exception ex) {
				message.setText("Erreur: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		GUI s = new GUI();
        s.setSize(400,200);
        s.setVisible(true);
		
		
	}
}


