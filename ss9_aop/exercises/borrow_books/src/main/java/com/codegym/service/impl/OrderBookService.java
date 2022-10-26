package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.model.OrderBook;
import com.codegym.repository.OrderBookRepository;
import com.codegym.service.IOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBookService implements IOrderBookService {
    @Autowired
    private OrderBookRepository orderBookRepository;
    @Override
    public void save(OrderBook orderBook) {
        orderBookRepository.save(orderBook);
    }

    @Override
    public OrderBook findOrderBookByCode(long code, int book_id) {
        return orderBookRepository.findOrderBookByCode(code, book_id);
    }


}
