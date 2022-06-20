/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Three Milestone                          * *
* *   Project Description :  Contact Service                                 * *
* *   File Name           :  ContactTest.java                                * *
* *   Description         :  Definition of the Contact class unit tests.     * *
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
 * @author PaTcHeS
 */
public class ContactTest
{
    
    //  Some constants to use for testing
    final String TEST_FIRST_NAME = "JOHN";
    final String TEST_LAST_NAME = "Doe";
    final String TEST_PHONE_NUMBER = "5555551212";
    final String TEST_ADDRESS = "1313 Mockingbird Lane";
    
    Contact test_contact;
    
    /**
     * Method to setup for each test.
     */
    @BeforeEach
    void testSetup()
    {
        
        test_contact = new Contact(
          "Unique_ID",
          TEST_FIRST_NAME,
          TEST_LAST_NAME,
          TEST_PHONE_NUMBER,
          TEST_ADDRESS);
        
    }
    
    /**
     * Method to test getting the first name...
     */
    @Test
    @DisplayName("Test first name...")
    void testFirstName()
    {
        
        assertTrue(test_contact.getFirstName().equals(TEST_FIRST_NAME));
        
    }
    
    /**
     * Method to test setting the first name...
     */
    @Test
    @DisplayName("Test setting the first name...")
    void testUpdateFirstName()
    {
    	
    	String new_name = "NewName";
    	test_contact.setFirstName(new_name);
    	assertTrue(test_contact.getFirstName().equals(new_name));
    	
    }
    
    /**
     * Method to test that first name cannot be set to the empty string...
     */
    @Test
    @DisplayName("Test first name for empty string...")
    void testEmptyStringFirstName()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setFirstName(""));
    	
    }
    
    /**
     * Method to test that first name cannot be set to null...
     */
    @Test
    @DisplayName("Test first name for null string...")
    void testNullStringFirstName()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setFirstName(null));
    	
    }
    
    /**
     * Method to test that first name cannot be set to more than 10 chars...
     */
    @Test
    @DisplayName("Test first name for oversized string...")
    void testOversizedStringFirstName()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setFirstName("This string is too long!"));        
    	
    }
    
    /**
     * Method to test getting the last name...
     */
    @Test
    @DisplayName("Test last name...")
    void testLastName()
    {
        
        assertTrue(test_contact.getLastName().equals(TEST_LAST_NAME));
        
    }
    
    /**
     * Method to test setting the last name...
     */
    @Test
    @DisplayName("Test setting last name...")
    void testSettingLastName()
    {
    	
    	String new_name = "NewName";
    	test_contact.setLastName(new_name);
    	assertTrue(test_contact.getLastName().equals(new_name));
    	
    }
    
    /**
     * Method to test last name cannot be set to empty string...
     */
    @Test
    @DisplayName("Test last name for empty string...")
    void testEmptyStringLastName()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setLastName(""));
    	
    }
    
    /**
     * Method to test last name cannot be set to null...
     */
    @Test
    @DisplayName("Test last name for null string...")
    void testNullStringLastName()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setLastName(null));
    	
    }
    
    /**
     * Method to test last name cannot be set to more than 10 chars...
     */
    @Test
    @DisplayName("Test last name for oversized string...")
    void testOversizedStringLastName()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setLastName("This string is too long!"));        
    	
    }
    
    /**
     * Method to test getting phone number...
     */
    @Test
    @DisplayName("Test phone number...")
    void testPhoneNumber()
    {
        
        assertTrue(test_contact.getPhoneNumber().equals(TEST_PHONE_NUMBER));
        
    }
    
    /**
     * Method to test setting phone number...
     */
    @Test
    @DisplayName("Test setting phone number...")
    void testSettingPhoneNumber()
    {
    	
    	String new_number = "1234567890";
    	test_contact.setPhoneNumber(new_number);
    	assertTrue(test_contact.getPhoneNumber().equals(new_number));
    	
    }
    
    /**
     * Method to test phone number cannot be set to empty string...
     */
    @Test
    @DisplayName("Test phone number for empty string...")
    void testEmptyStringPhoneNumber()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setPhoneNumber(""));
    	
    }
    
    /**
     * Method to test that phone number cannot be set to null...
     */
    @Test
    @DisplayName("Test phone number for null string...")
    void testNullStringPhoneNumber()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setPhoneNumber(null));
    	
    }
    
    /**
     * Method to test that phone number cannot be set to more than 10 chars...
     */
    @Test
    @DisplayName("Test phone number for oversized string...")
    void testOversizedStringPhoneNumber()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setPhoneNumber("This string is too long!"));        
    	
    }
    
    /**
     * Method to test getting address...
     */
    @Test
    @DisplayName("Test address...")
    void testAddress()
    {
        
        assertTrue(test_contact.getAddress().equals(TEST_ADDRESS));
        
    }
    
    /**
     * Method to test setting address...
     */
    @Test
    @DisplayName("Test setting address...")
    void testSettingAddress()
    {
    	
    	String new_address = "New Address";
    	test_contact.setAddress(new_address);
    	assertTrue(test_contact.getAddress().equals(new_address));
    	
    }
    
    /**
     * Method to test address cannot be set to empty string...
     */
    @Test
    @DisplayName("Test address for empty string...")
    void testEmptyStringAddress()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setAddress(""));
    	
    }
    
    /**
     * Method to test address cannot be set to null...
     */
    @Test
    @DisplayName("Test address for null string...")
    void testNullStringAddress()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setAddress(null));
    	
    }
    
    /**
     * Method to test address cannot be set to more than 30 chars...
     */
    @Test
    @DisplayName("Test address for oversized string...")
    void testOversizedStringAddress()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_contact.setAddress("This string is seriously too long!"));        
    	
    }
    
}
