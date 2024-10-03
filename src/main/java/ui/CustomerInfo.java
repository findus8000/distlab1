package ui;

public class CustomerInfo {
    private int CustomerID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
    private String PasswordHash;

    public CustomerInfo(int customerID, String passwordHash, String phoneNumber, String email, String lastName, String firstName) {
        CustomerID = customerID;
        PasswordHash = passwordHash;
        PhoneNumber = phoneNumber;
        Email = email;
        LastName = lastName;
        FirstName = firstName;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getPasswordHash() {
        return PasswordHash;
    }

    public void setPasswordHash(String passwordHash) {
        PasswordHash = passwordHash;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}
