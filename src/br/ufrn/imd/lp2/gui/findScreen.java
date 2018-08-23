/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/


package br.ufrn.imd.lp2.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import br.ufrn.imd.lp2.domain.Network;
import br.ufrn.imd.lp2.exceptions.NotUserFoundException;
import br.ufrn.imd.lp2.io.Profile;
import br.ufrn.imd.lp2.io.User;

/**
 * This class take care of all interaction at find screen
 * @param Hash, Receives a HashMap from Network instance and store it
 * @param InputID Receives a ID inputed by the user and convert it at format of the file read
 * @param verifySearch, Boolean parameter that verify if the user was found, if not, a Error pop appears and the following screens does not open.
 * @param id Label that indicate the user where input the user ID
 * @param id2 Label that indicate the user what is the user Id from the user searched
 * @param name2 Label that indicate the user what is the user name from the user searched
 * @param domain2 Label that indicate the user what is the user domain from the user searched
 * @param email2 Label that indicate the user what is the user email from the user searched
 * @param role2 Label that indicate the user what is the user role from the user searched
 * @param tId TextField that receives user Input that indicate the userID those will be find
 * @param b1 Button that confirm the userID inputed and calls the find screen 
 * */


public class findScreen extends JFrame{
	
	
	HashMap<String, Profile> hash;

	String InputID;
	
	boolean verifySearch = true;
	
	JLabel id =  new JLabel("Digite a ID do usuário:");
	JLabel id2 = new JLabel ();
	JLabel name2 = new JLabel ();	
	JLabel domain2 = new JLabel ();
	JLabel email2 = new JLabel ();
	JLabel role2 = new JLabel ();
			
	JTextField tId  = new JTextField();

	JButton b1 = new JButton("Buscar");

	
/**
 * Class constructor
 * Create the first visual screen of the findScreen require, add all parameters into it and call the buttons manager
 * @param container It's the container that holds the elements of the first screen class 
 * */
	
	
	public findScreen() throws NotUserFoundException {
		
		
		Container container = this.getContentPane();
		container.setLayout(null);
		
		setSize(350,150);
		setTitle("Análise de Perfis de Usuários");
		tId.setBounds(190, 30, 150 , 30);
		b1.setBounds(190, 80, 150 , 50 );
		id.setBounds(10, 25 ,200,30);
		
		container.add(b1);
		container.add(id);
		container.add(tId);
		container.add(b1);

		buttons();

	}
	
	/**
	 * This method manage the button class with listeners and events
	 * @param InputID Receives a ID inputed by the user, attribute the domain of user and convert it at format of the file read
	 * @param name Label that indicate the user where input the user name
	 * @param id Label that indicate the user where input the user ID
	 * @param domain Label that indicate the user where input the user domain
	 * @param email Label that indicate the user where input the user email
	 * @param role Label that indicate the user where input the user role
	 * @param frame Windows that display the info from the user searched
	 * @param alert Alert Window that report exception and error from the method
	 *  
	 * */
	
public void  buttons(){
	
	
	b1.addActionListener(new ActionListener() {
		@Override
		
			public void actionPerformed(ActionEvent e) {
				
				String InputID = tId.getText();
				InputID = "DTAA/" + tId.getText();
				JLabel name =  new JLabel("Nome:");
				JLabel id =  new JLabel("ID:");
				JLabel domain =  new JLabel("Dominio:");
				JLabel email =  new JLabel("Email");
				JLabel role =  new JLabel("Cargo:");

				try{				
					
					findUser(InputID);

					JFrame frame = new JFrame();
					
					frame.setLayout(null);
					name.setBounds(10, 20 ,100,30);
					id.setBounds(10, 50 , 100, 30);
					domain.setBounds(10 , 80 , 100,30);
					email.setBounds(10,110,110,30);
					role.setBounds(10, 140, 100 , 30);
					
					name2.setBounds(80,20,300,30);
					id2.setBounds(50,50,100,30);
					domain2.setBounds(80,80 ,100,30);
					email2.setBounds(80,110,200,30);
					role2.setBounds(80, 130, 220 , 50);
					
					frame.setVisible(true);
					frame.setTitle("Informações do Usuário");
					frame.setSize(350,230);
					
					frame.add(name);
					frame.add(id);
					frame.add(domain);
					frame.add(email);
					frame.add(role);
					frame.add(name2);
					frame.add(id2);
					frame.add(domain2);
					frame.add(email2);
					frame.add(role2);
					
					if(!verifySearch){
						frame.dispose();
					}
					
				}	
				catch (Exception e1) {
					JFrame alert = new JFrame();
				    JOptionPane.showMessageDialog(alert, "Error");
				}

			}
		}
	);
}
		
	/**
	 * This method receives the HashMap from the Network instance, and attribute the local HashMap to it
	 * @param hash HashMap that receive a HashMap from Network instance;
	 * */

	public void setHash(HashMap<String, Profile> r){
			hash = r;		
	}
	
	/**
	 * This method returns the local HashMap
	 * @return Local HashMap String, Profile type
	 * */
	
	public HashMap<String, Profile> getHash(){
		return hash;
	}	
	
	
	/**
	 * Method that verify from a given entry received if a user exists at HashMap network and find this user. If it, it calls the method setLabel passing the read attributes
	 * from the user searched. If not, then the method defines the attribute verifySearch to false
	 * @param alert Alert Window that report exception and error from the method
	 * 
	 * */
	
	public void findUser (String key){
		
		
		try{
			if (!hash.containsKey(key)){
				throw new NotUserFoundException("Usuário não encontrado");
			}
			
			setLabel(hash.get(key).getUser().getEmployeeName(), hash.get(key).getUser().getUserId(), hash.get(key).getUser().getDomain(),
					 hash.get(key).getUser().getEmail(),hash.get(key).getUser().getRole());
			
		}catch(NotUserFoundException e1){
			JFrame alert = new JFrame();
		    JOptionPane.showMessageDialog(alert, "Usuário não encontrado");
		    verifySearch = false;
			
		}
	}
	
	/**
	 * This method receive all user read informations and set it to labels to be showed at user info window
	 * */
	
	public void setLabel(String name, String id, String domain, String email, String role){
			
		name2.setText(name);
		id2.setText(id);
		domain2.setText(domain);
		email2.setText(email);
		role2.setText(role);
	}
}
