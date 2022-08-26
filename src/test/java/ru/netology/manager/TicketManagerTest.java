package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;
import ru.netology.ticket.Ticket;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 4700, "MOV", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 3500, "LED", "MOV", 100);
    Ticket ticket3 = new Ticket(3, 2000, "LED", "MOV", 95);
    Ticket ticket4 = new Ticket(4, 6500, "MOV", "CEK", 150);
    Ticket ticket5 = new Ticket(5, 4700, "MOV", "IJK", 100);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldAddAllTickets() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = manager.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy() {

        Ticket[] expected = new Ticket[]{ticket3, ticket2};
        Ticket[] actual = manager.searchBy("LED", "MOV");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTicketMostExpensive() {

        int expected = ticket5.compareTo(ticket3);
        int actual = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTicketMostCheaper() {

        int expected = ticket5.compareTo(ticket4);
        int actual = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTicketsWithSamePrice() {

        int expected = ticket1.compareTo(ticket5);
        int actual = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfNoTicket() {

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("MOV", "KUF");

        Assertions.assertArrayEquals(expected, actual);
    }
}
