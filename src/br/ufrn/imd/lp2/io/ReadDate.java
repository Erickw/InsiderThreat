/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/
package br.ufrn.imd.lp2.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class create two date and attribute it with a String Received 
 * */

public class ReadDate {
	
	Date Dt = new Date();
	Date Dt2 = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
/**
 * Class Constructor
 * 
 *  Receives a date string and convert it to a date type
 * */	
	public ReadDate(String FirstDate) throws ParseException {

		Dt =  sdf.parse(FirstDate);
		//System.out.println("Data do dt: " + Dt);
	}
	
	/**
	 * Overload Class Constructor
	 * 
	 *  Receives two date strings and convert it to a date type
	 * */	
	
	
	public ReadDate(String FirstDate, String SecondDate) throws ParseException {

		Dt =  sdf.parse(FirstDate);
		Dt2 = sdf.parse(SecondDate);
		System.out.println("Data do dt: " + Dt);
	}
	
	/**
	 * @return dt class attribute
	 * */
	
	public Date getFirstDate(){	
		return Dt;
	}
	
	/**
	 * @return dt2 class attribute
	 * */
	
	public Date getSecondDate(){
		return Dt2;
	}

}
