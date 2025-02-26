package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {

    @DisplayName("Check for a valid Constructor.")
    @Test
    public void testConstructorWithValidInput() {
        String contactId = "1";
        String firstName = "Mike";
        String lastName = "Jones";
        String phoneNumber = "2225678900";
        String address = "1222 Side Peak Dr";

        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);

        assertEquals(contactId, testContact.getContactID(), "Contact ID should match the input.");
        assertEquals(firstName, testContact.getFirstName(), "First name should match the input.");
        assertEquals(lastName, testContact.getLastName(), "Last name should match the input.");
        assertEquals(phoneNumber, testContact.getPhoneNumber(), "Phone number should match the input.");
        assertEquals(address, testContact.getAddress(), "Address should match the input.");
    }

    @DisplayName("Check for an invalid Constructor with null contactId.")
    @Test
    public void testConstructorWithNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Mike", "Jones", "2225678900", "1222 Side Peak Dr");
        }, "Constructor should throw IllegalArgumentException when contactId is null.");
    }

    @DisplayName("Check for a valid setFirstName.")
    @Test
    public void testSetFirstNameWithValidInput() {
        Contact testContact = new Contact("3", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");
        testContact.setFirstName("Test");
        assertEquals("Test", testContact.getFirstName(), "First name should be updated to 'Test'.");
    }

    @DisplayName("Check for an invalid null setFirstName.")
    @Test
    public void testSetFirstNameWithNullInput() {
        Contact testContact = new Contact("4", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");

        assertThrows(IllegalArgumentException.class, () -> {
            testContact.setFirstName(null);
        }, "setFirstName should throw IllegalArgumentException when first name is null.");
    }

    @DisplayName("Check for a valid setLastName.")
    @Test
    public void testSetLastNameWithValidInput() {
        Contact testContact = new Contact("5", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");
        testContact.setLastName("Smith");
        assertEquals("Smith", testContact.getLastName(), "Last name should be updated to 'Smith'.");
    }

    @DisplayName("Check for an invalid null setLastName.")
    @Test
    public void testSetLastNameWithNullInput() {
        Contact testContact = new Contact("6", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");

        assertThrows(IllegalArgumentException.class, () -> {
            testContact.setLastName(null);
        }, "setLastName should throw IllegalArgumentException when last name is null.");
    }

    @DisplayName("Check for a valid setPhoneNumber.")
    @Test
    public void testSetPhoneNumberWithValidInput() {
        Contact testContact = new Contact("7", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");
        testContact.setPhoneNumber("1234567890");
        assertEquals("1234567890", testContact.getPhoneNumber(), "Phone number should be updated to '1234567890'.");
    }

    @DisplayName("Check for an invalid null setPhoneNumber.")
    @Test
    public void testSetPhoneNumberWithNullInput() {
        Contact testContact = new Contact("8", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");

        assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhoneNumber(null);
        }, "setPhoneNumber should throw IllegalArgumentException when phone number is null.");
    }

    @DisplayName("Check for a valid setAddress.")
    @Test
    public void testSetAddressWithValidInput() {
        Contact testContact = new Contact("9", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");
        testContact.setAddress("456 New Address Ln");
        assertEquals("456 New Address Ln", testContact.getAddress(), "Address should be updated to '456 New Address Ln'.");
    }

    @DisplayName("Check for an invalid null setAddress.")
    @Test
    public void testSetAddressWithNullInput() {
        Contact testContact = new Contact("10", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");

        assertThrows(IllegalArgumentException.class, () -> {
            testContact.setAddress(null);
        }, "setAddress should throw IllegalArgumentException when address is null.");
    }

    @DisplayName("Check getContactID.")
    @Test
    public void testGetContactID() {
        Contact testContact = new Contact("4", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");
        assertEquals("4", testContact.getContactID(), "Contact ID should match the input.");
    }

    @DisplayName("Check for bad getContactID.")
    @Test
    public void testGetContactIDWithUnexpectedValue() {
        Contact testContact = new Contact("4", "Mike", "Jones", "2225678900", "1222 Side Peak Dr");
        assertNotEquals("3", testContact.getContactID(), "Contact ID should not be '3'.");
    }
}
