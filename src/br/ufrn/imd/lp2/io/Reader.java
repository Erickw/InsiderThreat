/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/
package br.ufrn.imd.lp2.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class read the file with all data necessary to all classes 
 * 
 * @param String store the filename from the which will be read 
 * */


public class Reader {

	private String fileName;
	
	
/**
 * 	Overloaded constructor of the class, 
 */
	public Reader() {
		
	}
	
	/**
	 * Constructor class
	 * Attribute received string filename and set it to class attribute
	 * */
	public Reader(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * This method read the logs files per line, covert it into string and return a array with all string reade
	 * @param scan open and read the file
	 * @param tmp Store the strings read from  the file
	 * @return Arraylist with all the lines read and converted into strings
	 * */

	public ArrayList<String> readCSVLines() throws FileNotFoundException {
		Scanner scan = new Scanner(new File(fileName));
		ArrayList<String> tmp = new ArrayList<String>();
		while (scan.hasNextLine()){
			tmp.add(scan.nextLine());
		}
		scan.close();
		return tmp;
	}
	
	/**
	 * Filter the data from readCSVLines into columns and set it to each user
	 * @param Base ArrayList with strings read from the file
	 * @param ans ArrayList with the strings corrected filtered by column
	 * @return An user ArrayList with all attributes separated by column 
	 * */
	
	public ArrayList<String[]> readLogs() throws FileNotFoundException{
		ArrayList<String> base = readCSVLines();
		ArrayList<String[]> ans = new ArrayList<String[]>();
		for (String s : base) {
			String help[] = s.split(",");
			ans.add(help);
		}
		return ans;
	}
	/**
	 * @return filename Attribute
	 * */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * @set filename Attribute
	 * */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
