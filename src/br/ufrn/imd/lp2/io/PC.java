/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/


package br.ufrn.imd.lp2.io;

import java.util.ArrayList;

/**
 * This class receives the attributes from your superclass Activity and Initializes it on your constructor.
 * @param String pcName refers to a unique pc name from the read file
 * @param ArrayList<Activity> activities Store the activities from each pc used.
 * */

public class PC extends AbstractEntity{
	private String pcName;
	protected ArrayList<Activity> activities;
	
/**
 * The constructor of class, create a new Activity ArrayList type and initializes the pcName attribute 
 * */	
	
	public PC(String pcName) {
		activities = new ArrayList<Activity>();
		this.pcName = pcName;
	}
	
/**
 * @return the content of string pcName;
 * */	

	public String getPcName() {
		return pcName;
	}
	/**
	 * @return an Arraylist of activities from the current pc object ;
	 * */		

	public ArrayList<Activity> getActivities() {
		return activities;
	}
	
	
	
}
