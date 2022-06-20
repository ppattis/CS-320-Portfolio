/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Five Milestone                           * *
* *   Project Description :  Appointment Service                             * *
* *   File Name           :  AppointmentTest.java                            * *
* *   Description         :  Definition of the AppointmentTest class.        * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
* *                                                                          * *
* *                                                                          * *
* *                                Change Log                                * *
* *      Date        Author            Description                           * *
* *  *************  ****************  **************************************** *
* *   01 June 2022  P. D. Pattison    Initial Coding...                      * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
******************************************************************************/

package cs330.module5;


import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Patrick D. Pattison
 *
 */
class AppointmentTest
{

	//  Some constants for use in tests...
	private final long ONE_DAY_IN_MS = 8640000L;
	private final long JUNE_14_1976_SINCE_EPOCH = 203638441000L;
	private final String TEST_ID = "TEST ID123";
	private final String OVERSIZED_ID = "OVERSIZED_ID";
	private final Date TEST_DATE = new Date(new Date().getTime() + ONE_DAY_IN_MS);
	private final Date PAST_DATE = new Date(JUNE_14_1976_SINCE_EPOCH);
	private final String TEST_DESCRIPTION = "TEST DESCRIPTION 50 CHARACTERS LONG!!!!!!!!!!!!!!!";
	private final String OVERSIZED_DESCRIPTION = "THIS STRING IS OVERSIZED FOR A DESCRIPTION!!!!!!!!!";
	private final String EMPTY_STRING = "";
	
	//  Private field for testing use.
	private Appointment test_appointment;
	private Appointment test_two;
	
	/**
	 * Method to setup for each test
	 */
	@BeforeEach
	void testSetup()
	{
		
		test_appointment = new Appointment(TEST_ID, TEST_DATE, TEST_DESCRIPTION);
		
	}
	
	/**
	 * Method to test appointment_id being set to the empty string
	 */
	@Test
	void testIdEmptyString() 
	{
		
		assertThrows(IllegalArgumentException.class, () ->
			test_two = new Appointment(EMPTY_STRING, TEST_DATE, TEST_DESCRIPTION));
		
	}
	
	/**
	 * Method to test appointment_id being set to an oversized string.
	 */
	@Test
	void testIdOversizedString()
	{
		
		assertThrows(IllegalArgumentException.class, () ->
			test_two = new Appointment(OVERSIZED_ID, TEST_DATE, TEST_DESCRIPTION));
		
	}
	
	/**
	 * Method to test appointment_date with a date in the past.
	 */
	@Test
	void testPastDate() 
	{
		
		assertThrows(IllegalArgumentException.class, () ->
			test_two = new Appointment(TEST_ID, PAST_DATE, TEST_DESCRIPTION));
		
	}
	
	/**
	 * Method to test appointment_description with the empty string.
	 */
	@Test
	void testDescriptionEmptyString() 
	{
		
		assertThrows(IllegalArgumentException.class, () ->
			test_two = new Appointment(TEST_ID, TEST_DATE, EMPTY_STRING));
		
	}
	
	/**
	 * Method to test application_description with an oversized string.
	 */
	@Test
	void testDescriptionOversizedString()
	{
		
		assertThrows(IllegalArgumentException.class, () ->
			test_two = new Appointment(TEST_ID, TEST_DATE, OVERSIZED_DESCRIPTION));
		
	}
	
	
	

}
