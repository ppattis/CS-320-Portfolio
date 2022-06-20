/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Five Milestone                           * *
* *   Project Description :  Appointment Service                             * *
* *   File Name           :  AppointmentService.java                         * *
* *   Description         :  Definition of the AppointmentService class.     * *
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

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Patrick D. Pattison
 *
 */
public class AppointmentService
{
	
	/**
	 * Constructor
	 */
	public AppointmentService()
	{
		
		this.appointments = new ArrayList<Appointment>();
		
	}
	
	/**
	 * Method to add an appointment..
	 * @param date
	 * @param description
	 * @return String the appointment_id of the added appointment
	 */
	public String addAppointment(Date date, String description)
	{
		
		String uuid = generateUUID();
		appointments.add(new Appointment(uuid, date, description));
		return uuid;
		
	}
	
	/**
	 * Method to remove an appointment by uuid
	 * @param uuid
	 * @return boolean true if appointment found and removed, false otherwise
	 */
	public boolean removeAppointment(String uuid)
	{
		
		//  Search appointments...
		for (int index = 0; index < appointments.size(); index++)
		{
			
			if (appointments.get(index).getId().equals(uuid))
			{
				
				//  Found.  Remove and return true.
				appointments.remove(index);
				return true;
				
			}
			
		}
		//  If we got here it wasn't found.
		return false;
		
	}
	
	/**
	 * Method to get an appointment by uuid
	 * @param uuid
	 * @return Appointment the requested appointment
	 * @throws IllegalArgumentException
	 */
	public Appointment getAppointment(String uuid) throws IllegalArgumentException
	{
		
		//  Search appointments...
		for (int index = 0; index < appointments.size(); index++)
		{
			
			if (appointments.get(index).getId().equals(uuid))
			{
				
				//  Found.  Return the appointment.
				return appointments.get(index);
				
			}
			
		}
		//  If we got here, it wasn't found...
		throw new IllegalArgumentException("Appointment not found");
		
	}
	
	/**
	 * Method to generate 10 character UUID.  I chose to use all the characters
	 * between '*' (42 Dec) and 'z' (122 Dec) on the ASCII Table.  The drawback
	 * to this is that gives an alphabet of 80 characters, times 10 characters
	 * the UUID can only be one of 800 possibilities.
	 * @return returns the uniquely generated UUID.
	 */
	private String generateUUID()
	{
		
		Random randomGen = new Random();
		String randomUUID = "";
		boolean uuidUnique = false;
		//  While the UUID generated isn't unique, keep trying.
		//  Probably not the most efficient way to do this,
		//  however I am constrained to only 10 characters.  If
		//  the UUID could be 16 characters then we could use the 
		//  java built-in UUIDs.
		while (!uuidUnique)
		{
			
			//  Generate 10 random characters.
			for (int index = 0; index < 10; index++)
			{
			
				randomUUID += (char)(randomGen.nextInt(80) + '*');
			
			}
			//  Now test that the UUID generated doesn't exist already
			uuidUnique = true;
			for (int index = 0; index < appointments.size(); index++)
			{
				
				if (appointments.get(index).getId().equals(randomUUID))
				{
					
					//  UUID found.  Not unique.
					uuidUnique = false;
					randomUUID = "";
					break;
					
				}
				
			}
			
		}
		//  If we get here the UUID was unique.
		return randomUUID;
		
	}
	
	//  Collection of known appointments.
	private ArrayList<Appointment> appointments;

}
