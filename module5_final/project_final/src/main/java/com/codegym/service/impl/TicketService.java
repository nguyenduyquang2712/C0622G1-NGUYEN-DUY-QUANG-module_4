package com.codegym.service.impl;

import com.codegym.dto.TicketDto;
import com.codegym.model.Ticket;
import com.codegym.repository.TicketRepository;
import com.codegym.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> searchTicket(String startPoint, String endPoint, String startDate, String endDate) {
        return ticketRepository.search(startPoint, endPoint, startDate, endDate);
    }

    @Override
    public void create(TicketDto ticket) {
        ticketRepository.create(
                ticket.getEndPoint(),
                ticket.getPrice(),
                ticket.getStartDate(),
                ticket.getStartPoint(),
                ticket.getStartTime(),
                ticket.getGarageId(),
                ticket.getAmount());
    }

    @Override
    public void edit(TicketDto ticket) {
        ticketRepository.edit(
                ticket.getId(),
                ticket.getEndPoint(),
                ticket.getPrice(),
                ticket.getStartDate(),
                ticket.getStartPoint(),
                ticket.getStartTime(),
                ticket.getGarageId(),
                ticket.getAmount());
    }

    @Override
    public Optional<Ticket> findById(int id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void order(Ticket ticket) {
        ticketRepository.save(ticket);
    }

}
