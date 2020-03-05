package kodilla.modul2.books;

import java.util.ArrayList;
import java.util.List;

public class BooksDatabase {
    public static List<Book> getList() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"50 Shades of Grey", 2010));
        books.add(new Book(2,"Sherlock Holmes", 1921));
        books.add(new Book(3,"The Last of the Mohicans", 1986));
        books.add(new Book(4,"The Infinity", 1967));
        books.add(new Book(5,"Better Call Saul", 1950));
        books.add(new Book(6,"Journey to the Center of the Earth", 1786));
        books.add(new Book(7,"Binary Death", 2014));
        books.add(new Book(8,"Breaking Bad", 1985));
        books.add(new Book(9,"Twenty Thousand Leagues Under the Sea", 2018));
        books.add(new Book(10,"Coma", 1985));
        books.add(new Book(11,"Of Ants and Men", 2000));
        books.add(new Book(12,"To Understand a Woman", 1985));
        books.add(new Book(13,"Neverending Story", 2004));
        books.add(new Book(14,"The Jungle Book", 1985));
        return books;
    }

    public void display() {
        System.out.println("All list is: ");
        getList()
                .forEach(System.out::println);
    }

    public void select() {
        System.out.println("List after selection is: ");
        getList()
                .stream()
                .filter(book -> book.getPublicationYear() >= 2000)
                .forEach(System.out::println);
    }
}
