package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.model.OrderBook;
import com.codegym.repository.OrderBookRepository;
import com.codegym.service.IOrderBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    @Override
    public OrderBook generateOrderBook(Book book) {
        OrderBook orderBook = new OrderBook();
        orderBook.setBook(book);
        orderBook.setCode((long) (Math.random() * (99999 - 10000) + 10000));
        return orderBook;
    }

    @Override
    public void deteleBookCode(long code) {
        orderBookRepository.deteleBookCode(code);
    }


}
