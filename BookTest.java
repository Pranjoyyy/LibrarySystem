import java.util.ArrayList;
import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        // Ask the user how many books they want to manage
        System.out.print("How many books do you want to manage? ");
        int numberOfBooks = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Input details for each book with validation
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println("\nEnter details for book " + (i + 1) + ":");

            // Input and validate Book ID
            String bookId;
            while (true) {
                System.out.print("Enter Book ID: ");
                bookId = scanner.nextLine();
                if (bookId.matches("^[A-Z0-9]+$")) {
                    break;
                } else {
                    System.out.println("Invalid Book ID. Please use only uppercase letters and numbers.");
                }
            }

            // Input and validate Title
            String title;
            while (true) {
                System.out.print("Enter Title: ");
                title = scanner.nextLine();
                if (title.matches("^[A-Za-z ]+$")) {
                    break;
                } else {
                    System.out.println("Invalid Title. Please use only alphabetic characters.");
                }
            }

            // Input and validate Author
            String author;
            while (true) {
                System.out.print("Enter Author: ");
                author = scanner.nextLine();
                if (author.matches("^[A-Za-z ]+$")) {
                    break;
                } else {
                    System.out.println("Invalid Author name. Please use only alphabetic characters.");
                }
            }

            // Add the book to the list
            books.add(new Book(bookId, title, author));
        }

        System.out.println("\nBooks created successfully!");

        // Interactive menu for book operations
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. Display all books");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the Book ID to borrow: ");
                    String borrowId = scanner.nextLine();
                    boolean foundToBorrow = false;
                    for (Book book : books) {
                        if (book.toString().contains(borrowId)) {
                            book.borrowBook();
                            foundToBorrow = true;
                            break;
                        }
                    }
                    if (!foundToBorrow) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 2:
                    System.out.print("Enter the Book ID to return: ");
                    String returnId = scanner.nextLine();
                    boolean foundToReturn = false;
                    for (Book book : books) {
                        if (book.toString().contains(returnId)) {
                            book.returnBook();
                            foundToReturn = true;
                            break;
                        }
                    }
                    if (!foundToReturn) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 3:
                    System.out.println("\nBooks details:");
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
