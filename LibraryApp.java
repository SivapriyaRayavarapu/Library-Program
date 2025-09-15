import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    int id;
    String title, author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + ". " + title + " by " + author;
    }
}

// Library class
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println("✅ Book added: " + b.title);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("📭 No books in library.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public void searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                System.out.println("🔍 Found: " + b);
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }
}

// Main class
public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book\n2. View Books\n3. Search Book\n4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: "); String title = sc.nextLine();
                    System.out.print("Enter Author: "); String author = sc.nextLine();
                    lib.addBook(new Book(id, title, author));
                }
                case 2 -> lib.viewBooks();
                case 3 -> {
                    System.out.print("Enter Title to search: ");
                    String t = sc.nextLine();
                    lib.searchBook(t);
                }
                case 4 -> System.out.println("👋 Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}
