/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/

package br.ufrn.imd.lp2.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class receives from the file read by network object the attributes for a user and initializes it with the date of the event. 
 * @param String id unique of the Activity 
 * @param String date Date of the Activity 
 * @param String id unique identity of the user 
 * @param String pc Personal Computer that the activity happened
 * @param String attribute Attribute from the activity
 * @param Date realDate the date that the event happened
 * 
 * */

public class Activity extends AbstractEntity{
	protected String id;
	protected String date;
	protected String userId;
	protected String pc;
	protected String attribute;
	protected Date realDate;
	protected SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Class constructor
	 * Initializes all parameters of the class and attribute it a received value
	 * 
	 * */
	
	public Activity(String id, String date, String user, String pc, String attribute) {
		this.id = id;
		this.date = date;
		this.userId = user;
		this.pc = pc;
		this.attribute = attribute;
		try {
			realDate = format.parse(date.substring(0,10));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}

	
	/**
	 * @return The id from the activity
	 * 
	 * */
	
	public String getId() {
		return id;
	}
	
	/**
	 * @set The id from the activity
	 * 
	 * */

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return The Date from the activity
	 * 
	 * */
	
	public String getDate() {
		return date;
	}
	
	/**
	 * @set The Date from the activity
	 * 
	 * */

	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * @return The Userid from the activity
	 * 
	 * */

	public String getUserId() {
		return userId;
	}
	
	/**
	 * @set The Userid from the activity
	 * 
	 * */

	public void setUserId(String user) {
		this.userId = user;
	}

	/**
	 * @return The pc from the activity
	 * 
	 * */
	
	public String getPc() {
		return pc;
	}
	
	/**
	 * @set The pc from the activity
	 * 
	 * */

	public void setPc(String pc) {
		this.pc = pc;
	}
	
	/**
	 * @return The Attribute from the activity
	 * 
	 * */

	public String getAttribute() {
		return attribute;
	}
	
	/**
	 * @set The Attribute from the activity
	 * 
	 * */


	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
	
}
