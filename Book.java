public class Book {
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book not available");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned successfully");
    }

    @Override
    public String toString() {
        return "Book{" + "bookId='" + bookId + '\'' + ", title='" + title + '\'' + ", author='" + author + '\'' + ", isAvailable=" + isAvailable + '}';
    }
}
