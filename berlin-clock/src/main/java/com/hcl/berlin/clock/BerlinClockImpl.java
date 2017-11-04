/**
 * 
 */
package com.hcl.berlin.clock;

//Static import of constant class, so that we do not need to have constant class name prefixed before each constants used in this file.
import static com.hcl.berlin.clock.BerlinClockConstants.*;

/**
 * BerlinClockImpl which implements from BerlinClock
 * You can get the Current System Time in Berlin Clock Format. (LED status)
 * 
 * @author training
 *
 *@see com.hcl.berlin.clock.BerlinClock
 */
public class BerlinClockImpl implements BerlinClock {

	/**
	 * Local Variables
	 */
	private String currentTime;
	private ClockVO timevo;

	/**
	 * Constructor
	 */
	public BerlinClockImpl() {
		// Whenever the Object is Created it will have the System Current Time stored
		// into currentTime variable.
		setCurrentTime(new java.sql.Time(System.currentTimeMillis()).toString());
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
		//get the value and return the On or Off Status
		int seconds = Integer.parseInt(timevo.getSecond());
		return (seconds % 2 == 0) 
				? YELLOW_INDICATOR + NEWLINE 
						: OFF_INDICATOR + NEWLINE;
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
	 * @param int
	 *            count - Pass the no. of LEDs to be ON
	 * @param int
	 *            totalCount - Pass how many LEDs are available in that Row.
	 * @param String
	 *            ledIndicationColor - Pass the Color of LED
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

		/*
		 * The below condition is used for the Berlin Clock First Row of Minutes Section
		 * We have 11 LEDs with each being 5 minutes and each every quarter it will have
		 * RED LED. So we see if we have Continuous YYY (Yellow), then We replace with
		 * "YYR" Yellow Yellow Red.
		 */
		if (totCount == 11) {
			String minutesLEDs = ledBuffer.toString().replaceAll(THREE_YELLOW_INDICATOR, TWO_YELLOW_ONE_RED_INDICATOR);
			ledBuffer.delete(0, ledBuffer.length());
			ledBuffer.append(minutesLEDs);
		}

		return ledBuffer.append(NEWLINE);
	}

	@Override
	public String toString() {
		return getBerlinSeconds() + getBerlinHour() + getBerlinMinutes();
	}

}
