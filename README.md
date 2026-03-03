# Address-Book-System-IO

Welcome to the **Address Book System**! This repository tracks the development of a fully-functional, Java-based Console application designed to manage and organize contacts across multiple address books with File I/O support. 

## Features Integrated

The application was built out progressively through various use cases (UCs), implementing the following robust functionalities:

1. **Object-Oriented Structure**: Employs `AddressBook` and `Contact` model classes to establish clear data separation.
2. **Console Interactive Flow**: A complete CLI interface enabling easy interaction to Create, Read, Update, and Delete options natively.
3. **Multi-Address Book Handling**: Allows the usage of Java Dictionaries (`java.util.Map`) to maintain an arbitrary number of uniquely named Address Books seamlessly within memory.
4. **Duplicate Prevention**: Overrides standard `equals()` and `hashCode()` methods. Java `Streams` verify and prevent any duplicate insertions dynamically.
5. **Advanced Searching & Viewing**: Use `Streams` and Collection views to search, list, or pinpoint Contacts globally by their respective City or State identifiers.
6. **Detailed Counting Mechanism**: Fetch total person counts belonging accurately to a given City or State.
7. **Sorting Algorithms**: Contacts can be easily sorted out natively alphabetically by Name, Location (City/State), or Zip code leveraging `Collections` formatting out by overriding object's `toString()` output.
8. **Permanent Persistence**: Reads and Writes contacts reliably securely formatting `addressbook.txt` natively on the filesystem using robust **Java NIO File I/O** streams capabilities to save states gracefully between terminal exit events.

## Branching Stratergy

Developed cohesively leveraging standard **Git Flow**:
- `main`: Holds the foundational project description (`README.md`).
- `develop`: Dedicated active tracking branch consolidating commits across all implementations efficiently.
- `feature/UC*`: Standard active development branches containing granular feature logic updates per use case directly.

## Usage

Simply run and compile dynamically:
```bash
javac src/main/java/*.java
java -cp src/main/java AddressBookMain
```
Follow the native prompted interactive menu. Data written and created actively will compile inside the root directory file `addressbook.txt`.