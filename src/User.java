public class User {
    private int id;
    private String name;
    private String address;
    private String dob; // Date of Birth
    private String phoneNumber;
    private double balance;
    private String accountType;
    private double fixedDailyInterest; // only for Fixed accounts

    // Constructor for all account types including Fixed
    public User(int id, String name, String address, String dob, String phoneNumber, double balance, String accountType, double fixedDailyInterest) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.fixedDailyInterest = fixedDailyInterest;
    }

    // Constructor for Saving and Checking accounts (without fixedDailyInterest)
    public User(int id, String name, String address, String dob, String phoneNumber, double balance, String accountType) {
        this(id, name, address, dob, phoneNumber, balance, accountType, 0.0); // Set fixedDailyInterest to 0.0
    }

    // Method to display user information
    public void displayUser() {
        System.out.println("Account ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Account Balance: $" + balance);
        System.out.println("Account Type: " + accountType);
        if (accountType.equalsIgnoreCase("Fixed")) {
            System.out.println("Fixed Daily Interest: " + fixedDailyInterest);
        }
        System.out.println("Kelompok 11: Nathanael Rico Setiawan dan Nicola Adhi Pratama");
    }

    // Getter methods for user properties
    public int getId() {
        return id;
    }

    public String getAccountType() {
        return accountType;
    }
}
