/**
 * 
 */
package com.hcl.berlin.clock.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hcl.berlin.clock.Time;
import com.hcl.berlin.clock.TimeImpl;

/**
 * @author training
 *
 */
public class BerlinClockTest {

	private String inputTime;
	private Time time;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		inputTime = "14:25:12";
		time = new TimeImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testSecondsWhetherItIsON() {
		assertEquals("O", time.getBerlinSeconds());
	}

	/**
	 * This Test Case will see if the input Second LED is Not OFF
	 */
	@Test
	public void testSecondsWhetherItIsOFF() {
		assertNotEquals("Y", time.getBerlinSeconds());
	}
	
	@Test
	public void testFirstRowOfHourForNoOfLEDsON() {
		String result = time.getBerlinHour();
		System.out.println(result);
	}
	
	
	
	

}
