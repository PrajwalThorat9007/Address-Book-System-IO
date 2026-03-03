import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Scanner scanner = new Scanner(System.in);
        Map<String, AddressBook> addressBookMap = new HashMap<>();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Access Address Book");
            System.out.println("3. Search Person by City or State");
            System.out.println("4. View Persons by City or State");
            System.out.println("5. Count Persons by City or State");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter name for new Address Book:");
                    String name = scanner.nextLine();
                    if (addressBookMap.containsKey(name)) {
                        System.out.println("Address Book already exists.");
                    } else {
                        addressBookMap.put(name, new AddressBook());
                        System.out.println("Address Book '" + name + "' created successfully.");
                    }
                    break;
                case 2:
                    System.out.println("Enter name of Address Book to access:");
                    String accessName = scanner.nextLine();
                    if (addressBookMap.containsKey(accessName)) {
                        manageAddressBook(addressBookMap.get(accessName), scanner);
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;
                case 3:
                    System.out.println("Search by: 1. City 2. State");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter location name:");
                    String location = scanner.nextLine();

                    addressBookMap.values().stream()
                            .flatMap(ab -> ab.getContacts().stream())
                            .filter(contact -> (searchChoice == 1 && contact.getCity().equalsIgnoreCase(location)) ||
                                    (searchChoice == 2 && contact.getState().equalsIgnoreCase(location)))
                            .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("View by: 1. City 2. State");
                    int viewChoice = scanner.nextInt();
                    scanner.nextLine();

                    Map<String, List<Contact>> viewMap = new HashMap<>();
                    addressBookMap.values().forEach(ab -> ab.getContacts().forEach(contact -> {
                        String key = (viewChoice == 1) ? contact.getCity() : contact.getState();
                        viewMap.computeIfAbsent(key, k -> new java.util.ArrayList<>()).add(contact);
                    }));

                    viewMap.forEach((key, list) -> {
                        System.out.println("\n--- " + key + " ---");
                        list.forEach(System.out::println);
                    });
                    break;
                case 5:
                    System.out.println("Count by: 1. City 2. State");
                    int countChoice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter location name:");
                    String countLocation = scanner.nextLine();

                    long count = addressBookMap.values().stream()
                            .flatMap(ab -> ab.getContacts().stream())
                            .filter(contact -> (countChoice == 1 && contact.getCity().equalsIgnoreCase(countLocation))
                                    ||
                                    (countChoice == 2 && contact.getState().equalsIgnoreCase(countLocation)))
                            .count();
                    System.out.println("Total Persons: " + count);
                    break;
                case 6:
                    System.out.println("Sort by: 1. Name 2. City 3. State 4. Zip");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();

                    addressBookMap.values().stream()
                            .flatMap(ab -> ab.getContacts().stream())
                            .sorted((c1, c2) -> {
                                switch (sortChoice) {
                                    case 1:
                                        return c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
                                    case 2:
                                        return c1.getCity().compareToIgnoreCase(c2.getCity());
                                    case 3:
                                        return c1.getState().compareToIgnoreCase(c2.getState());
                                    case 4:
                                        return c1.getZip().compareToIgnoreCase(c2.getZip());
                                    default:
                                        return 0;
                                }
                            })
                            .forEach(System.out::println);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting Address Book Program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void manageAddressBook(AddressBook addressBook, Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Back to Main Menu");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addressBook.addContact(scanner);
                    break;
                case 2:
                    addressBook.displayContacts();
                    break;
                case 3:
                    addressBook.editContact(scanner);
                    break;
                case 4:
                    addressBook.deleteContact(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
