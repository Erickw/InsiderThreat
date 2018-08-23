/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/
package br.ufrn.imd.lp2.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.ufrn.imd.lp2.domain.Network;
import br.ufrn.imd.lp2.domain.ThreatDetector;
import br.ufrn.imd.lp2.exceptions.NotUserFoundException;
import br.ufrn.imd.lp2.io.Profile;
import br.ufrn.imd.lp2.io.User;


/**
* This class take care of all interaction at list suspects screen
* @param r Attribute that allocate Network Instance
* @param Hash, Receives a HashMap from Network instance and store it
* @param b1 Button that confirm the option to list all suspects users
* */

public class suspectScreen extends JFrame{
	
	
	HashMap<String, Profile> hash;

	Network r = Network.getInstance();
	
	/**
	 * Class constructor
	 * Initializes create a new screen and with a ThreatDetector instance list all suspect users
	 * @param scroll ScroolPane to down or up the list
	 * @param frame Frame that show the list of all suspect users
	 * @param detectSuspects instance of ThreatDetector
	 * @param listModel list that get all suspects users
	 * @param suspectsList visual element that get the listModel and show the list at frame
	 * @param alert Alert Window that report exception and error from the method
	 * */
	


	public suspectScreen() throws NotUserFoundException {

		JScrollPane scroll = new JScrollPane(this.getContentPane());
		JFrame frame = new JFrame();
	
		ThreatDetector detectSuspects = new ThreatDetector();
	
		DefaultListModel<String> listModel = new DefaultListModel<>();
    
		
		for(int i = 0; i < detectSuspects.execute(r).size(); i++ ){
			
			listModel.addElement(detectSuspects.execute(r).get(i).getUser().getEmployeeName());
			
		}
		
		JList<String> countryList = new JList<>(listModel);
	
		frame.setSize(350,230);
		frame.setTitle("Análise de Perfis de Usuários");
		frame.add(countryList);
		frame.add(new JScrollPane(countryList));
		frame.setVisible(true);

	}

}