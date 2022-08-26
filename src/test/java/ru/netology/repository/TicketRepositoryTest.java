package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ticket.Ticket;

public class TicketRepositoryTest {
    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 1300, "MOV", "KZN", 95);
    Ticket ticket2 = new Ticket(2, 2000, "LED", "MOV", 95);
    Ticket ticket3 = new Ticket(3, 3500, "LED", "RTW", 135);
    Ticket ticket4 = new Ticket(4, 6500, "MOV", "CEK", 150);
    Ticket ticket5 = new Ticket(5, 4700, "MOV", "IJK", 100);

    @Test
    public void shouldShowAllTickets() {

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveOneTicketById() {

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        repo.removeTicketById(4);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket5};
        Ticket[] actual = repo.getTickets();
    }

    @Test
    public void shouldRemoveTwoTicketsById() {

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        repo.removeTicketById(1);
        repo.removeTicketById(3);

        Ticket[] expected = {ticket2, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();
    }

    @Test
    public void shouldRemoveByIdWhenNoTickets() {

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Ticket[] expected = {};
        Ticket[] actual = repo.getTickets();
    }

    @Test
    public void shouldFindTicketById() {

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        repo.findById(3);

        Ticket[] expected = {ticket3};
        Ticket[] actual = repo.getTickets();
    }
}
