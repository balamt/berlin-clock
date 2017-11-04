/**
 * 
 */
package com.hcl.berlin.clock;

/**
 * @author training
 *
 */
public class ClockVO {

	private static final String TIME_SPLIT_REGEX_PATTERN = ":";
	private String hour;
	private String minute;
	private String second;
	
	public ClockVO(String time) {
		String[] timeArray = time.split(TIME_SPLIT_REGEX_PATTERN);
		this.setHour(timeArray[0]);
		this.setMinute(timeArray[1]);
		this.setSecond(timeArray[2]);
	}

	/**
	 * @return the hour
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * @param hour
	 *            the hour to set
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}

	/**
	 * @return the minute
	 */
	public String getMinute() {
		return minute;
	}

	/**
	 * @param minute
	 *            the minute to set
	 */
	public void setMinute(String minute) {
		this.minute = minute;
	}

	/**
	 * @return the second
	 */
	public String getSecond() {
		return second;
	}

	/**
	 * @param second
	 *            the second to set
	 */
	public void setSecond(String second) {
		this.second = second;
	}

}
