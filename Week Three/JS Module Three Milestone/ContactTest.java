/** Jamar Sampson
*  Jan 24th, 2025
*  CS 320
*/

 package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest{

	/**
	 * Checks the constructor for good behavior.	
	 */
	@DisplayName("Check for a valid Constructor.")
	@Test
	public void testGoodConstructor() {
        String contactId = "1.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);
        
		assertEquals(1, testContact.getContactID());
		assertEquals(firstName, testContact.getFirstName());
		assertEquals(lastName, testContact.getLastName());
		assertEquals(phoneNumber, testContact.getPhoneNumber());
		assertEquals(address, testContact.getAddress());
	}
	
	/**
	 * Check for invalid phone number length from the Constructor.
	 */
	@DisplayName("Check for an invalid Constructor.")
	@Test
	public void testBadConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new ContactTest();
        });
	}
	
	/**
	 * Check setFirstName for proper input. 
	 */
	@DisplayName("Check for a valid setFirstName.")
	@Test
	public void testGoodSetFirst() {
        String contactId = "3.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setFirstName("Test");        
        assertEquals("Test", testContact.getFirstName());
	}
	
	/**
	 * Checks the setFirstName with a null string. Should present an error.
	 */
	@DisplayName("Check for an invalid null setFirstName.")
	@Test
	public void testBadSetFirst() {
		 String contactId = "4.";
	        String firstName = "Mike"; 
			String lastName = "Jones"; 
			String phoneNumber = "2225678900"; 
			String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName(null);
        });
	}
	
	/**
	 * Checks the setFirstName with length that exceeds proposed limit. Should present an error.
	 */
	@DisplayName("Checks for an invalid length setFirstName.")
	@Test
	public void testLongSetFirst() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName("IamWayTooLongOfAFirstName");
        });
	}
	
	/**
	 * Checks getID by using a good constructor & then evaluates for a returned integer.
	 */
	@DisplayName("Check getID.")
	@Test
	public void testGetID() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        assertEquals(3, testContact.getContactID());
	}
	
	/**
	 * Checks the getID by using a good constructor & then evaluates that a string IS NOT returned.
	 */
	@DisplayName("Check for bad getID.")
	@Test
	public void testBadGetID() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        assertNotEquals("3", testContact.getContactID());
	}
	
	/**
	 * Checks the getID by using an ID longer then expected in the constructor.
	 */
	@DisplayName("Test longer than expected getID.")
	@Test
	public void testlongGetID() {
        ;
		
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new ContactTest();
        });
	}
	
	/**
	 * Checks for the setLastName with a null string. Should present an error.
	 */
	@DisplayName("Check for an invalid null setLastName.")
	@Test
	public void testBadSetLast() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName(null);
        });
	}
	
	/**
	 * Checks the setLastName with length too great. Should present an error.
	 */
	@DisplayName("Checks for an invalid length setLastName.")
	@Test
	public void testLongSetLast() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setLastName("SuperCaliFragilisticExpialiDocious");
        });
	}
	
	/**
	 * Checks the setLastName with good input. 
	 */
	@DisplayName("Checks for a valid setLastName.")
	@Test
	public void testGoodsetLast() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setLastName("Test");        
        assertEquals("Test", testContact.getLastName());
	}
	
	/**
	 * Checks for a  setPhoneNumber with a null string. Should present an error.
	 */
	@DisplayName("Check for an invalid null setPhoneNumber.")
	@Test
	public void testBadSetPhone() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber(null);
        });
        
	}
	
	/**
	 * Checks that the setPhone with length != 10. Should present an exception. 
	 */
	@DisplayName("Checks for an invalid length setPhoneNumber.")
	@Test
	public void testWrongLengthPhone() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber("1");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setPhoneNumber("123456789101112131415");
        });
	}
	/**
	 * Checks for the setPhone with length 10.
	 */
	@DisplayName("Checks for a valid length setPhoneNumber.")
	@Test
	public void testGoodPhone() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setPhoneNumber("1987654321");        
        assertEquals("1987654321", testContact.getPhoneNumber());

	}
	
	/**
	 * Checks for a setAddress with a null string. Should present an error.
	 */
	@DisplayName("Checks for an invalid null setAddress.")
	@Test
	public void testNullSetAddress() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress(null);
        });
        
	}
	
	/**
	 * Check for a setAddress with length > 30. Should present an exception. 
	 */
	@DisplayName("Checks for invalid length setPhoneNumber.")
	@Test
	public void testWrongLengthAddress() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress("8008 Toys R Us / Babies R Us Blvd, Second Floor Plaza");
        });
	}
	/**
	 * Checks the setAddress with good input.
	 */
	@DisplayName("Checks for the proper length of setAddress.")
	@Test
	public void testGoodAddress() {
		String contactId = "4.";
        String firstName = "Mike"; 
		String lastName = "Jones"; 
		String phoneNumber = "2225678900"; 
		String address = "1222 Side Peak Dr";
		
        org.snhu.cs320.contact.Contact testContact = new org.snhu.cs320.contact.Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setAddress("8008 Nerd St");        
        assertEquals("8008 Nerd St", testContact.getAddress());

	}
	
}
