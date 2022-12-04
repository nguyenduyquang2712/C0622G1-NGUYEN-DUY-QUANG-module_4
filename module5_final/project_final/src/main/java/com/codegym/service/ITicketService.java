package com.codegym.service;

import com.codegym.dto.TicketDto;
import com.codegym.model.Ticket;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ITicketService {
    List<Ticket> findAll();
//    Page<Ticket> searchTicket(String startPoint, String endPoint, String startDate, String endDate);
    List<Ticket> searchTicket(String startPoint, String endPoint, String startDate, String endDate);
    void create(TicketDto ticket);
    void edit(TicketDto ticket);

    Optional<Ticket> findById(int id);

    void remove(int id);

    void order(Ticket ticket);
}
