package javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model;

public class Movie {
    private String title;
    private String genre;
    private int length;
    private int ageRequired;
    private int maxSeats;
    private int freeSeats;
    private int ticketId;

    public Movie(String title, String genre, int length, int ageRequired,
                 int maxSeats, int freeSeats) {
        this.title = title;
        this.genre = genre;
        this.length = length;
        this.ageRequired = ageRequired;
        this.maxSeats = maxSeats;
        this.freeSeats = freeSeats;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getLength() {
        return length;
    }

    public int getAgeRequired() {
        return ageRequired;
    }

    public int getMaxSeats() {
        return maxSeats;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setAgeRequired(int ageRequired) {
        this.ageRequired = ageRequired;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getMovieInfo() {
        return "Movie: " + title + " -- Genre: " + genre + " -- Length: "
                + length + " min" + " -- Age required: " + ageRequired
                + " -- Max seats: " + maxSeats + " -- Seats available: " + freeSeats;
    }

    public int nextTicketId() {
        setTicketId(ticketId + 1);
        return ticketId;
    }

    public boolean noSeats() {
        return freeSeats == 0;
    }
}
