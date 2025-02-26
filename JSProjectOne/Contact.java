package ContactService;

public class Contact {

    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    /**
     * Validation of the ContactID.
     */
    private boolean validateID(String contactID) {
        return contactID != null && contactID.length() <= 10;
    }

    /**
     * Validation of the Last Name.
     */
    private boolean validateLastName(String lastName) {
        return lastName != null && lastName.length() <= 10;
    }

    /**
     * Validation of the First Name.
     */
    private boolean validateFirstName(String firstName) {
        return firstName != null && firstName.length() <= 10;
    }

    /**
     * Validation of the Phone Number.
     */
    private boolean validatePhone(String phoneNumber) {
        return phoneNumber != null && phoneNumber.length() == 10;
    }

    /**
     * Validation of the address.
     */
    private boolean validateAddress(String address) {
        return address != null && address.length() <= 30;
    }

    /**
     * Constructor with validation.
     */
    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        if (!validateID(contactID)) {
            throw new IllegalArgumentException("Invalid contact ID");
        }

        if (!validateFirstName(firstName)) {
            throw new IllegalArgumentException("Invalid first name");
        }

        if (!validateLastName(lastName)) {
            throw new IllegalArgumentException("Invalid last name");
        }

        if (!validatePhone(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        if (!validateAddress(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Default constructor.
     */
    public Contact() {
        this.contactID = "";
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.address = "";
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!validateFirstName(firstName)) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!validateLastName(lastName)) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!validatePhone(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!validateAddress(address)) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }

    /**
     * Checks if any field is empty.
     */
    public boolean isEmpty() {
        return contactID.isEmpty() && firstName.isEmpty() && lastName.isEmpty() 
               && phoneNumber.isEmpty() && address.isEmpty();
    }
}
