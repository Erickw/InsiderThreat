/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/

package br.ufrn.imd.lp2.io;

/**
 * Class that get the read logs and write it into string ArrayLists
 * @param fileName string that refers the file directory 
 * */

public class Writer {
	
	private String fileName;
	
/**
 * Class Constructor
 * 
 * */	
	
	public Writer() {
		
	} 
	
	/**
	 * Overload Class Constructor
	 * Receive a string and initializes class attributes
	 * */	
			
	public Writer(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Convert and set string attribute user
	 * */
	
	public String writeUserLog(User u) {
		String str = u.getEmployeeName() + "," + u.getUserId() + "," + u.getDomain() + "," +
					 u.getEmail() + "," + u.getRole();
		return str;
	}
	
	/**
	 * Convert and set string attribute activities
	 * */
	
	public String writeActivityLog(Activity a) {
		String str = a.getId() + "," + a.getDate() + "," + a.getUserId() + "," + 
					 a.getPc() + "," + a.getPc();
		return str;
	}
	
	/**
	 * @return fileName parameter
	 * */
	
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * Receive a string and define set fileName parameter with it
	 * */

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
