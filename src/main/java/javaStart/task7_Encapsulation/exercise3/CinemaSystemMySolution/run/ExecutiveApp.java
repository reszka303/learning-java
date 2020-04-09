package javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.run;

import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.logic.TicketSaleSystem;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Client;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Movie;
import javaStart.task7_Encapsulation.exercise3.CinemaSystemMySolution.model.Ticket;

public class ExecutiveApp {
    public static void main(String[] args) {
        TicketSaleSystem ticketSaleSystem = new TicketSaleSystem();
        Movie movie1 = new Movie(
                "The Wolf of Wall Street",
                "Comedy",
                179,18,3,3);
        Client client1 = new Client(
                "Fred",
                "Connolly" ,20);
        Client client2 = new Client(
                "Eddie",
                "Travis", 35);
        Client client3 = new Client("Bill",
                "Andrade",17);
        Client client4 = new Client(
                "Zak",
                "Duarte", 63);
        Client client5 = new Client("Ines",
                "Coleman" , 45);

        Ticket ticket1 = ticketSaleSystem.createTicket(movie1, client1);
        ticketSaleSystem.getTicketInfo(ticket1);

        Ticket ticket2 = ticketSaleSystem.createTicket(movie1, client2);
        ticketSaleSystem.getTicketInfo(ticket2);

        Ticket ticket3 = ticketSaleSystem.createTicket(movie1, client3);
        ticketSaleSystem.getTicketInfo(ticket3);

        Ticket ticket4 = ticketSaleSystem.createTicket(movie1, client4);
        ticketSaleSystem.getTicketInfo(ticket4);

        Ticket ticket5 = ticketSaleSystem.createTicket(movie1, client5);
        ticketSaleSystem.getTicketInfo(ticket5);
    }
}
