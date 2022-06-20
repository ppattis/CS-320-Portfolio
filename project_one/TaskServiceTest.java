/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Four Milestone                           * *
* *   Project Description :  Task Service                                    * *
* *   File Name           :  TaskServiceTest.java                            * *
* *   Description         :  Definition of TaskService test class.           * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
* *                                                                          * *
* *                                                                          * *
* *                                Change Log                                * *
* *      Date        Author            Description                           * *
* *  *************  ****************  **************************************** *
* *   22 May 2022   P. D. Pattison    Initial Coding...                      * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
******************************************************************************/


package cs320.module4;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author P. D. Pattison
 *
 */
class TaskServiceTest
{

	private TaskService test_service;
	
    //  Some constants to use for testing
    final String TEST_TASK_NAME = "TASK_NAME_TASK_NAME1";
    final String TEST_TASK_DESCRIPTION = "TASK_DESCRIPTION_TASK_DESCRIPTION_TASK_DESCRIPTION";
 
	/**
	 * Method to setup for each test.
	 */
	@BeforeEach
	void setUp()
	{
		
		test_service = new TaskService();
		
	}

	/**
	 * Method to test adding a task...
	 */
	@Test
	@DisplayName("Test TaskService adding a task...")
	void testAddTask()
	{
		
		//  Add a new task...
		String uuid = test_service.addTask(
				TEST_TASK_NAME,
				TEST_TASK_DESCRIPTION);
		//  Retrieve added task...
		Task task = test_service.getTask(uuid);
		//  Verify that task_name and task_description were correctly set.
		assertAll(
			() -> assertTrue(task.getName().equals(TEST_TASK_NAME)),
			() -> assertTrue(task.getDescription().equals(TEST_TASK_DESCRIPTION))
		);
		
	}
	
	/**
	 * Method to test deleting a task...
	 */
	@Test
	@DisplayName("Test TaskService deleting a task...")
	void testDeleteTask()
	{
		
		//  Add a new contact.
		String uuid = test_service.addTask(
				TEST_TASK_NAME,
				TEST_TASK_DESCRIPTION);
		//  To test the delete contact function, we will delete the contact
		//  that was just added, and then try to get the contact and verify 
		//  the IllegalArgumentException is thrown.
		test_service.removeTask(uuid);
		assertThrows(IllegalArgumentException.class, () ->
			test_service.getTask(uuid)
		);
		
	}
	
	/**
	 * Method to test modifying the task name of a task...
	 */
	@Test
	@DisplayName("Test TaskService ability to modify a task's name...")
	void testModifyTaskName()
	{
		
		String uuid = test_service.addTask(
				TEST_TASK_NAME,
				TEST_TASK_DESCRIPTION);
		String new_name = "NEW_NAME";
		test_service.updateTaskName(uuid, new_name);
		assertTrue(test_service.getTask(uuid).getName().equals(new_name));
		
	}
	
	/**
	 * Method to test modifying the description of a task...
	 */
	@Test
	@DisplayName("Test TaskService ability to modify a task's description...")
	void testModifyTaskDescription()
	{
		
		String uuid = test_service.addTask(
				TEST_TASK_NAME,
				TEST_TASK_DESCRIPTION);
		String new_description = "NEW_DESCRIPTION";
		test_service.updateTaskDescription(uuid, new_description);
		assertTrue(test_service.getTask(uuid).getDescription().equals(new_description));
		
	}
	
}
