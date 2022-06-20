/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Four Milestone                           * *
* *   Project Description :  Task Service                                    * *
* *   File Name           :  TaskTest.java                                   * *
* *   Description         :  Definition of the Task class unit tests.        * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
* *                                                                          * *
* *                                                                          * *
* *                                Change Log                                * *
* *      Date        Author            Description                           * *
* *  *************  ****************  **************************************** *
* *   25 May 2022   P. D. Pattison    Initial Coding...                      * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
******************************************************************************/


package cs320.module4;



import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author PaTcHeS
 */
public class TaskTest
{
    
    //  Some constants to use for testing
	final String TEST_ID = "Unique_ID";
    final String TEST_NAME = "20 characters long!!";
    final String TEST_DESCRIPTION = "This is a description is exactly 50 characters!!!!";
    
    Task test_task;
    
    /**
     * Method to setup for each test.
     */
    @BeforeEach
    void testSetup()
    {
        
        test_task = new Task(
          TEST_ID,
          TEST_NAME,
          TEST_DESCRIPTION);
        
    }
    
    /**
     * Method to test getting the task id...
     */
    @Test
    @DisplayName("Test getting task id...")
    void testGettingTaskId()
    {
        
        assertTrue(test_task.getTaskId().equals(TEST_ID));
        
    }
    
    /**
     * Method to test getting the task name...
     */
    @Test
    @DisplayName("Test getting the task name...")
    void testGettingName()
    {
    	
    	assertTrue(test_task.getName().equals(TEST_NAME));
    	
    }
    
    /**
     * Method to test setting the task name...
     */
    @Test
    @DisplayName("Test setting the task name...")
    void testSettingName()
    {
    	
    	String new_name = "This is a new name";
    	test_task.setName(new_name);
    	assertTrue(test_task.getName().equals(new_name));
    	
    }
    
    /**
     * Method to test that task name cannot be set to the empty string...
     */
    @Test
    @DisplayName("Test task name for empty string...")
    void testEmptyStringName()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        test_task.setName(""));
    	
    }
    
    /**
     * Method to test that task name cannot be set to null...
     */
    @Test
    @DisplayName("Test task name for null string...")
    void testNullStringName()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_task.setName(null));
    	
    }
    
    /**
     * Method to test that task name cannot be set to more than 20 chars...
     */
    @Test
    @DisplayName("Test task name for oversized string...")
    void testOversizedStringName()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_task.setName("This string is too long!"));        
    	
    }
    
    /**
     * Method to test getting the task description...
     */
    @Test
    @DisplayName("Test getting task description...")
    void testGettingDescription()
    {
        
        assertTrue(test_task.getDescription().equals(TEST_DESCRIPTION));
        
    }
    
    /**
     * Method to test setting the task description...
     */
    @Test
    @DisplayName("Test setting task description...")
    void testSettingDescription()
    {
    	
    	String new_description = "New Description";
    	test_task.setDescription(new_description);
    	assertTrue(test_task.getDescription().equals(new_description));
    	
    }
    
    /**
     * Method to test task description cannot be set to empty string...
     */
    @Test
    @DisplayName("Test task description for empty string...")
    void testEmptyStringDescription()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_task.setDescription(""));
    	
    }
    
    /**
     * Method to test task description cannot be set to null...
     */
    @Test
    @DisplayName("Test task description for null string...")
    void testNullStringDescription()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_task.setDescription(null));
    	
    }
    
    /**
     * Method to test task description cannot be set to more than 50 chars...
     */
    @Test
    @DisplayName("Test task description for oversized string...")
    void testOversizedStringDescription()
    {
    	
        assertThrows(IllegalArgumentException.class, () ->
        		test_task.setDescription("This string is too long to be a valid description!!!"));        
    	
    }
    
}
