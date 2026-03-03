import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Scanner scanner) {
        boolean addMore = true;
        while (addMore) {
            System.out.println("Enter First Name:");
            String firstName = scanner.nextLine();
            System.out.println("Enter Last Name:");
            String lastName = scanner.nextLine();

            // Duplicate Check
            boolean isDuplicate = contacts.stream()
                    .anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(firstName) &&
                            contact.getLastName().equalsIgnoreCase(lastName));

            if (isDuplicate) {
                System.out.println("Duplicate entry found! A contact with this name already exists.");
            } else {
                System.out.println("Enter Address:");
                String address = scanner.nextLine();
                System.out.println("Enter City:");
                String city = scanner.nextLine();
                System.out.println("Enter State:");
                String state = scanner.nextLine();
                System.out.println("Enter Zip:");
                String zip = scanner.nextLine();
                System.out.println("Enter Phone Number:");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter Email:");
                String email = scanner.nextLine();

                Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                contacts.add(contact);
                System.out.println("Contact added successfully!");
            }

            System.out.println("Do you want to add another contact? (y/n)");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                addMore = false;
            }
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address Book is empty.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void editContact(Scanner scanner) {
        System.out.println("Enter the First Name of the contact to edit:");
        String name = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getFirstName().equalsIgnoreCase(name)) {
                System.out.println("Contact found. Enter new details.");
                System.out.println("Enter Last Name:");
                contact.setLastName(scanner.nextLine());
                System.out.println("Enter Address:");
                contact.setAddress(scanner.nextLine());
                System.out.println("Enter City:");
                contact.setCity(scanner.nextLine());
                System.out.println("Enter State:");
                contact.setState(scanner.nextLine());
                System.out.println("Enter Zip:");
                contact.setZip(scanner.nextLine());
                System.out.println("Enter Phone Number:");
                contact.setPhoneNumber(scanner.nextLine());
                System.out.println("Enter Email:");
                contact.setEmail(scanner.nextLine());

                System.out.println("Contact updated successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(Scanner scanner) {
        System.out.println("Enter the First Name of the contact to delete:");
        String name = scanner.nextLine();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}
