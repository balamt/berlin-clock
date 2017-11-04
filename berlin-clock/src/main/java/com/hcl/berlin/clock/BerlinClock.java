/**
 * 
 */
package com.hcl.berlin.clock;

/**
 * 
 * BerlinClock Interface
 * You can get the Current System Time in Berlin Clock Format. (LED status)
 * Using this Interface to implement your own class
 * 
 * @author training
 *
 */
public interface BerlinClock {

	String getBerlinSeconds();

	String getBerlinHour();
	
	String getBerlinMinutes();
	
	String getBerlinClockTime();
}
