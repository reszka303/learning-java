package javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.logic;

import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Client;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Movie;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Ticket;

public class TicketSale {
    public Ticket createTicket(Movie movie, Client client) {
        if (movie.getFreeSeats() == 0) {
            System.out.println("There are no seats");
            return null;
        } else if (client.getAge() < movie.getAgeRequired()) {
            System.out.println("The movie is accessible from "
                    + movie.getAgeRequired() + " years");
            return null;
        } else {
            movie.getMaxSeats();
            movie.setFreeSeats(movie.getFreeSeats() - 1);
            int ticketId = 0;
            ticketId++;
            return new Ticket(ticketId, movie, client);
        }
    }

    public void getTicketInfo(Ticket ticket) {
        if (ticket != null) {
            System.out.println(ticket.getInfo());
        }
    }


}
