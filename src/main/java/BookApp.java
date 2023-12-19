import java.util.Scanner;

public class BookApp {
    private static BookDao bookDao = new BookDaoImpl(JDBConnection.getConnection());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("""
                    Book Store!
                    Choose:
                    1. Add a new book
                    2. Update a book
                    3. Delete a book
                    4. See a book
                    5. Display all books
                    6. Exit
                    """);
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    updateBook(sc);
                    break;
                case 3:
                    deleteBook(sc);
                    break;
                case 4:
                    displayBook(sc);
                    break;
                case 5:
                    displayAllBooks(sc);
                    break;
                case 6:
                    System.out.println("Exiting application...");
                default:
                    System.out.println("Invalid input.");
            }
        } while (choice != 6);
    }

    private static void displayAllBooks(Scanner sc) {
        for (Book book : bookDao.getAllBooks()){
            System.out.println(book);
        }
    }

    private static void displayBook(Scanner sc) {
        System.out.println("Please print Book ID: ");
        int bookId = sc.nextInt();
        Book book = bookDao.getBookById(bookId);
        if (book== null){
            System.out.println("No books found.");
        } else {
            System.out.println(book);
        }
    }

    private static void deleteBook(Scanner sc) {
    }

    private static void updateBook(Scanner sc) {
    }

    private static void addBook(Scanner sc) {
        System.out.println("Enter Book title: ");
        String title = sc.nextLine();
        System.out.println("Enter Book author: ");
        String author = sc.nextLine();
        System.out.println("Enter Book genre: ");
        String genre = sc.nextLine();
        System.out.println("Enter Book price: ");
        double price = sc.nextDouble();
        Book book = new Book(title, author, genre, price);
        bookDao.addBook(book);
        System.out.println("Book successfully added.");
    }
}
