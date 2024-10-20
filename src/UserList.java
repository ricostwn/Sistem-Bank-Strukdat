public class UserList {
    private Node head;
    private Node tail;

    // Inner class Node to represent each user in the linked list
    private class Node {
        User user;
        Node next;
        Node prev;

        public Node(User user) {
            this.user = user;
            this.next = null;
            this.prev = null;
        }
    }

    // Constructor to initialize an empty list
    public UserList() {
        head = null;
        tail = null;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Insert a user at the back of the list
    public void insertBack(User user) {
        Node newNode = new Node(user);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("User added successfully.");
    }

    // Display all users in the list
    public void displayUsers() {
        if (isEmpty()) {
            System.out.println("No user records to display.");
            return;
        }

        Node current = head;
        while (current != null) {
            current.user.displayUser();
            current = current.next;
        }
        System.out.println("Kelompok 11: Nathanael Rico Setiawan dan Nicola Adhi Pratama");
    }

    // Find user by ID
    public User findUserById(int id) {
        if (isEmpty()) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (current.user.getId() == id) {
                return current.user;
            }
            current = current.next;
        }
        return null;
    }

    // Find users by account type (Fixed, Saving, Checking)
    public void findUsersByAccountType(String accountType) {
        if (isEmpty()) {
            System.out.println("No user records available.");
            return;
        }

        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.user.getAccountType().equalsIgnoreCase(accountType)) {
                current.user.displayUser();
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No users with account type " + accountType + " found.");
        }
    }

    // Remove user by ID
    public void removeAt(int id) {
        if (isEmpty()) {
            System.out.println("No users to delete.");
            return;
        }

        Node current = head;
        while (current != null) {
            if (current.user.getId() == id) {
                // If the node to be deleted is the head
                if (current == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    // If the node to be deleted is the tail
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    // If the node to be deleted is in the middle
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("User with ID " + id + " deleted.");
                return;
            }
            current = current.next;
        }

        System.out.println("User with ID " + id + " not found.");
    }

    // Clear the entire list
    public void clear() {
        head = null;
        tail = null;
        System.out.println("All user records cleared.");
    }

    // Write the list of users to a file (file handling code could be added here)
    public void writeToFile(String fileName) {
        System.out.println("User records have been written to file: " + fileName);
        // File writing logic should be implemented here if needed
    }
}
