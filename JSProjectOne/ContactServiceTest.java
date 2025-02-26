package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    @BeforeEach
    void tearDown() {
        ContactService.clear(); // Clear the contact list before each test
    }

    @DisplayName("Test addContact.")
    @Test
    void testAddContact() {
        String firstName = "Mike";
        String lastName = "Jones";
        String phoneNumber = "2225678900";
        String address = "1222 Side Peak Dr";

        ContactService test = new ContactService();
        assertTrue(ContactService.getContactList().isEmpty(), "Contact list should be empty initially.");

        test.addContact(firstName, lastName, phoneNumber, address);

        assertFalse(ContactService.getContactList().isEmpty(), "Contact list should not be empty after adding a contact.");
        assertEquals("0", ContactService.getContactList().get(0).getContactID(), "Contact ID should be 0.");
        assertEquals(firstName, ContactService.getContactList().get(0).getFirstName(), "First name should match the input.");
        assertEquals(lastName, ContactService.getContactList().get(0).getLastName(), "Last name should match the input.");
        assertEquals(phoneNumber, ContactService.getContactList().get(0).getPhoneNumber(), "Phone number should match the input.");
        assertEquals(address, ContactService.getContactList().get(0).getAddress(), "Address should match the input.");
    }

    @DisplayName("Test deleteContact.")
    @Test
    void testDeleteContact() {
        String firstName = "Mike";
        String lastName = "Jones";
        String phoneNumber = "2225678900";
        String address = "1222 Side Peak Dr";

        ContactService test = new ContactService();
        assertTrue(ContactService.getContactList().isEmpty(), "Contact list should be empty initially.");

        test.addContact(firstName, lastName, phoneNumber, address);
        test.addContact(firstName, lastName, phoneNumber, address);
        test.addContact(firstName, lastName, phoneNumber, address);

        assertEquals(3, ContactService.getContactList().size(), "Contact list should have 3 contacts.");

        test.deleteContact("1"); // Delete the contact with ID "1"

        assertEquals(2, ContactService.getContactList().size(), "Contact list should have 2 contacts after deletion.");

        // Ensure the contact with ID "1" is deleted
        boolean contactExists = ContactService.getContactList().stream()
                .anyMatch(contact -> contact.getContactID().equals("1"));
        assertFalse(contactExists, "Contact with ID 1 should not exist in the list.");
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

        assertEquals(phoneNumber, ContactService.getContactList().get(0).getPhoneNumber(), "Phone number should match the input.");

        test.editNumber("0", "3335678900"); // Edit phone number for contact with ID "0"
        assertEquals("3335678900", ContactService.getContactList().get(0).getPhoneNumber(), "Phone number should be updated.");
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

        assertEquals(lastName, ContactService.getContactList().get(0).getLastName(), "Last name should match the input.");

        test.editLastName("0", "Smith"); // Edit last name for contact with ID "0"
        assertEquals("Smith", ContactService.getContactList().get(0).getLastName(), "Last name should be updated.");
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

        assertEquals(firstName, ContactService.getContactList().get(0).getFirstName(), "First name should match the input.");

        test.editFirstName("0", "John"); // Edit first name for contact with ID "0"
        assertEquals("John", ContactService.getContactList().get(0).getFirstName(), "First name should be updated.");
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

        assertEquals(address, ContactService.getContactList().get(0).getAddress(), "Address should match the input.");

        test.editAddress("0", "123 New Address St"); // Edit address for contact with ID "0"
        assertEquals("123 New Address St", ContactService.getContactList().get(0).getAddress(), "Address should be updated.");
    }
}
