/**
 * 
 */
package com.hcl.berlin.clock.app;

import com.hcl.berlin.clock.BerlinClock;
import com.hcl.berlin.clock.BerlinClockImpl;

/**
 * @author Bala
 *
 */
public class MainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BerlinClock berlinClock = new BerlinClockImpl();
		
		System.out.println("Local Time : " + new java.sql.Time(System.currentTimeMillis()).toString());
		System.out.println("Berlin Time : \n" + berlinClock.toString());

	}

}
