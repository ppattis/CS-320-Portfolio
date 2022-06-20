/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Three Milestone                          * *
* *   Project Description :  Contact Service                                 * *
* *   File Name           :  ContactService.java                             * *
* *   Description         :  Definition of ContactService test class.        * *
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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author P. D. Pattison
 *
 */
class ContactServiceTest
{

	private ContactService test_service;
	
    //  Some constants to use for testing
    final String TEST_FIRST_NAME = "JOHN";
    final String TEST_LAST_NAME = "Doe";
    final String TEST_PHONE_NUMBER = "5555551212";
    final String TEST_ADDRESS = "1313 Mockingbird Lane";
 
	/**
	 * Method to setup for each test.
	 */
	@BeforeEach
	void setUp()
	{
		
		test_service = new ContactService();
		
	}

	/**
	 * Method to test adding a contact...
	 */
	@Test
	@DisplayName("Test ContactService adding a contact...")
	void testAddContact()
	{
		
		//  Add a new contact...
		String uuid = test_service.addContact(
				TEST_FIRST_NAME,
				TEST_LAST_NAME, 
				TEST_PHONE_NUMBER, 
				TEST_ADDRESS);
		//  Retrieve added contact...
		Contact contact = test_service.getContact(uuid);
		//  Verify that first_name, last_name, phone_number, and 
		//  address were correctly set.
		assertAll(
			() -> assertTrue(contact.getFirstName().equals(TEST_FIRST_NAME)),
			() -> assertTrue(contact.getLastName().equals(TEST_LAST_NAME)),
			() -> assertTrue(contact.getPhoneNumber().equals(TEST_PHONE_NUMBER)),
			() -> assertTrue(contact.getAddress().equals(TEST_ADDRESS))
		);
		
	}
	
	/**
	 * Method to test deleting a contact...
	 */
	@Test
	@DisplayName("Test ContactService deleting a contact...")
	void testDeleteContact()
	{
		
		//  Add a new contact.
		String uuid = test_service.addContact(
				TEST_FIRST_NAME,
				TEST_LAST_NAME, 
				TEST_PHONE_NUMBER, 
				TEST_ADDRESS);
		//  To test the delete contact function, we will delete the contact
		//  that was just added, and then try to get the contact and verify 
		//  the IllegalArgumentException is thrown.
		test_service.removeContact(uuid);
		assertThrows(IllegalArgumentException.class, () ->
			test_service.getContact(uuid)
		);
		
	}
	
	/**
	 * Method to test modifing the first name of a contact...
	 */
	@Test
	@DisplayName("Test ContactService ability to modify a contacts first name...")
	void testModifyFirstName()
	{
		
		String uuid = test_service.addContact(
				TEST_FIRST_NAME,
				TEST_LAST_NAME, 
				TEST_PHONE_NUMBER, 
				TEST_ADDRESS);
		String new_name = "TestName";
		test_service.updateFirstName(uuid, new_name);
		assertTrue(test_service.getContact(uuid).getFirstName().equals(new_name));
		
	}
	
	/**
	 * Method to test modifing the last name of a contact...
	 */
	@Test
	@DisplayName("Test ContactService ability to modify a contacts last name...")
	void testModifyLastName()
	{
		
		String uuid = test_service.addContact(
				TEST_FIRST_NAME,
				TEST_LAST_NAME, 
				TEST_PHONE_NUMBER, 
				TEST_ADDRESS);
		String new_name = "TestName";
		test_service.updateLastName(uuid, new_name);
		assertTrue(test_service.getContact(uuid).getLastName().equals(new_name));
		
	}
	
	/**
	 * Method to test modifying the phone number of a contact...
	 */
	@Test
	@DisplayName("Test ContactService ability to modify a contacts phone number...")
	void testModifyPhoneNumber()
	{
		
		String uuid = test_service.addContact(
				TEST_FIRST_NAME,
				TEST_LAST_NAME, 
				TEST_PHONE_NUMBER, 
				TEST_ADDRESS);
		String new_number = "1234567890";
		test_service.updatePhoneNumber(uuid, new_number);
		assertTrue(test_service.getContact(uuid).getPhoneNumber().equals(new_number));
		
	}
	
	/**
	 * Method to test modifying the address of a contact...
	 */
	@Test
	@DisplayName("Test ContactService ability to modify a contacts address...")
	void testModifyAddress()
	{
		
		String uuid = test_service.addContact(
				TEST_FIRST_NAME,
				TEST_LAST_NAME, 
				TEST_PHONE_NUMBER, 
				TEST_ADDRESS);
		String new_address = "TestAddress";
		test_service.updateAddress(uuid, new_address);
		assertTrue(test_service.getContact(uuid).getAddress().equals(new_address));
		
	}

}
