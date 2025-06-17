import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title.toLowerCase(); 
        this.author = author.toLowerCase();
    }

    public void print() {
        System.out.println("[" + bookId + "] " + title + " by " + author);
    }
}

public class Main {

    public static List<Book> linearSearch(List<Book> books, String query) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.title.contains(query.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }


    public static Book binarySearch(List<Book> sortedBooks, String query) {
        int left = 0, right = sortedBooks.size() - 1;
        query = query.toLowerCase();
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = sortedBooks.get(mid).title.compareTo(query);
            if (cmp == 0) return sortedBooks.get(mid);
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Thirukkural", "Tiruvalluvar"));
        books.add(new Book(2, "Athisudi", "Avviyar"));
        books.add(new Book(3, "Wings of Fire", "Abdul Kalam"));
        books.add(new Book(4, "Harry Potter", "J. K. Rowling"));

        System.out.println("Search by title (Linear): ");
        String keyword = sc.nextLine();
        List<Book> linearResults = linearSearch(books, keyword);
        if (linearResults.isEmpty()) System.out.println("No match found.");
        else linearResults.forEach(Book::print);

        books.sort(Comparator.comparing(b -> b.title));
        System.out.println("\nBinary search (Exact title match): ");
        String exactTitle = sc.nextLine();
        Book result = binarySearch(books, exactTitle);
        if (result == null) System.out.println("Book not found.");
        else result.print();
    }
}