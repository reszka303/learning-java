package kodilla.modul2.books;

public class Book {
    private int id;
    private String title;
    private int publicationYear;

    public Book(int id, String title, int publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "id: "+ id + ", title: " + title + ", year:  " + publicationYear;
    }
}
