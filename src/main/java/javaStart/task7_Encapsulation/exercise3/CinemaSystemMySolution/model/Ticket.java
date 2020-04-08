package javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model;

public class Ticket {
    private int id;
    private Movie movie;
    private Client client;

    public Ticket(int id, Movie movie, Client client) {
        this.id = id;
        this.movie = movie;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getInfo() {
        return "Ticket Id: " + id + " Movie: " + movie.getMovieInfo() + " Client: " + client.getClientInfo();
    }
}
