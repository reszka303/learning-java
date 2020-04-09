package javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.logic;

import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Client;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Movie;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Ticket;

public class TicketSaleSystem {
    public Ticket createTicket(Movie movie, Client client) {
        if (movie.getFreeSeats() == 0) {
            System.out.println("Details of the order:");
            System.out.println("There are no seats");
            System.out.println();
            return null;
        } else if (client.getAge() < movie.getAgeRequired()) {
            System.out.println("Details of the order:");
            System.out.println("The movie is accessible from "
                    + movie.getAgeRequired() + " years");
            System.out.println();
            return null;
        } else {
            movie.setFreeSeats(movie.getFreeSeats() - 1);
            int ticketId = movie.getTicketId();
            movie.setTicketId(movie.getTicketId() + 1);
            return new Ticket(ticketId, movie, client);
        }
    }

    public void getTicketInfo(Ticket ticket) {
        if (ticket != null) {
            System.out.println("Details of the order:");
            System.out.println(ticket.getInfo());
            System.out.println();
        }
    }
}
