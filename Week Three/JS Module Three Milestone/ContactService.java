/** Jamar Sampson
*  Jan 24th, 2025
*  CS 320
*/

package org.snhu.cs320.contact;


import java.util.List;
import java.util.ArrayList;


public class ContactService {
	
	int currentIDNum = 0;

	//Creates an arraylist to hold the objects.
	public static List<Contact> contactList = new ArrayList<Contact>();
	
	
	public void addContact(String firstName, String lastName,
			String phoneNumber, String address) {
		
		String stringID = Integer.toString(currentIDNum);
		
		Contact newContact = new Contact(stringID, firstName, lastName, phoneNumber, address);
		contactList.add(newContact.getContactID(),newContact);
		
		//increment the ID NUM
		++currentIDNum;

	}
	

	public void deleteContact(String ID) {
		int intID = Integer.valueOf(ID);


		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getContactID() == intID) {
				contactList.remove(i);
			}
		}
	}
	
	public void editFirstName(String contactID, String firstName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setFirstName(firstName);				
			}			
		}	
	}

	public void editLastName(String contactID, String lastName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setLastName(lastName);				
			}			
		}	
	}
	public void editNumber(String contactID, String phoneNumber) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setPhoneNumber(phoneNumber);				
			}			
		}	
	}
	public void editAddress(String contactID, String address) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setAddress(address);				
			}			
		}	
	}

}
