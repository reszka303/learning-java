package javaStart.task8_Encapsulation.exercise2.model;

public class Ticket {
    private int id;
    private MovieShow movieShow;
    private Client client;

    public Ticket(int id, MovieShow movieShow, Client client) {
        this.id = id;
        this.movieShow = movieShow;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public MovieShow getMovieShow() {
        return movieShow;
    }

    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovieShow(MovieShow movieShow) {
        this.movieShow = movieShow;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getInfo() {
        return id + " "+ movieShow.getMovieInfo() + client.getFullName();
    }


}
