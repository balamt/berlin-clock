/**
 * 
 */
package com.hcl.berlin.clock;

/**
 * @author training
 *
 */
public class BerlinClockImpl implements BerlinClock {

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
	ClockVO timevo;

	/**
	 * Constructor
	 */
	public BerlinClockImpl() {
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
		timevo = new ClockVO(this.currentTime);
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

		int totalLEDCount = 4;
		int hourCount = hour / 5;
		int hourMod = hour % 5;

		firstRow.append(populateLEDs(hourCount, totalLEDCount, RED_INDICATOR));
		secondRow.append(populateLEDs(hourMod, totalLEDCount, RED_INDICATOR));

		return firstRow.append(secondRow).toString();
	}

	public String getBerlinMinutes() {
		StringBuffer firstRow = new StringBuffer();
		StringBuffer secondRow = new StringBuffer();
		int minutes = Integer.parseInt(timevo.getMinute());

		int firstRowLEDCount = 11;
		int secondRowLEDCount = 4;
		int minuteCount = minutes / 5; // total 11 LEDs
		int minuteMod = minutes % 5;

		firstRow.append(populateLEDs(minuteCount, firstRowLEDCount, YELLOW_INDICATOR));
		secondRow.append(populateLEDs(minuteMod, secondRowLEDCount, YELLOW_INDICATOR));

		return firstRow.append(secondRow).toString();
	}

	/**
	 * This populateLEDs method will tell what are all the LEDs will be ON and OFF.
	 * <br/>
	 * <b>Y</b> - YELLOW LED <br/>
	 * <b>R</b> - RED LED <br/>
	 * <b>O</b> - LED is OFF<br/>
	 * 
	 * @param int count - Pass the no. of LEDs to be ON
	 * @param int totalCount - Pass how many LEDs are available in that Row.
	 * @param String ledIndicationColor - Pass the Color of LED
	 */
	private StringBuffer populateLEDs(int count, int totCount, String ledIndicatorColor) {
		
		StringBuffer ledBuffer = new StringBuffer();
		
		for (int i = 0; i < totCount; i++) {

			if (i < count) {
				ledBuffer.append(ledIndicatorColor);
			} else {
				ledBuffer.append(OFF_INDICATOR);
			}
		}

		//The below condition is used for the Berlin Clock First Row of Minutes Section
		//We have 11 LEDs with each being 5 minutes and each every quatar it will have RED LED.
		//So we see if we have Continuous YYY (Yellow), then We replace with "YYR" Yellow Yellow Red.
		if (totCount == 11) {
			String minutesLEDs = ledBuffer.toString().replaceAll("YYY", "YYR");
			ledBuffer.delete(0, ledBuffer.length());
			ledBuffer.append(minutesLEDs);
		}

		return ledBuffer.append(NEWLINE);
	}

}
