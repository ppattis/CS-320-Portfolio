/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Four Milestone                          * *
* *   Project Description :  Task Service                                 * *
* *   File Name           :  TaskService.java                             * *
* *   Description         :  Definition of TaskService class.             * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
* *                                                                          * *
* *                                                                          * *
* *                                Change Log                                * *
* *      Date        Author            Description                           * *
* *  *************  ****************  **************************************** *
* *   29 May 2022   P. D. Pattison    Initial Coding...                      * *
* *                                                                          * *
* *                                                                          * *
* **************************************************************************** *
******************************************************************************/


package cs320.module4;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author P. D. Pattison
 *
 */
public class TaskService {

	/**
	 * Constructor...
	 */
	public TaskService()
	{
		
		tasks = new ArrayList<Task>();
		
	}
	
	/**
	 * Method to add a task...
	 * @param task_name
	 * @param task_description
	 * @return String the contact_id of the added contact
	 * @throws IllegalArgumentException
	 */
	public String addTask(
			String task_name,
			String task_description) throws IllegalArgumentException
	{
		
		String uuid = generateUUID();
		tasks.add(new Task(
				uuid,
				task_name,
				task_description));
		return uuid;
		
	}
	
	/**
	 * Method to get a Task by task_id
	 * @param uuid
	 * @return Task the task
	 * @throws IllegalArgumentException
	 */
	public Task getTask(String task_id) throws IllegalArgumentException
	{
		
		for (int index = 0; index < tasks.size(); index++)
		{
			
			if (tasks.get(index).getTaskId().equals(task_id))
			{
				
				//  UUID found, return the task...
				return tasks.get(index);
				
			}
			
		}
		//  If we get here, uuid was not found...
		throw new IllegalArgumentException("UUID Not Found");
		
	}
	
	/**
	 * Method to remove a task by task_id
	 * @param contact_id
	 * @return boolean true if task found and removed, false if not found.
	 */
	public boolean removeTask(String task_id)
	{
		
		//  Search tasks.
		for (int index = 0; index < tasks.size(); index++)
		{
			
			if (tasks.get(index).getTaskId().equals(task_id))
			{
				
				//  Found.  Remove and return true.
				tasks.remove(index);
				return true;
				
			}
			
		}
		//  If we get here it wasn't found.
		return false;
		
	}
	
	/**
	 * Method to update the task name of a task by task_id
	 * @param task_id
	 * @param task_name
	 * @return boolean true if found, false if not
	 */
	public boolean updateTaskName(String task_id, String task_name)
	{
		
		//  Search all contacts.
		for (int index = 0; index < tasks.size(); index++)
		{
			
			if (tasks.get(index).getTaskId().equals(task_id))
			{
				
				//  task_id found.  Update and return true.
				tasks.get(index).setName(task_name);
				return true;
				
			}
			
		}
		//  If we get here it wasn't found.
		return false;
		
	}
	
	/**
	 * Method to update the description of a task by task_id
	 * @param task_id
	 * @param task_description
	 * @return boolean true if found false if not.
	 */
	public boolean updateTaskDescription(String task_id, String task_description)
	{
		
		//  Search contacts.
		for (int index = 0; index < tasks.size(); index++)
		{
			
			if (tasks.get(index).getTaskId().equals(task_id))
			{
				
				//  Contact found.  Update and return true.
				tasks.get(index).setDescription(task_description);
				return true;
				
			}
			
		}
		//  If we get here it wasn't found.
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
			for (int index = 0; index < tasks.size(); index++)
			{
				
				if (tasks.get(index).getTaskId().equals(randomUUID))
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
	private ArrayList<Task> tasks;

}

