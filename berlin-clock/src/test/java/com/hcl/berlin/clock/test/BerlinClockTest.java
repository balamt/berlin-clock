/**
 * 
 */
package com.hcl.berlin.clock.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.berlin.clock.BerlinClock;
import com.hcl.berlin.clock.BerlinClockImpl;

/**
 * @author training
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BerlinClockTest {

	@Mock
	private BerlinClock time;

	@InjectMocks
	private BerlinClockImpl timeimpl;

	private String inputTime = "14:25:12";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		timeimpl.setCurrentTime(inputTime);
	}

	/**
	 * Test Case to See whether the LED is OFF for the Seconds Circle in the Berlin Clock.
	 * @throws Exception 
	 */
	@Test
	public void testSecondsWhetherItIsOFF() throws Exception {
		inputTime = "14:25:11";
		setUp();
		assertEquals("O\n", timeimpl.getBerlinSeconds());
		inputTime = "14:25:12";
		setUp();
	}

	/**
	 * This Test Case will see if the input Second LED is ON
	 */
	@Test
	public void testSecondsWhetherItIsON() {
		assertEquals("Y\n", timeimpl.getBerlinSeconds());
	}

	/**
	 * This Test Case will see for the LEDs ON for the Hour Section.
	 */
	@Test
	public void testHoursForNoOfLEDsON() {

		StringBuffer expectedRow = new StringBuffer();
		expectedRow.append("RROO\n");
		expectedRow.append("RRRR\n");
		
		System.out.println(timeimpl.getBerlinHour());

		assertEquals(expectedRow.toString(), timeimpl.getBerlinHour());
	}
	
	/**
	 * This Test Case will see for the LEDs ON for the Minute Section.
	 */
	@Test
	public void testMinutesForNoOfLEDsON() {
		StringBuffer expectedRow = new StringBuffer();
		expectedRow.append("YYRYYOOOOOO\n");
		expectedRow.append("OOOO\n");
		assertEquals(expectedRow.toString(), timeimpl.getBerlinMinutes());
	}
	
	@Test
	public void testBerlinClockTime() {
		
		StringBuffer expectedRow = new StringBuffer();
		expectedRow.append("Y\n");
		expectedRow.append("RROO\n");
		expectedRow.append("RRRR\n");
		expectedRow.append("YYRYYOOOOOO\n");
		expectedRow.append("OOOO\n");
		
		assertEquals(expectedRow.toString(), timeimpl.toString());
		
	}

	/**
	 * Teardown the mocked and initialized variables.
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		timeimpl = null;
	}

}
