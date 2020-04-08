package javaStart.task7_Encapsulation.exercise2.system;

import javaStart.task7_Encapsulation.exercise2.model.Client;
import javaStart.task7_Encapsulation.exercise2.model.MovieShow;
import javaStart.task7_Encapsulation.exercise2.model.Ticket;

import java.util.Optional;

public class TicketSystem {
    public Ticket createTicket(MovieShow movieShow, Client client) {
        if(!movieShow.hasFreeSeats()) {
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

    private int generateNextTicketId(MovieShow movieShow) {
        return movieShow.getMaxSeats() - movieShow.getFreeSeats() + 1;
    }

    private boolean clientHasRequiredAgeForMovie(Client client, MovieShow movieShow) {
        return client.getAge() >= movieShow.getAgeRequired();
    }
}
