// Класс библиотеки
public class Library {
    private List<Book> books;
    private Set<String> authors;
    private Map<String, List<Book>> booksByGenre;

    public Library() {
        books = new ArrayList<>();
        authors = new HashSet<>();
        booksByGenre = new HashMap<>();
    }

    public void addBook(String title, String author, String genre) {
        Book book = new Book(title, author, genre);
        books.add(book);
        authors.add(author);

        booksByGenre.computeIfAbsent(genre, k -> new ArrayList<>()).add(book);
    }

    public void displayBooks() {
        System.out.println("Все книги:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void displayAuthors() {
        System.out.println("Все авторы:");
        for (String author : authors) {
            System.out.println(author);
        }
    }

    public void displayBooksByGenre() {
        System.out.println("Книги по жанрам:");
        for (Map.Entry<String, List<Book>> entry : booksByGenre.entrySet()) {
            System.out.println("Жанр: " + entry.getKey());
            for (Book book : entry.getValue()) {
                System.out.println("  " + book);
            }
        }
    }
}
