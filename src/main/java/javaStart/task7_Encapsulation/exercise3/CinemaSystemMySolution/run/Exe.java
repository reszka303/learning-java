package javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.run;

import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.logic.TicketSale;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Client;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Movie;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Ticket;

public class Exe {
    public static void main(String[] args) {
        TicketSale ticketSale = new TicketSale();
        Movie movie1 = new Movie(
                "The Wolf of Wall Street",
                "Comedy",
                179,18,72,72);
        Client client1 = new Client(
                "Fred",
                "Connolly" ,20);
        Ticket ticket1 = ticketSale.createTicket(movie1, client1);
        ticketSale.getTicketInfo(ticket1);
    }
}
