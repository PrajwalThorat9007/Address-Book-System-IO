public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        Contact contact = new Contact("John", "Doe", "123 Main St", "Cityville", "State", "12345", "1234567890",
                "john@example.com");
        System.out.println("Created test contact: " + contact);
    }
}
