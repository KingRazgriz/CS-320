package ContactService;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private static List<ContactService> contactList = new ArrayList<>();
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Constructor for creating a contact with all details
    public ContactService(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Default constructor for initializing empty object
    public ContactService() {
        this.contactID = String.valueOf(contactList.size());
    }

    // Getters and Setters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Static method to clear the contact list
    public static void clear() {
        contactList.clear();
    }

    // Add contact method
    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        ContactService newContact = new ContactService(String.valueOf(contactList.size()), firstName, lastName, phoneNumber, address);
        contactList.add(newContact);
    }

    // Delete contact by ID
    public void deleteContact(String contactID) {
        contactList.removeIf(contact -> contact.getContactID().equals(contactID));
    }

    // Edit first name by ID
    public void editFirstName(String contactID, String newFirstName) {
        contactList.stream()
                .filter(contact -> contact.getContactID().equals(contactID))
                .findFirst()
                .ifPresent(contact -> contact.setFirstName(newFirstName));
    }

    // Edit last name by ID
    public void editLastName(String contactID, String newLastName) {
        contactList.stream()
                .filter(contact -> contact.getContactID().equals(contactID))
                .findFirst()
                .ifPresent(contact -> contact.setLastName(newLastName));
    }

    // Edit phone number by ID
    public void editNumber(String contactID, String newPhoneNumber) {
        contactList.stream()
                .filter(contact -> contact.getContactID().equals(contactID))
                .findFirst()
                .ifPresent(contact -> contact.setPhoneNumber(newPhoneNumber));
    }

    // Edit address by ID
    public void editAddress(String contactID, String newAddress) {
        contactList.stream()
                .filter(contact -> contact.getContactID().equals(contactID))
                .findFirst()
                .ifPresent(contact -> contact.setAddress(newAddress));
    }

    // Method to get the list of all contacts
    public static List<ContactService> getContactList() {
        return contactList;
    }
}
