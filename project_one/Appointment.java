/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Five Milestone                           * *
* *   Project Description :  Appointment Service                             * *
* *   File Name           :  Appointment.java                                * *
* *   Description         :  Definition of the Appointment class.            * *
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

/**
 * 
 * @author Patrick D. Pattison
 *
 */
public class Appointment
{

	/**
	 * Constructor
	 * @param uuid
	 * @param date
	 * @param description
	 */
	Appointment(String uuid, Date date, String description)
	{
		
		this.setId(uuid);
		this.setDate(date);
		this.setDescription(description);
		
	}
	
	/**
	 * Method to get the appointment id.
	 * @return the appointment_id
	 */
	public String getId()
	{
		
		return this.appointment_id;
		
	}
	
	/**
	 * Method to get the appointment date
	 * @return the appointment_date
	 */
	public Date getDate()
	{
		
		return this.appointment_date;
		
	}
	
	/**
	 * Method to get the appointment description
	 * @return the appointment_date
	 */
	public String getDescription()
	{
		
		return this.appointment_description;
		
	}
	
	/**
	 * Method to set the appointment_id
	 * @param uuid
	 * @throws IllegalArgumentException
	 */
	private void setId(String uuid) throws IllegalArgumentException
	{
		
		if (uuid.equals("") || uuid == null)
		{
			
			throw (new IllegalArgumentException("Appointment ID null"));
			
		}
		if (uuid.length() > 10)
		{
			
			throw (new IllegalArgumentException("Appointment ID longer than 10 chars"));
			
		}
		this.appointment_id = uuid;
		
	}
	
	/**
	 * Method to set the appointment_date
	 * @param date
	 * @throws IllegalArgumentException
	 */
	private void setDate(Date date) throws IllegalArgumentException
	{
		
		if (date.before(new Date()))
		{
			
			throw (new IllegalArgumentException("Appointment date in the past"));
			
		}
		this.appointment_date = date;
		
	}
	
	/**
	 * Method to set the appointment_description
	 * @param description
	 * @throws IllegalArgumentException
	 */
	private void setDescription(String description) throws IllegalArgumentException
	{
		
		if (description.equals("") || description == null)
		{
			
			throw (new IllegalArgumentException("Appointment description null"));
			
		}
		if (description.length() > 50)
		{
			
			throw (new IllegalArgumentException("Appointment description longer than 10 chars"));
			
		}
		this.appointment_description = description;
		
	}
	
	//  Private member fields...
	private String appointment_id;
	private Date appointment_date;
	private String appointment_description;
	
}
