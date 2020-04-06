package javaStart.task7_Encapsulation.exercise2.system;

import javaStart.task7_Encapsulation.exercise2.model.Client;
import javaStart.task7_Encapsulation.exercise2.model.MovieShow;
import javaStart.task7_Encapsulation.exercise2.model.Ticket;

public class TicketSystem {
    public Ticket createTicket(MovieShow movieShow, Client client) {
        if(movieShow.getFreeSeats() == 0) {
            System.out.println("There are none free seats");
            return null;
        } else if (client.getAge() < movieShow.getAgeRequired()) {
            System.out.println("A movie is accessible from " +
                    movieShow.getAgeRequired() + " years");
            return null;
        } else {
            int ticketId = movieShow.getMaxSeats() - movieShow.getFreeSeats() + 1;
            movieShow.setFreeSeats(movieShow.getFreeSeats() - 1);
            return new Ticket(ticketId, movieShow, client);
        }
    }


    public MovieShow checkFreeSeats(MovieShow movieShow) {
        if (movieShow.getMaxSeats() < movieShow.getFreeSeats()) {
            System.out.println("There are no anymore seats for this movie");
        } else {
            System.out.println("You have booked seats for this movie");
        }
        return movieShow;
    }

    public Client checkAge(MovieShow movieShow, Client client) {
        if (client.getAge() < movieShow.getAgeRequired()) {
            System.out.println("Client's age is not suitable");
        } else {
            System.out.println("You can watch this movie");
        }
        return client;
    }

    public void summaryOfOrder(MovieShow movieShow, Client client) {
        if (movieShow.getMaxSeats() >= movieShow.getFreeSeats() &&
                client.getAge() >= movieShow.getAgeRequired()) {
            System.out.println(
                    "Client's name: " + client.getFirstName() + " "+
                            client.getLastName() + "\n"
                            + "Age: " + client.getAge() + "\n" +
                    "Title: " + movieShow.getMovieTitle() + "\n"
                    + "Type: " + movieShow.getMovieType() + "\n"
            + "Age required: " +  movieShow.getAgeRequired() + "\n"
            + "Max seats: " + movieShow.getMaxSeats() + "\n"
            + "Free seats: " + movieShow.getFreeSeats() + "\n"
            + "Duration: " + movieShow.getDuration());
        }
    }

}
