/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/

package br.ufrn.imd.lp2.io;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class extends AbstractEntity and initiate all attributes of the user
 * @param employeeName Refers to name of the company user read from the logfile
 * @param userID Refers to Identification code of the company user read from the logfile
 * @param domain Refers to domain of the company user read from the logfile
 * @param email Refers to email of the company user read from the logfile
 * @param role Refers to role of the company user read from the logfile
 * */

public class User extends AbstractEntity{
	
	private ArrayList<PC> pcs;
	
	private String employeeName;
	private String userId;
	private String domain;
	private String email;
	private String role;
	
	/**
	 * Class constructor
	 * Receives strings attributes and initiate the attribute classes with it 
	 * */
	
	public User(String employeeName, String userId, String domain, String email, String role) {
		pcs = new ArrayList<PC>();
		this.employeeName = employeeName;
		this.userId = userId;
		this.domain = domain;
		this.email = email;
		this.role = role;
		this.generateId();
	}
	
	/**
	 * Adds the company domain at each user ID
	 * */

	private void generateId() {
		userId = "DTAA/" + userId;
	}
	
	/**
	 * @return employeeName attribute
	 * */
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	/**
	 * @return UserId attribute
	 * */
	

	public String getUserId() {
		return userId;
	}
	
	/**
	 * @return Domain attribute
	 * */

	public String getDomain() {
		return domain;
	}
	
	/**
	 * @return email attribute
	 * */

	public String getEmail() {
		return email;
	}
	
	/**
	 * @return role attribute
	 * */

	public String getRole() {
		return role;
	}
	
	/**
	 * @return pcs attribute
	 * */	
	
	public ArrayList<PC> getPcs() {
		return pcs;
	}

	/**
	 * Add Activities to a user pc 
	 * */
	
	public void addActivity(Activity a) {
		PC tmp = new PC(a.getPc());
		if (!pcs.contains(tmp)) {
			pcs.add(tmp);
		}
		pcs.get(pcs.indexOf(tmp)).activities.add(a);
	}
	
	/**
	 * Receives a date Attribute
	 *  @return the Arraylist of all activities grouped by day
	 * */
	
	public ArrayList<Activity> groupingActivitiesByDay(Date day) {
		ArrayList<Activity> tmp = new ArrayList<Activity>();
		for (PC pc : this.pcs) {
			for (Activity act : pc.activities) {
				if (day.compareTo(act.realDate) == 0) {
					tmp.add(act);
				}
			}
		}
		return tmp;
	}
	
	/**
	 * Receives a date Attribute
	 *  @return the Arraylist of all activities grouped by period
	 * */

	
	public ArrayList<Activity> groupingActivitiesByPeriod(Date begin, Date end) {
		ArrayList<Activity> tmp = new ArrayList<Activity>();
		for (PC pc : this.pcs) {
			for (Activity act : pc.activities) {
				if (begin.compareTo(act.realDate) == 0 || end.compareTo(act.realDate) == 0 || 
						(begin.before(act.realDate) && end.after(act.realDate))) {
					tmp.add(act);
				}
			}
		}
		return tmp;
	}
	
	/**
	 * Receives a date Attribute
	 *  @return the Arraylist of all activities
	 * */
	
	public ArrayList<Activity> groupingAllActivities() {
		ArrayList<Activity> tmp = new ArrayList<Activity>();
		for (PC pc : this.pcs) {
			for (Activity act : pc.activities) {
				tmp.add(act);
			}
		}
		return tmp;
	}
}
