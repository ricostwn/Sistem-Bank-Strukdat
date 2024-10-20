import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        UserList userList = new UserList();
        Scanner sc = new Scanner(System.in);

        // Menambahkan data user yang sudah ada
        addInitialUsers(userList);

        int choice;

        do {
            System.out.println("\nBank Management System");
            System.out.println("1. Add User Records");
            System.out.println("2. Display User Records");
            System.out.println("3. Find User by ID");
            System.out.println("4. Find All User Records by Account Type");
            System.out.println("5. Delete User by ID");
            System.out.println("6. Write Final User Records to File");
            System.out.println("7. Exit App");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    userList.insertBack(inputUser(sc));
                    break;
                case 2:
                    userList.displayUsers();
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    User foundUser = userList.findUserById(id);
                    if (foundUser != null) {
                        foundUser.displayUser();
                    } else {
                        System.out.println("User with ID " + id + " not found.");
                    }
                    break;
                case 4:
                    sc.nextLine(); // Clear the buffer
                    System.out.print("Enter Account Type (Fixed, Saving, Checking): ");
                    String accountType = sc.nextLine();
                    userList.findUsersByAccountType(accountType);
                    break;
                case 5:
                    System.out.print("Enter User ID to Delete: ");
                    int deleteId = sc.nextInt();
                    User userToDelete = userList.findUserById(deleteId);
                    if (userToDelete != null) {
                        System.out.print("Are you sure you want to delete user with ID " + deleteId + "? (yes/no): ");
                        String confirmation = sc.next();
                        if (confirmation.equalsIgnoreCase("yes")) {
                            userList.removeAt(deleteId); // Delete user by ID
                        }
                    } else {
                        System.out.println("User with ID " + deleteId + " not found.");
                    }
                    break;
                case 6:
                    userList.writeToFile("users.txt");
                    break;
                case 7:
                    System.out.println("Exiting the app...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        sc.close();
    }

    // Function to input user data from user
    public static User inputUser(Scanner sc) {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Clear the buffer

        System.out.print("Enter User Name: ");
        String name = sc.nextLine();

        System.out.print("Enter User Address: ");
        String address = sc.nextLine();

        System.out.print("Enter User Date of Birth (dd-mm-yyyy): ");
        String dob = sc.nextLine();

        System.out.print("Enter User Phone Number: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Enter Account Balance: ");
        double balance = sc.nextDouble();

        sc.nextLine(); // Clear the buffer

        System.out.print("Enter Account Type (Fixed, Saving, Checking): ");
        String accountType = sc.nextLine();

        double fixedDailyInterest = 0.0;
        if (accountType.equalsIgnoreCase("Fixed")) {
            System.out.print("Enter Fixed Daily Interest: ");
            fixedDailyInterest = sc.nextDouble();
        }

        return new User(id, name, address, dob, phoneNumber, balance, accountType, fixedDailyInterest);
    }

    // Function to add initial user records
    public static void addInitialUsers(UserList userList) {
        User user1 = new User(123, "Matt Damon", "465 Ripley Boulevard, Oscar Mansion, Singapore 7666322", "10-10-1970", "790-3233", 405600.00, "Fixed", 0.05);
        User user2 = new User(126, "Ben Affleck", "200 Hunting Street, Singapore 784563", "25-10-1968", "432-4579", 530045.00, "Saving");
        User user3 = new User(65, "Salma Hayek", "45 Mexican Boulevard, Hotel California, Singapore 467822", "06-04-73", "790-0000", 2345.00, "Checking");
        User user4 = new User(78, "Phua Chu Kang", "50 PCK Avenue, Singapore 639798", "11-08-64", "345-6780", 0.00, "Checking");
        User user5 = new User(234, "Zoe Tay", "100 Blue Eyed St, Singapore 456872", "15-02-68", "456-1234", 600.00, "Saving");

        // Insert these users into the linked list
        userList.insertBack(user1);
        userList.insertBack(user2);
        userList.insertBack(user3);
        userList.insertBack(user4);
        userList.insertBack(user5);
    }
}
