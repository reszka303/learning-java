package javaStart.task8_Encapsulation.exercise3.CinemaSystemMySolution.run;

import javaStart.task8_Encapsulation.exercise3.CinemaSystemMySolution.logic.TicketSaleSystem;
import javaStart.task8_Encapsulation.exercise3.CinemaSystemMySolution.model.Client;
import javaStart.task8_Encapsulation.exercise3.CinemaSystemMySolution.model.Movie;
import javaStart.task8_Encapsulation.exercise3.CinemaSystemMySolution.model.Ticket;

import java.util.Optional;

public class ExecutiveTicketApp {
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
        Client client3 = new Client(
                "Bill",
                "Andrade",17);
        Client client4 = new Client(
                "Zak",
                "Duarte", 63);
        Client client5 = new Client(
                "Ines",
                "Coleman" , 45);

        Optional<Ticket> ticket1 = ticketSaleSystem.createTicket(movie1, client1);
        ticket1.ifPresent(ticket -> ticketSaleSystem.getTicketInfo(ticket));

        ticketSaleSystem.createTicket(movie1, client2)
                .ifPresent(ticket2 -> ticketSaleSystem.getTicketInfo(ticket2));

        Optional<Ticket> ticket3 = ticketSaleSystem.createTicket(movie1, client3);
        ticket3.ifPresent(ticket -> ticketSaleSystem.getTicketInfo(ticket));

        ticketSaleSystem.createTicket(movie1, client4)
                .ifPresent(ticket4 -> ticketSaleSystem.getTicketInfo(ticket4));

        Optional<Ticket> ticket5 = ticketSaleSystem.createTicket(movie1, client5);
        ticket5.ifPresent(ticket -> ticketSaleSystem.getTicketInfo(ticket));
    }
}
