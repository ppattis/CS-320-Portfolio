/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Four Milestone                           * *
* *   Project Description :  Task Service                                    * *
* *   File Name           :  Task.java                                       * *
* *   Description         :  Definition of the Task class.                   * *
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


public class Task 
{
	
	
	public Task(String task_id, String name, String description)
	{
		
		if ((task_id == null) || (task_id.equals("")))
		{
			
			throw new IllegalArgumentException("Null Task ID");
			
		}
		if (task_id.length() > 10)
		{
			
			throw new IllegalArgumentException("Task ID longer than 10 chars");
			
		}
		this.task_id = task_id;	
		this.setName(name);
		this.setDescription(description);
		
	}
	
	
	public String getTaskId()
	{
		
		return this.task_id;
		
	}
	
	
	public String getName()
	{
		
		return this.name;
		
	}
	
	
	public void setName(String name) throws IllegalArgumentException
	{
		
		if ((name == null) || (name.equals("")))
		{
			
			throw new IllegalArgumentException("Null Name");
			
		}
		if (name.length() > 20)
		{
			
			throw new IllegalArgumentException("Name longer than 20 chars");
			
		}
		this.name = name;		
		
	}
	
	public String getDescription()
	{
		
		return this.description;
		
	}
	
	
	public void setDescription(String description) throws IllegalArgumentException
	{
		
		if ((description == null) || (description.equals("")))
		{
			
			throw new IllegalArgumentException("Null Description");
			
		}
		if (description.length() > 50)
		{
			
			throw new IllegalArgumentException("Description longer than 50 chars");
			
		}
		this.description = description;		
		
	}
	
	
	//  Class fields...
	private String task_id;
	private String name;
	private String description;

}
