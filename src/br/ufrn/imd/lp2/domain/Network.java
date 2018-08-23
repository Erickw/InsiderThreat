/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/
package br.ufrn.imd.lp2.domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import br.ufrn.imd.lp2.exceptions.NotUserFoundException;
import br.ufrn.imd.lp2.io.*;

/**
 * This class take care of all profiles connected at domain 
 * @param network: Hash mapping to store each profile to a key string.
 * @param reader Object from the class Reader who read profiles from file.
 * @param networkSingleton Stores existing domains
 * 
 * */



public class Network {
	private long totalUsers;
	private long totalActivities;
	private HashMap<String, Profile> network;
	private Reader reader;
	
	public static Network networkSingleton;
	
	/**
	 * Class constructor
	 * Initializes the @param network and @param reader parameters 
	 * 
	 * */
	
	private Network() {
		network = new HashMap<String, Profile>();
		reader = new Reader();
		totalActivities = 0;
	}
	
	
	public long getTotalUsers() {
		return totalUsers;
	}


	public void setTotalUsers(long totalUsers) {
		this.totalUsers = totalUsers;
	}


	public long getTotalActivities() {
		return totalActivities;
	}

	/**
	 *  Verify @param networkSingleton is null, if not, attributes a new Network object at it.
	 *  @return returns a object that contains a domain // 
	 * */
	
	public static Network getInstance() {
		if (networkSingleton == null) {
			networkSingleton = new Network();
		}
		return networkSingleton;
	}
	
	/**
	 *  @return the HashMap of all users and keys from the domain
	 * */
	
	public HashMap<String, Profile> getNetwork() {
		return network;
	}
	
	public void setNetwork(HashMap<String, Profile> newHash) {
		HashMap<String, Profile> network = newHash;
	}
	
	/**
	 * Receives a filename, read the file from the filename received, and store into an ArrayList;
	 * @param ArraList<String[]> userLogs, store all userlogs read from the file
	 * @param User tmp Create a temporary user object to store temporarily the userId, domain, email and role read from the file and associate it with a unique user  
	 * */
	
	public void readUsers(String fileName) {
		reader.setFileName(fileName);
		ArrayList<String[]> userLogs;
		try {
			userLogs = reader.readLogs();
			for (String[] s : userLogs) {
				totalUsers++;
				User tmp = new User(s[0], s[1], s[2], s[3], s[4]);
				if (!network.containsKey(tmp.getUserId())){
					network.put(tmp.getUserId(), new Profile(tmp));
				}
			}
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	/**
	 * Receives a filename from a activities logs, read the file from the filename received, store the logs into an array and categorize the activity.
	 * @param ArraList <String[]> activityLogs store all activityLogs read from file.
	 * @param Device tmp Create a temporary Device object to store temporarily the Id, date, user, pc and attribute read from the file and associate it with a unique user
	 * @param Logon tmp Create a temporary Logon object to store temporarily the Id, date, user, pc and attribute read from the file and associate it with a unique user
	 * @param HTTP tmp Create a temporary  HTTP object to store temporarily the Id, date, user, pc and attribute read from the file and associate it with a unique user
	 *  
	 *  For every case there is an exception that verify if the user exists or not.
	 * */
	
	public void readActivities(String fileName) throws NotUserFoundException {
		reader.setFileName(fileName);
		ArrayList<String[]> activityLogs;
		try {
			activityLogs = reader.readLogs();
			for (String[] s : activityLogs) {
				totalActivities++;
				if (s[4].equals("Connect") || s[4].equals("Disconnect")) {
					Device tmp = new Device(s[0], s[1], s[2], s[3], s[4]);
					if (!network.containsKey(tmp.getUserId())) {
						throw new NotUserFoundException("User not found!");
					} else {
						network.get(tmp.getUserId()).getUser().addActivity(tmp);
					}
				} else if (s[4].equals("Logon") || s[4].equals("Logoff")) {
					Logon tmp = new Logon(s[0], s[1], s[2], s[3], s[4]);
					if (!network.containsKey(tmp.getUserId())) {
						throw new NotUserFoundException("User not found!");
					} else {
						network.get(tmp.getUserId()).getUser().addActivity(tmp);
					}
				} else {
					HTTP tmp = new HTTP(s[0], s[1], s[2], s[3], s[4]);
					if (!network.containsKey(tmp.getUserId())) {
						throw new NotUserFoundException("User not found!");
					} else {
						network.get(tmp.getUserId()).getUser().addActivity(tmp);
					}
				}
				
				
			}
		} catch (FileNotFoundException e1) {
			System.out.println(e1.getMessage());
		} 
	}
	
}
