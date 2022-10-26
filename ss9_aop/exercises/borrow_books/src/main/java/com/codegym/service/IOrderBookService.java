package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.OrderBook;

import java.util.List;

public interface IOrderBookService {
    void save(OrderBook orderBook);

    OrderBook findOrderBookByCode(long code, int book_id);

    OrderBook generateOrderBook(Book book);

    void deteleBookCode(long code);
}
