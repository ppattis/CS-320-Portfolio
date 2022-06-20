/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Three Milestone                          * *
* *   Project Description :  Contact Service                                 * *
* *   File Name           :  ContactService.java                             * *
* *   Description         :  Definition of ContactService class.             * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
* *                                                                          * *
* *                                                                          * *
* *                                Change Log                                * *
* *      Date        Author            Description                           * *
* *  *************  ****************  **************************************** *
* *   22 May 2022   P. D. Pattison    Initial Coding...                      * *
* *   23 May 2022   P. D. Pattison    Cleanup and comment for turn in.       * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
******************************************************************************/


package cs320.module3;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author P. D. Pattison
 *
 */
public class ContactService
{
	
	/**
	 * Constructor...
	 */
	public ContactService()
	{
		
		contacts = new ArrayList<Contact>();
		
	}
	
	/**
	 * Method to add a contact...
	 * @param first_name
	 * @param last_name
	 * @param phone_number
	 * @param address
	 * @return String the contact_id of the added contact
	 * @throws IllegalArgumentException
	 */
	public String addContact(
			String first_name,
			String last_name,
			String phone_number,
			String address) throws IllegalArgumentException
	{
		
		String uuid = generateUUID();
		contacts.add(new Contact(
				uuid,
				first_name,
				last_name,
				phone_number,
				address));
		return uuid;
		
	}
	
	/**
	 * Method to get a Contact by uuid
	 * @param uuid
	 * @return Contact the contact
	 * @throws IllegalArgumentException
	 */
	public Contact getContact(String uuid) throws IllegalArgumentException
	{
		
		for (int index = 0; index < contacts.size(); index++)
		{
			
			if (contacts.get(index).getContactId().equals(uuid))
			{
				
				//  UUID found, return the contact...
				return contacts.get(index);
				
			}
			
		}
		//  If we get here, uuid was not found...
		throw new IllegalArgumentException("UUID Not Found");
		
	}
	
	/**
	 * Method to remove a contact by uuid
	 * @param contact_id
	 * @return boolean true if contact found and removed, false if not found.
	 */
	public boolean removeContact(String contact_id)
	{
		
		//  Search contacts.
		for (int index = 0; index < contacts.size(); index++)
		{
			
			if (contacts.get(index).getContactId().equals(contact_id))
			{
				
				//  Found.  Remove and return true.
				contacts.remove(index);
				return true;
				
			}
			
		}
		//  If we get here it wasn't found.
		return false;
		
	}
	
	/**
	 * Method to update the first name of a contact by uuid
	 * @param contact_id
	 * @param first_name
	 * @return boolean true if found, false if not
	 */
	public boolean updateFirstName(String contact_id, String first_name)
	{
		
		//  Search all contacts.
		for (int index = 0; index < contacts.size(); index++)
		{
			
			if (contacts.get(index).getContactId().equals(contact_id))
			{
				
				//  UUID found.  Update and return true.
				contacts.get(index).setFirstName(first_name);
				return true;
				
			}
			
		}
		//  If we get here it wasn't found.
		return false;
		
	}
	
	/**
	 * Method to update the last name of a contact by uuid
	 * @param contact_id
	 * @param last_name
	 * @return boolean true if found false if not.
	 */
	public boolean updateLastName(String contact_id, String last_name)
	{
		
		//  Search contacts.
		for (int index = 0; index < contacts.size(); index++)
		{
			
			if (contacts.get(index).getContactId().equals(contact_id))
			{
				
				//  Contact found.  Update and return true.
				contacts.get(index).setLastName(last_name);
				return true;
				
			}
			
		}
		//  If we get here it wasn't found.
		return false;
		
	}
	
	/**
	 * Method to update a contacts phone number by uuid
	 * @param contact_id
	 * @param phone_number
	 * @return boolean true if found, false if not.
	 */
	public boolean updatePhoneNumber(String contact_id, String phone_number)
	{
		
		//  Search contacts.
		for (int index = 0; index < contacts.size(); index++)
		{
			
			if (contacts.get(index).getContactId().equals(contact_id))
			{
				
				//  Found.  Update and return true.
				contacts.get(index).setPhoneNumber(phone_number);
				return true;
				
			}
			
		}
		//  If we get here then contact wasn't found.
		return false;
		
	}
	
	/**
	 * Method to update a contacts address by uuid.
	 * @param contact_id
	 * @param address
	 * @return boolean true if found, false if not
	 */
	public boolean updateAddress(String contact_id, String address)
	{
		
		//  Search contacts.
		for (int index = 0; index < contacts.size(); index++)
		{
			
			if (contacts.get(index).getContactId().equals(contact_id))
			{
				
				//  Found.  Update and return true.
				contacts.get(index).setAddress(address);
				return true;
				
			}
			
		}
		//  If we get here, then it wasn't found.
		return false;
		
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
			for (int index = 0; index < contacts.size(); index++)
			{
				
				if (contacts.get(index).getContactId().equals(randomUUID))
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
	
	//  Collection of known contacts.
	private ArrayList<Contact> contacts;

}
