package javaStart.task7_Encapsulation.exercise2.model;

public class MovieShow {
    private String movieTitle;
    private String movieType;
    private int duration;
    private int ageRequired;
    private int maxSeats;
    private int freeSeats;

    public MovieShow(String movieTitle, String movieType, int duration,
                     int ageRequired, int maxSeats, int freeSeats) {
        this.movieTitle = movieTitle;
        this.movieType = movieType;
        this.duration = duration;
        this.ageRequired = ageRequired;
        this.maxSeats = maxSeats;
        this.freeSeats = freeSeats;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieType() {
        return movieType;
    }

    public int getDuration() {
        return duration;
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

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public String getMovieInfo() {
        return movieTitle + "-" + movieType+ "-" + duration + " min";
    }

    public boolean hasFreeSeats() {
        return freeSeats != 0;
    }

    public void decreaseFreeSeatsNumber() {
        freeSeats--;
    }
}
