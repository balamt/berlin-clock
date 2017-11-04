/**
 * 
 */
package com.hcl.berlin.clock.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.berlin.clock.Time;
import com.hcl.berlin.clock.TimeImpl;

/**
 * @author training
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BerlinClockTest {

	@Mock
	private Time time;

	@InjectMocks
	private TimeImpl timeimpl;

	private String inputTime = "14:25:12";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		timeimpl.setCurrentTime(inputTime);
	}

	@Test
	public void testSecondsWhetherItIsOFF() {
		assertEquals("O", timeimpl.getBerlinSeconds());
	}

	/**
	 * This Test Case will see if the input Second LED is Not OFF
	 */
	@Test
	public void testSecondsWhetherItIsNotOFF() {
		assertNotEquals("Y", timeimpl.getBerlinSeconds());
	}

	@Test
	public void testFirstRowOfHourForNoOfLEDsON() {

		StringBuffer expectedRow = new StringBuffer();
		expectedRow.append("R R\n");
		expectedRow.append("R R R R\n");

		assertEquals(expectedRow.toString(), timeimpl.getBerlinHour());
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
