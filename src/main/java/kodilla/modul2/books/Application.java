package kodilla.modul2.books;


public class Application {
    public static void main(String[] args) {
        BooksDatabase booksDatabase = new BooksDatabase();

        booksDatabase.display();
        System.out.println();

        booksDatabase.select();
    }
}
