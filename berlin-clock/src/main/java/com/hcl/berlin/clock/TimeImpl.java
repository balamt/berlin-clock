/**
 * 
 */
package com.hcl.berlin.clock;


/**
 * @author training
 *
 */
public class TimeImpl implements Time {

	String currentTime;
	TimeVO timevo;
	
	public TimeImpl() {
		currentTime = new java.sql.Time(System.currentTimeMillis()).toString();
		splitTime();
	}
	
	
	public String getBerlinSeconds() {
		// TODO get the value and return the On or Off Status
		int seconds = Integer.parseInt(timevo.getSecond());

		if (seconds % 2 == 0)
			return "O";

		return "Y";
	}

	/**
	 * SplitTime - To Split the Time and Return the TimeVO
	 */
	public void splitTime() {
		timevo = new TimeVO();
		String[] timeArray = currentTime.split(":");
		timevo.setHour(timeArray[0]);
		timevo.setMinute(timeArray[1]);
		timevo.setSecond(timeArray[2]);
	}

	
	/**
	 * Will get the System Time and Return as String
	 * Return is the format "HH:MM:SS"
	 * @return String
	 */
	public String currentTime() {
		//return ;
		return null;
	}


	public String getBerlinHour() {
		int hour = Integer.parseInt(timevo.getHour());
		
		StringBuffer firstRow = new StringBuffer();
		StringBuffer secondRow = new StringBuffer();
		
		int hourCount = hour / 5;
		int hourMod = hour % 5;
		
		for(int i=1; i<=hourCount;i++ ) {
			if(i == hourCount) {
				firstRow.append("R\n");		
			}else {
				firstRow.append("R ");
			}
		}
		
		for(int j=1; j<=hourMod; j++) {
				if(j == hourMod) {
					secondRow.append("R\n");		
				}else {
					secondRow.append("R ");
				}
		}
		
		return firstRow.append(secondRow).toString();
	}
	

}
