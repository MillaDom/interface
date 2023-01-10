package ru.netology.javaqa.manager;

import ru.netology.javaqa.data.Ticket;
import ru.netology.javaqa.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void addTicket(Ticket ticket) {
        repository.addTicket(ticket);
    }

//    public void removeById(int id) {
//        repository.removeById(id);
//    }

    public Ticket[] searchByRequest(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from)) {
            if (ticket.getTo().contains(to)) {
                return true;
            }
        }
        return false;
    }
}
