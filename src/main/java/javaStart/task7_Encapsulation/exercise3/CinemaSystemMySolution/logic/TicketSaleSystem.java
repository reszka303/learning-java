package javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.logic;

import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Client;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Movie;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Ticket;

import java.util.Optional;

public class TicketSaleSystem {
    public Optional<Ticket> createTicket(Movie movie, Client client) {
        if (movie.getFreeSeats() == 0) {
            System.out.println("Details of the order:");
            System.out.println("There are no seats");
            System.out.println();
            return Optional.empty();
        } else if (client.getAge() < movie.getAgeRequired()) {
            System.out.println("Details of the order:");
            System.out.println("The movie is accessible from "
                    + movie.getAgeRequired() + " years");
            System.out.println();
            return Optional.empty();
        } else {
            movie.setFreeSeats(movie.getFreeSeats() - 1);
            int setToOne = movie.getTicketId() + 1;
            int ticketId = setToOne;
            movie.setTicketId(setToOne++);
            return Optional.of(new Ticket(ticketId, movie, client));
        }
    }

    public void getTicketInfo(Optional<Ticket> ticket) {
        if (ticket.isPresent()) {
            System.out.println(ticket.get().getInfo());
            System.out.println();
        }
    }
}
