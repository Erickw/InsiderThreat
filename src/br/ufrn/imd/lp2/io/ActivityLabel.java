/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 */

package br.ufrn.imd.lp2.io;

import javax.swing.JLabel;

/**
* This class manage the labels that are used to list all activities per period and day
* @param idActivity Label that indicate the user what is the user ActivityID from the user searched
* @param dateActivityLabel that indicate the user what is the user Activity Date from the user searched
* @param userIdActivity Label that indicate the user what is the user Activity userID from the user searched
* @param pcActivity Label that indicate the user what is the user Activity PC from the user searched
* @param attributeActivity Label that indicate the user what is the user Activity Attribute from the user searched
* */


public class ActivityLabel {

	JLabel idActivity = new JLabel ();
	JLabel dateActivity = new JLabel ();

	JLabel userIdActivity = new JLabel ();
	JLabel pcActivity = new JLabel ();
	JLabel attributeActivity = new JLabel ();
	
	/**
	 * Class Constructor
	 * The method receives attributes and Initializes all class attributes 
	 * 
	 * */
	
	public ActivityLabel(String Id, String date, String userId, String pc, String attribute ) {
		
		this.idActivity.setText(Id);
		this.dateActivity.setText(date);
		this.userIdActivity.setText(userId);
		this.pcActivity.setText(pc);
		this.attributeActivity.setText(attribute);
		
	}

	
/*
 * This method return a Id Activity label of class
 * */	
	
	public JLabel getIdActivity() {
		return idActivity;
	}
	
	/*
	 * This method receive a Id Activity label and attribute it to class ID Activity
	 * */

	public void setIdActivity(JLabel idActivity) {
		this.idActivity = idActivity;
	}
	
	/*
	 * This method return a date Activity label of class
	 * */	

	public JLabel getDateActivity() {
		return dateActivity;
	}
	
	/*
	 * This method receive a Id Activity label and attribute it to class date Activity
	 * */

	public void setDateActivity(JLabel dateActivity) {
		this.dateActivity = dateActivity;
	}

	/*
	 * This method return a UserId Activity label of class
	 * */	
	
	public JLabel getUserIdActivity() {
		return userIdActivity;
	}
	
	/*
	 * This method receive a Id Activity label and attribute it to class userID Activity
	 * */

	public void setUserIdActivity(JLabel userIdActivity) {
		this.userIdActivity = userIdActivity;
	}
	
	/*
	 * This method return a PCActivitylabel  of class
	 * */	

	public JLabel getPcActivity() {
		return pcActivity;
	}
	
	/*
	 * This method receive a Id Activity label and attribute it to class PC Activity
	 * */

	public void setPcActivity(JLabel pcActivity) {
		this.pcActivity = pcActivity;
	}
	
	/*
	 * This method return a Attribute Activity label of class
	 * */	

	public JLabel getAttributeActivity() {
		return attributeActivity;
	}
	
	/*
	 * This method receive a Id Activity label and attribute it to class Attribute Activity
	 * */

	public void setAttributeActivity(JLabel attributeActivity) {
		this.attributeActivity = attributeActivity;
	}

}
