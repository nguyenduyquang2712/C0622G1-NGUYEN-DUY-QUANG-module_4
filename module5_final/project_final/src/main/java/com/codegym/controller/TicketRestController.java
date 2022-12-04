package com.codegym.controller;

import com.codegym.dto.TicketDto;
import com.codegym.model.Ticket;
import com.codegym.service.ITicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ticket")
@CrossOrigin("*")
public class TicketRestController {
    @Autowired
    private ITicketService ticketService;

    @GetMapping()
    public ResponseEntity<List<Ticket>> showAll() {
        List<Ticket> ticketList = ticketService.findAll();
        if (ticketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketList,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createTicket(@Validated @RequestBody TicketDto ticket, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_MODIFIED);
        }

        ticketService.create(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable int id) {
        return new ResponseEntity<>(ticketService.findById(id).get(), HttpStatus.OK);
    }
    @PutMapping("/edit")
    public ResponseEntity<Void> editTickById(@RequestBody TicketDto ticketDTO) {
        ticketService.edit(ticketDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        ticketService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Ticket>> searchTicket(@RequestParam String startPoint,
                                                     @RequestParam String endPoint,
                                                     @RequestParam String firstDay,
                                                     @RequestParam String secondDay){
        List<Ticket> tickets = ticketService.searchTicket(startPoint, endPoint, firstDay, secondDay);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
    @PutMapping("/booking/{id}")
    public ResponseEntity<Ticket> order(@PathVariable Integer id, @RequestBody Ticket ticket) {
        Optional<Ticket> ticketFind = ticketService.findById(id);
        if (ticketFind == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BeanUtils.copyProperties(ticket, ticketFind.get());
        ticketFind.get().setAmount(ticketFind.get().getAmount() - 1);
        this.ticketService.order(ticketFind.get());
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }
}
