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
	private static final Object NEWLINE = "\n";

	/**
	 * Local Variables
	 */
	String currentTime;
	TimeVO timevo;

	/**
	 * Constructor
	 */
	public TimeImpl() {
		// Whenever the Object is Created it will have the System Current Time stored
		// into currentTime variable.
		setCurrentTime(new java.sql.Time(System.currentTimeMillis()).toString());
	}

	/**
	 * Getter for currentTime
	 * 
	 * @return
	 */
	public String getCurrentTime() {
		return currentTime;
	}

	/**
	 * Setter for currentTime
	 * 
	 * @param currentTime
	 */
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
		timevo = new TimeVO(this.currentTime);
	}

	/**
	 * Getting the Seconds in Berlin Clock Format. <br/>
	 * Displaying :</br>
	 * <b>Y</b> if it is even seconds.<br/>
	 * <b>O</b> if it is odd seconds.
	 */
	public String getBerlinSeconds() {
		// TODO get the value and return the On or Off Status
		int seconds = Integer.parseInt(timevo.getSecond());

		if (seconds % 2 == 0)
			return OFF_INDICATOR;

		return YELLOW_INDICATOR;
	}

	public String getBerlinHour() {
		int hour = Integer.parseInt(timevo.getHour());

		StringBuffer firstRow = new StringBuffer();
		StringBuffer secondRow = new StringBuffer();

		int hourCount = hour / 5;
		int hourMod = hour % 5;

		firstRow.append(populateLEDs(hourCount, RED_INDICATOR));
		secondRow.append(populateLEDs(hourMod, RED_INDICATOR));

		return firstRow.append(secondRow).toString();
	}

	/**
	 * @param count
	 * @return
	 */
	private StringBuffer populateLEDs(int count, String ledIndicatorColor) {
		StringBuffer ledBuffer = new StringBuffer();
		int totCount = 4;
		for (int i = 0; i < totCount; i++) {

			if (i < count) {
				ledBuffer.append(ledIndicatorColor);
			} else {
				ledBuffer.append(OFF_INDICATOR);
			}
		}
		return ledBuffer.append(NEWLINE);
	}

}
