import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "rt.org";

    // Constructor to receive the first name and last name
    public Email(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;

        // Call a method asking for the department (return the department)
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstname.toLowerCase() + "." + lastname.toLowerCase() + "@" + department + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("New Employee: " + firstname + "\nDepartment Codes: \n" + "1 for Sales\n" + "2 for Development\n" + "3 for Accounting\n" + "0 for none\n" + "Enter The Department Code: ");
        Scanner sc = new Scanner(System.in);
        int departmentChoice = sc.nextInt();
        if (departmentChoice == 1) return "sales.";
        else if (departmentChoice == 2) return "development.";
        else if (departmentChoice == 3) return "accounting.";
        else return "";

    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "QWERTYUIOPASDFGHJKLZXCVBNM_1234567890";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
         return "DISPLAY NAME: " + firstname + " " + lastname +
                 "\nCOMPANY EMAIL: " + email +
                 "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
