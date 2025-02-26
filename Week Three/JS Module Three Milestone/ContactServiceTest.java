/** Jamar Sampson
*  Jan 24th, 2025
*  CS 320
*/

package org.snhu.cs320.contact;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	void tearDown() throws Exception {
		ContactService.contactList.clear();
	}

	@DisplayName("Test addContact.")
	@Test
	void testAddContact() {

		String firstName = "Mike";
		String lastName = "Jones";
		String phoneNumber = "2225678900";
		String address = "1222 Side Peak Dr";

		ContactService test = new ContactService();

		assertTrue(ContactService.contactList.isEmpty());

		test.addContact(firstName, lastName, phoneNumber, address);

		assertFalse(ContactService.contactList.isEmpty());
		assertEquals(0, ContactService.contactList.get(0).getContactID());
		assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
		assertEquals(lastName, ContactService.contactList.get(0).getLastName());
		assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
		assertEquals(address, ContactService.contactList.get(0).getAddress());

	}
	
	@DisplayName("Test deleteContact.")			  
	@Test void testDeleteContact() {
				  
		String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		boolean testBool = false;
		  
		ContactService test = new ContactService();
		  
		assertTrue(ContactService.contactList.isEmpty());
		 
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		test.addContact(firstName, lastName, phoneNumber, address);
		  
		assertEquals(3,ContactService.contactList.size());
		  
		test.deleteContact("1");
		  
		assertEquals(2,ContactService.contactList.size());
		 
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getContactID() == 1) {
				testBool = true;
			}
		}		
		assertFalse(testBool);				 
	}
	
	@DisplayName("Test editing a phone number.")
	@Test
	void testEditPhone() {
		
		String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		  
		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
		
		test.editNumber("1.", "2225678900");
		assertEquals("2225678900", ContactService.contactList.get(0).getPhoneNumber());
	}
	
	@DisplayName("Test editing a last name.")
	@Test
	void testEditLast() {
		
		String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		  
		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(lastName, ContactService.contactList.get(0).getLastName());
		
		test.editLastName("0", "Test_Name");
		assertEquals("Test_Name", ContactService.contactList.get(0).getLastName());
	}
	
	@DisplayName("Test editing a first name.")
	@Test
	void testEditFirst() {
		
		String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";

		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
		
		test.editFirstName("1.", "Test_First");
		assertEquals("Test_First", ContactService.contactList.get(0).getFirstName());
	}
	
	@DisplayName("Test editing an address.")
	@Test
	void testEditAddress() {
		
		String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";

		ContactService test = new ContactService();
		test.addContact(firstName, lastName, phoneNumber, address);
		
		assertEquals(address, ContactService.contactList.get(0).getAddress());
		
		test.editAddress("0", "Test_Address");
		assertEquals("Test_Address", ContactService.contactList.get(0).getAddress());
	}
}

