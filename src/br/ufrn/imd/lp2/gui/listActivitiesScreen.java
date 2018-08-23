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
import java.rmi.NotBoundException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.NameNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.ufrn.imd.lp2.domain.Network;
import br.ufrn.imd.lp2.exceptions.NotUserFoundException;
import br.ufrn.imd.lp2.io.Activity;
import br.ufrn.imd.lp2.io.ActivityLabel;
import br.ufrn.imd.lp2.io.Profile;
import br.ufrn.imd.lp2.io.ReadDate;
import br.ufrn.imd.lp2.io.User;

/**This class take care of all interaction at listActivities screen
 * @param Hash, Receives a HashMap from Network instance and store it
 * @param InputID Receives a ID inputed by the user and convert it at format of the file read
 * @param InputDate Receives the first date, or unique (if the consult would per day) date inputed by the user and convert it to file read format
 * @param InputDate Receives the second date of the period to be consulted date inputed by the user and convert it to file read format
 * @param selectDay Text Field that receives user Input that indicate the day those will be listed
 * @param selectUserID Text Field that receives user Input that indicate the day those will be listed
 * @param tId Text Field that receives user Input that indicate the day those will be listed
 * @param b1 Button that confirm the option view per day inputed and calls the define day screen
 * @param b2 Button that confirm the option view per day inputed and calls the define period screen 
 **/

public class listActivitiesScreen extends JFrame{
	
	HashMap<String, Profile> hash;

	
	String InputID;
	String InputDate;
	String InputDate2;


	JTextField selectDay = new JTextField();
	JTextField selectUserID = new JTextField();
	JTextField tId  = new JTextField();


	JButton b1 = new JButton("Ver Por Dia");
	JButton b2 = new JButton("Ver Por Período");
	
	ReadDate readDate;
	ArrayList<Activity> Activities = new ArrayList();
	
	
	/**
	 * Class constructor
	 * Create the first visual screen of the listActivitiesScreen require, add all parameters into it and call the buttons manager
	 * @param container It's the container that holds the elements of the first screen class 
	 * */
	
	
	public listActivitiesScreen() throws NotUserFoundException {
		
		
		Container container = this.getContentPane();
		container.setLayout(null);  
		
		setSize(350,150);
		setTitle("Análise de Perfis de Usuários");
		tId.setBounds(190, 30, 150 , 30);
		b1.setBounds(10, 50, 150 , 50 );
		b2.setBounds(190, 50, 150 , 50 );

		container.add(b1);
		container.add(b2);
		
		buttons();		
	}
	
	/**
	 * This method manage the button class with listeners and events
	 * @param dayFrame Display window responsible to get the date and id user information.
	 * @param day Label that indicate the user where input the day to be consulted
	 * @param userId Label that indicate the user where input the userID
	 * @param confirm Button that confirm the data inputed by the user and calls the view screen
	 * @param alert Alert Window that report exception and error from the method
	 * @param activityDay Window that show every activities and their attributes from the day selected 
	 * @param labelActivityID Label that indicate the user what is the user ActivityID from the user searched
	 * @param labelActivityDate Label that indicate the user what is the user Activity Date from the user searched
	 * @param labelActivityUserID Label that indicate the user what is the user Activity userID from the user searched
     * @param labelActivityPc Label that indicate the user what is the user Activity PC from the user searched
	 * @param labelActivitAttribute Label that indicate the user what is the user Activity Attribute from the user searched
	 * @param labelArray ArrayList that contain every activities labels created to be show
	 * @param periodFrame Display window responsible to get the period and id user information.
	 * @param dateOne Label that indicate the user where input the first date of the period to be consulted
	 * @param dateTwo Label that indicate the user where input the second date of the period to be consulted 
	 * @param userID Label that indicate the user where input the userID
	 * @param firstDate TextField receives the first date, inputed by the user
	 * @param SecondDate TextField receives the first date, inputed by the user
	 * @param view Button that confirm the period inputed by the user and calls the view screen
	 * @param activityPeriod Window that show every activities and their attributes from the period selected
	 * @param alert Alert Window that report exception and error from the method
	 *  
	 * */
	
	public void  buttons(){
		
		b1.addActionListener(new ActionListener() {
			@Override
			
				public void actionPerformed(ActionEvent e) {
					
					JFrame dayFrame = new JFrame();
					
					JLabel day =  new JLabel("Selecione o dia");
					JLabel userID =  new JLabel("Digite a ID do usuário");
					
					JButton confirm = new JButton("Visualizar");
					
					try{	

						dayFrame.setLayout(null);
						dayFrame.setSize(450, 200);
						dayFrame.setTitle("Selecione o dia:");
						dayFrame.setVisible(true);
						
						dayFrame.add(selectUserID);
						dayFrame.add(selectDay);
						dayFrame.add(userID);
						dayFrame.add(day);
						dayFrame.add(confirm);
						
						
						userID.setBounds(50, 30 , 180, 30 );
						day.setBounds(300, 30, 150, 30);
						selectUserID.setBounds(50, 60 , 150, 30 );
						selectDay.setBounds(280, 60, 150, 30);
						confirm.setBounds(150, 100, 120, 30);
						selectDay.setText("dd/mm/aaaa");
						

	
					}	
					catch (Exception e1) {
						JFrame alert = new JFrame();
					    JOptionPane.showMessageDialog(alert, "Error");
					}				
					
					
					confirm.addActionListener(new ActionListener() {
						@Override
						
						public void actionPerformed(ActionEvent e) {
														
							JFrame activityDay = new JFrame ();
							JLabel labelActivityID = new JLabel("ID da Atividade");
							JLabel labelActivityDate = new JLabel("Data da Atividade");
							JLabel labelActivityUserID = new JLabel("ID do Usuaŕio da Atividade");
							JLabel labelActivityPc = new JLabel("ID do PC da Atividade");
							JLabel labelActivitAttribute = new JLabel("Atributo da Atividade");
							
							InputID = "DTAA/" + selectUserID.getText();
							InputDate = selectDay.getText();
							
							
							try {
								
								readActivitiesPerDay();
								
								ArrayList<ActivityLabel> labelArray = new ArrayList();
								
								for(int j = 0; j < Activities.size(); j++){
									
									ActivityLabel labelActivity = new  ActivityLabel(Activities.get(j).getId(), Activities.get(j).getDate(), Activities.get(j).getUserId(),
																					 Activities.get(j).getPc(), Activities.get(j).getAttribute());
									
									labelArray.add(labelActivity);
																	
									activityDay.setLayout(null);
									activityDay.setVisible(true);
									activityDay.setSize(1280 , 1024);
									activityDay.setTitle("Informações da Atividade:");
									
									activityDay.add(labelActivityID);
									activityDay.add(labelActivityDate);
									activityDay.add(labelActivityUserID);
									activityDay.add(labelActivityPc);
									activityDay.add(labelActivitAttribute);
									
									labelActivityID.setBounds(80, 10, 250, 30);
									labelActivityDate.setBounds(430, 10, 200, 30);
									labelActivityUserID.setBounds(600, 10, 200, 30);
									labelActivityPc.setBounds(870, 10, 200, 30);
									labelActivitAttribute.setBounds(1100, 10, 200, 30);
									
									for(int i = 0, k = 30; i < labelArray.size()-1; i++, k+=30){
																			
										activityDay.add(labelArray.get(i).getIdActivity());
										activityDay.add(labelArray.get(i).getDateActivity());
										activityDay.add(labelArray.get(i).getUserIdActivity());
										activityDay.add(labelArray.get(i).getPcActivity());
										activityDay.add(labelArray.get(i).getAttributeActivity());
										
										labelArray.get(i).getIdActivity().setBounds(10, k, 250, 30);
										labelArray.get(i).getDateActivity().setBounds(430, k, 200, 30);
										labelArray.get(i).getUserIdActivity().setBounds(600, k, 200, 30);
										labelArray.get(i).getPcActivity().setBounds(870, k, 200, 30);
										labelArray.get(i).getAttributeActivity().setBounds(1100, k, 200, 30);
		
									}
								}	
							}
							catch (Exception e1) {
	
							}
						}
					});
				}
			});
		
	
		b2.addActionListener(new ActionListener() {
				@Override
			
				public void actionPerformed(ActionEvent e) {
				
					JFrame periodFrame = new JFrame();
					JLabel dateOne =  new JLabel("De:");
					JLabel dateTwo =  new JLabel("Ate:");
					JLabel userID =  new JLabel("Digite a ID do usuário:");
					JTextField firstDate = new JTextField();
					JTextField secondDate = new JTextField();
					JButton view = new JButton("Visualizar");
			
					try{				
						periodFrame.setLayout(null);
						periodFrame.setSize(400, 250);
						periodFrame.setTitle("Selecione o período:");
						periodFrame.setVisible(true);
						
						periodFrame.add(userID);
						periodFrame.add(selectUserID);
						periodFrame.add(dateOne);
						periodFrame.add(dateTwo);
						periodFrame.add(firstDate);
						periodFrame.add(secondDate);
						periodFrame.add(view);
						
						
						userID.setBounds(120, 20, 180, 30);
						selectUserID.setBounds(120, 60, 150, 30);
						dateOne.setBounds(30, 130, 150, 30);
						dateTwo.setBounds(230, 130, 150, 30);
						firstDate.setBounds(70, 130, 100, 30);
						secondDate.setBounds(270, 130, 100, 30);
						view.setBounds(135, 180, 130, 30);
						firstDate.setText("dd/mm/aaaa");
						secondDate.setText("dd/mm/aaaa");
						
					}	
					catch (Exception e1) {
						JFrame alert = new JFrame();
					    JOptionPane.showMessageDialog(alert, "Error");
					}
					
					view.addActionListener(new ActionListener() {
						@Override
						
						public void actionPerformed(ActionEvent e) {
													
							JFrame activityPeriod = new JFrame ();
							JLabel labelActivityID = new JLabel("ID da Atividade");
							JLabel labelActivityDate = new JLabel("Data da Atividade");
							JLabel labelActivityUserID = new JLabel("ID do Usuaŕio da Atividade");
							JLabel labelActivityPc = new JLabel("ID do PC da Atividade");
							JLabel labelActivitAttribute = new JLabel("Atributo da Atividade");
							
							InputID = "DTAA/" + selectUserID.getText();
							InputDate = firstDate.getText();
							InputDate2 = secondDate.getText();
							
							
							try {
								
								readActivitiesPerPeriod();
								
								ArrayList<ActivityLabel> labelArray = new ArrayList();
								
								for(int j = 0; j < Activities.size(); j++){
									
									ActivityLabel labelActivity = new  ActivityLabel(Activities.get(j).getId(), Activities.get(j).getDate(), Activities.get(j).getUserId(),
																					 Activities.get(j).getPc(), Activities.get(j).getAttribute());
									
									labelArray.add(labelActivity);
									
									
									activityPeriod.setLayout(null);
									activityPeriod.setVisible(true);
									activityPeriod.setSize(1024, 350);
									activityPeriod.setTitle("Informações da Atividade:");
									
									activityPeriod.add(labelActivityID);
									activityPeriod.add(labelActivityDate);
									activityPeriod.add(labelActivityUserID);
									activityPeriod.add(labelActivityPc);
									activityPeriod.add(labelActivitAttribute);					
													
									labelActivityID.setBounds(80, 10, 250, 30);
									labelActivityDate.setBounds(430, 10, 200, 30);
									labelActivityUserID.setBounds(600, 10, 200, 30);
									labelActivityPc.setBounds(870, 10, 200, 30);
									labelActivitAttribute.setBounds(1100, 10, 200, 30);
					
									
									for(int i = 0, k = 30; i < labelArray.size()-1; i++, k+=30){
										
										
										activityPeriod.add(labelArray.get(i).getIdActivity());
										activityPeriod.add(labelArray.get(i).getDateActivity());
										activityPeriod.add(labelArray.get(i).getUserIdActivity());
										activityPeriod.add(labelArray.get(i).getPcActivity());
										activityPeriod.add(labelArray.get(i).getAttributeActivity());
										
										labelArray.get(i).getIdActivity().setBounds(10, k, 250, 30);
										labelArray.get(i).getDateActivity().setBounds(430, k, 200, 30);
										labelArray.get(i).getUserIdActivity().setBounds(600, k, 200, 30);
										labelArray.get(i).getPcActivity().setBounds(870, k, 200, 30);
										labelArray.get(i).getAttributeActivity().setBounds(1100, k, 200, 30);
										
									}
								}
							} catch (Exception e1) {
	
							  }
						}
					});	
				}
			});
	}
	
	
	
	/**
	 * This method receives the HashMap from the Network instance, and attribute the local HashMap to it
	 * @param hash HashMap that receive a HashMap from Network instance;
	 * */

	public void setHash(HashMap<String, Profile> r){
			hash = r;
	}
	
	/**
	 * This method creates a new readDate instance and add all activities at Activities ArrayList from the InputDate day
	 * @param readDate instance of readDate that convert the inputed data into date format
	 * */

	public void readActivitiesPerDay() throws ParseException{
		
		readDate = new ReadDate(InputDate);
	
		for(int i = 0; i < hash.get(InputID).groupingActivitiesByDay(readDate.getFirstDate()).size(); i++ ){
			Activities.add(hash.get(InputID).groupingActivitiesByDay(readDate.getFirstDate()).get(i));	
		}	
	}
	
	/**
	 * This method creates a new readDate instance and add all activities at Activities ArrayList from the InputDate period
	 * @param readDate instance of readDate that convert the inputed data into date format
	 * */
	
	public void readActivitiesPerPeriod() throws ParseException{
		
		readDate = new ReadDate(InputDate, InputDate2);

		for(int i = 0; i < hash.get(InputID).groupingActivitiesByPeriod(readDate.getFirstDate(), readDate.getSecondDate()).size(); i++ ){
			Activities.add(hash.get(InputID).groupingActivitiesByPeriod(readDate.getFirstDate(), readDate.getSecondDate()).get(i));			
		}
	}
}
