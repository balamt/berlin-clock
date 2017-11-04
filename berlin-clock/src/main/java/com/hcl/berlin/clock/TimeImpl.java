/**
 * 
 */
package com.hcl.berlin.clock;

/**
 * @author training
 *
 */
public class TimeImpl implements Time {

	/***
	 * Constants
	 */
	private static final String OFF_INDICATOR = "O";
	private static final String YELLOW_INDICATOR = "Y";
	private static final String RED_INDICATOR = "R";
	private static final String RED_INDICATOR_SPACE = RED_INDICATOR +  " ";
	private static final String RED_NEWLINE = RED_INDICATOR + "\n";
	private static final String TIME_SPLIT_REGEX = ":";

	/**
	 * Local Variables
	 */
	String currentTime;
	TimeVO timevo;

	/**
	 * Constructor
	 */
	public TimeImpl() {
		//Whenever the Object is Created it will have the System Current Time stored into currentTime variable.
		setCurrentTime(new java.sql.Time(System.currentTimeMillis()).toString());
	}
	
	
	/**
	 * Getter for currentTime
	 * @return
	 */
	public String getCurrentTime() {
		return currentTime;
	}

	/**
	 * Setter for currentTime
	 * @param currentTime
	 */
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
		//After we set the time, we need to split the hours, minutes and seconds.
		splitTime();
	}

	/**
	 * Getting the Seconds in Berlin Clock Format.
	 * <br/>
	 * Displaying :</br><b>Y</b> if it is even seconds.<br/><b>O</b> if it is odd seconds. 
	 */
	public String getBerlinSeconds() {
		// TODO get the value and return the On or Off Status
		int seconds = Integer.parseInt(timevo.getSecond());

		if (seconds % 2 == 0)
			return OFF_INDICATOR;

		return YELLOW_INDICATOR;
	}

	/**
	 * SplitTime - To Split the Time and Return the TimeVO with Hour, Minute and Second
	 */
	public void splitTime() {
		timevo = new TimeVO();
		String[] timeArray = currentTime.split(TIME_SPLIT_REGEX);
		timevo.setHour(timeArray[0]);
		timevo.setMinute(timeArray[1]);
		timevo.setSecond(timeArray[2]);
	}

	public String getBerlinHour() {
		int hour = Integer.parseInt(timevo.getHour());

		StringBuffer firstRow = new StringBuffer();
		StringBuffer secondRow = new StringBuffer();

		int hourCount = hour / 5;
		int hourMod = hour % 5;

		for (int i = 1; i <= hourCount; i++) {
			if (i == hourCount) {
				firstRow.append(RED_NEWLINE);
			} else {
				firstRow.append(RED_INDICATOR_SPACE);
			}
		}

		for (int j = 1; j <= hourMod; j++) {
			if (j == hourMod) {
				secondRow.append(RED_NEWLINE);
			} else {
				secondRow.append(RED_INDICATOR_SPACE);
			}
		}

		return firstRow.append(secondRow).toString();
	}

}
