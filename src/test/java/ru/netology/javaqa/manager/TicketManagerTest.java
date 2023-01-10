package ru.netology.javaqa.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.data.Ticket;
import ru.netology.javaqa.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(001, 10_000, "DME", "LED", 90);
    Ticket ticket2 = new Ticket(002, 20_000, "SVO", "BCN", 180);
    Ticket ticket3 = new Ticket(003, 8_000, "DME", "LED", 85);
    Ticket ticket4 = new Ticket(004, 9_500, "SVO", "LED", 80);
    Ticket ticket5 = new Ticket(005, 25_000, "SVO", "BCN", 160);
    Ticket ticket6 = new Ticket(006, 15_000, "SVO", "LED", 80);
    Ticket ticket7 = new Ticket(007, 23_000, "DME", "BCN", 170);
    Ticket ticket8 = new Ticket(118, 14_500, "SVO", "LED", 85);
    Ticket ticket9 = new Ticket(119, 12_000, "VKO", "LED", 95);
    Ticket ticket10 = new Ticket(120, 33_000, "VKO", "BCN", 240);

    @BeforeEach
    public void setup() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
        manager.addTicket(ticket8);
        manager.addTicket(ticket9);
        manager.addTicket(ticket10);
    }

    @Test
    public void shouldFindTickets() {

        Ticket[] expected = {ticket4, ticket8, ticket6};
        Ticket[] actual = manager.searchByRequest("SVO", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTickets() {

        Ticket[] expected = {ticket10};
        Ticket[] actual = manager.searchByRequest("VKO", "BCN");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindZeroTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchByRequest("VKO", "SVO");

        assertArrayEquals(expected, actual);
    }

}