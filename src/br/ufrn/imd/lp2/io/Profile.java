/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/

package br.ufrn.imd.lp2.io;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class create a new user and associate it to a profile.
 * @param User user new user created to be associate to a profile 
 * */

public class Profile {
	private User user;
	
	/**
	 * Constructor class Initializes the received user with the current profile.
	 * */
	public Profile(User user) {
		this.user = user;
	}

	/**
	 * @return the current user from the Profile object
	 * */
	
	public User getUser() {
		return user;
	}
	/**
	 * @set a new user to the current profile
	 * */

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * Receives a date Attribute
	 *  @return the Arraylist of all activities grouped by day
	 * */
	
	public ArrayList<Activity> groupingActivitiesByDay(Date day) {
		return this.user.groupingActivitiesByDay(day);
	}
	
	/**
	 * Receives a date Attribute
	 *  @return the Arraylist of all activities grouped by period
	 * */
	public ArrayList<Activity> groupingActivitiesByPeriod(Date begin, Date end) {
		return this.user.groupingActivitiesByPeriod(begin, end);		
	}
	
	/**
	 * Receives a date Attribute
	 *  @return the Arraylist of all activities
	 * */
	public ArrayList<Activity> groupingAllActivities() {
		return this.user.groupingAllActivities();
	}
	
}