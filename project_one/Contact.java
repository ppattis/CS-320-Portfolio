/*******************************************************************************
* **************************************************************************** *
* *                                                                          * *
* *   Project Name        :  Module Three Milestone                          * *
* *   Project Description :  Contact Service                                 * *
* *   File Name           :  Contact.java                                    * *
* *   Description         :  Definition of the Contact class.                * *
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

/**
 *
 * @author P. D. Pattison
 */
public class Contact
{
    
	/**
	 * Constructor...
	 * @param contact_id
	 * @param first_name
	 * @param last_name
	 * @param phone_number
	 * @param address
	 * @throws IllegalArgumentException
	 */
    public Contact(
      String contact_id,
      String first_name,
      String last_name,
      String phone_number,
      String address
      ) throws IllegalArgumentException
    {
        
    	//  Test to verify that the contact_id is not null, empty,
    	//  or over 10 characters...
        if ((contact_id == null) || (contact_id.equals("")))
        {
            
            throw new IllegalArgumentException("Null Contact ID");
            
        }
        if (contact_id.length() > 10)
        {
            
            throw new IllegalArgumentException("Contact ID longer than 10 chars");
            
        }
        //  If we get here, contact_id is acceptable.
        this.contact_id = contact_id;
        //  Use the setters to set first_name, last_name, phone_number,
        //  and address.  The setters already have validity checks.
        this.setFirstName(first_name);
        this.setLastName(last_name);
        this.setPhoneNumber(phone_number);
        this.setAddress(address);
        
    }
    
    /**
     * Method to get the contact ID.
     * @param None
     * @return String
     */
    String getContactId()
    {
        
        return this.contact_id;
        
    }
    
    
    /**
     * Method to get the contact first name.
     * @param None
     * @return String
     */
    String getFirstName()
    {
        
        return this.first_name;
        
    }
    
    /**
     * Method to set the contact first name.
     * @param String first_name
     * @return None
     * @exception IllegalArgumentException thrown if first_name is longer than
     *   10 characters, or if it is null.
     */
    void setFirstName(String first_name) throws IllegalArgumentException
    {
        
        if ((first_name == null) || (first_name.equals("")))
        {
            
            throw new IllegalArgumentException("Null FIrst Name");
            
        }
        if (first_name.length() > 10)
        {
            
            throw new IllegalArgumentException("First Name longer than 10 chars");
            
        }
        this.first_name = first_name;
        
    }
    
    /**
     * Method to get the contact last name.
     * @param None
     * @return String
     */
    String getLastName()
    {
        
        return this.last_name;
        
    }
    
    /**
     * Method to set the contact last name.
     * @param String last_name
     * @return None
     * @exception IllegalArgumentException thrown if last_name is longer than
     *   10 characters, or if it is null.
     */
    void setLastName(String last_name) throws IllegalArgumentException
    {
        
        if ((last_name == null) || (last_name.equals("")))
        {
            
            throw new IllegalArgumentException("Null Last Name");
            
        }
        if (last_name.length() > 10)
        {
            
            throw new IllegalArgumentException("Last Name longer than 10 chars");
            
        }
        this.last_name = last_name;
        
    }
    
     /**
     * Method to get the contact phone number.
     * @param None
     * @return String
     */
    String getPhoneNumber()
    {
        
        return this.phone_number;
        
    }
    
    /**
     * Method to set the contact phone number.
     * @param String phone_number
     * @return None
     * @exception IllegalArgumentException thrown if phone_number is longer than
     *   10 characters, or if it is null.
     */
    void setPhoneNumber(String phone_number) throws IllegalArgumentException
    {
        
        if ((phone_number == null) || (phone_number.equals("")))
        {
            
            throw new IllegalArgumentException("Null Phone NUmber");
            
        }
        if (phone_number.length() > 10)
        {
            
            throw new IllegalArgumentException("Phone Number longer than 10 chars");
            
        }
        this.phone_number = phone_number;
        
    }
    
     /**
     * Method to get the contact address.
     * @param None
     * @return String
     */
    String getAddress()
    {
        
        return this.address;
        
    }
    
    /**
     * Method to set the contact address.
     * @param String address
     * @return None
     * @exception IllegalArgumentException thrown if address is longer than
     *   30 characters, or if it is null.
     */
    void setAddress(String address) throws IllegalArgumentException
    {
        
        if ((address == null) || (address.equals("")))
        {
            
            throw new IllegalArgumentException("Null Address");
            
        }
        if (address.length() > 30)
        {
            
            throw new IllegalArgumentException("Address longer than 10 chars");
            
        }
        this.address = address;
        
    }
    
     
    
    //  private members
    private String contact_id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String address;
    
}
