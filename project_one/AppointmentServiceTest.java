/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Five Milestone                           * *
* *   Project Description :  Appointment Service                             * *
* *   File Name           :  AppointmentServiceTest.java                     * *
* *   Description         :  Definition of the AppointmentServiceTest class. * *
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

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Patrick D. Pattison
 *
 */
class AppointmentServiceTest
{

	//  Some constants for use in tests...
	private final long ONE_DAY_IN_MS = 8640000L;
	private final Date TEST_DATE = new Date(new Date().getTime() + ONE_DAY_IN_MS);
	private final String TEST_DESCRIPTION = "TEST DESCRIPTION 50 CHARACTERS LONG!!!!!!!!!!!!!!!";
	
	//  Private field for testing use.
	private Appointment test_appointment;
	private AppointmentService test_service;
	
	/**
	 * Method to set up for each test
	 */
	@BeforeEach
	void testSetup()
	{
		
		test_service = new AppointmentService();
		
	}

	/**
	 * Method to test adding an appointment
	 */
	@Test
	void testAddAppointment() 
	{
		
		//  Add a new appointment
		String test_uuid;
		test_uuid = test_service.addAppointment(TEST_DATE, TEST_DESCRIPTION);
		//  Retrieve added appointment.
		test_appointment = test_service.getAppointment(test_uuid);
		//  Verify that appointment_id, date, and description match what was added.
		assertAll(
				() -> assertTrue(test_appointment.getDate().equals(TEST_DATE)),
				() -> assertTrue(test_appointment.getDescription().equals(TEST_DESCRIPTION))
		);
		
	}
	
	/**
	 * Method to test removing an appointment
	 */
	@Test
	void testRemoveAppointment()
	{
		
		//  Add a new appointment
		String test_uuid;
		test_uuid = test_service.addAppointment(TEST_DATE,  TEST_DESCRIPTION);
		
		assertAll(
				//  Remove the added appointment
				() -> assertTrue(test_service.removeAppointment(test_uuid)),
				//  Now try to get the added appointment and verify the exception is thrown.
				() -> assertThrows(IllegalArgumentException.class, () ->
					test_service.getAppointment(test_uuid))
		);
		
	}

}
