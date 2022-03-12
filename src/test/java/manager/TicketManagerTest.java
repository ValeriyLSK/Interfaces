package manager;

import data.Ticket;
import org.junit.jupiter.api.Test;
import repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
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
    void shouldFindByAirportAndSort() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.findByAirport("LED", "KVK");
        Ticket[] expected = new Ticket[]{ticket2, ticket1};
        Ticket[] actual = manager.findByAirport("LED", "KVK");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByAirport() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        Ticket[] expected = new Ticket[]{ticket4};
        Ticket[] actual = manager.findByAirport("LED", "DXB");
        assertArrayEquals(expected, actual);
    }

}