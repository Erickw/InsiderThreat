/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/


package br.ufrn.imd.lp2.domain;

import java.util.ArrayList;
import java.util.Set;
import br.ufrn.imd.lp2.io.Profile;
import br.ufrn.imd.lp2.io.PC;

/**
 * This class receives the Network instance and analyze the HashMap from the users and profiles. Therefore, calculate the limit of activities considered safe, if the activity is not safe, then
 * it is stored at an Arraylist.
 * */

public class ThreatDetector {
	
	/**
	 * Class constructor
	 * Empty Constructor
	 * 
	 * */
	
	public ThreatDetector() {
		
	}

	/**
	 * This Method checks from a HasMap the activities of each user, and define if it suspicious or not.
	 * @param suspects This ArrayList store all suspects users after analyze.
	 * @param tmp stores temporary keys from profiles
	 * @param userTotalactivities count all activities from each user
	 * @return Arraylist with all suspects users.
	 * 
	 * */
	public ArrayList<Profile> execute(Network r) {
		
		ArrayList<Profile> suspects = new ArrayList<Profile>();
		
		//Network r = Network.getInstance();
		Set<String> keys = r.getNetwork().keySet();
		double averageActivitiesByUser = r.getTotalActivities() / r.getTotalUsers();
		
		for (String key : keys) {
			Profile tmp = r.getNetwork().get(key);
			long userTotalActivities = 0;
			for (PC pc : tmp.getUser().getPcs()) {
				userTotalActivities += pc.getActivities().size();
			}
			if (userTotalActivities > 3*averageActivitiesByUser || userTotalActivities == 0) {
				suspects.add(tmp);
			}
		}
		return suspects;
	}
}
