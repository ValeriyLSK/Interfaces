package repository;

import data.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 5000, "LED", "KVK", 120);
    Ticket ticket2 = new Ticket(2, 2500, "LED", "KVK", 120);
    Ticket ticket3 = new Ticket(3, 2500, "KVK", "LED", 120);
    Ticket ticket4 = new Ticket(4, 15000, "LED", "DXB", 120);
    Ticket ticket5 = new Ticket(5, 10000, "DXB", "LED", 120);
    Ticket ticket6 = new Ticket(6, 8000, "LED", "AYT", 120);
    Ticket ticket7 = new Ticket(7, 11000, "AYT", "DEL", 120);
    Ticket ticket8 = new Ticket(8, 30000, "ATH", "LED", 120);
    Ticket ticket9 = new Ticket(9, 29000, "LED", "ATH", 120);
    Ticket ticket10 = new Ticket(10, 45000, "FCO", "DME", 120);
    Ticket ticket11 = new Ticket(11, 38000, "DME", "BER", 120);

    @Test
    void shouldSortByPrice() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.save(ticket7);
        repository.save(ticket8);
        repository.save(ticket9);
        repository.save(ticket10);
        repository.save(ticket11);
        Ticket[] expected = new Ticket[]{ticket2, ticket3, ticket1, ticket6, ticket5, ticket7, ticket4, ticket9, ticket8, ticket11, ticket10};
        Ticket[] actual = repository.findAll();
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.save(ticket1);
        repository.save(ticket2);
        repository.save(ticket3);
        repository.save(ticket4);
        repository.save(ticket5);
        repository.save(ticket6);
        repository.save(ticket7);
        repository.save(ticket8);
        repository.save(ticket9);
        repository.save(ticket10);
        repository.save(ticket11);
        repository.removeById(1);
        Ticket[] expected = new Ticket[]{ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10, ticket11};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}