package com.codegym.repository;

import com.codegym.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook,Integer> {
    @Query(value = "select * from order_book where code= :code and book_id= :book_id",nativeQuery=true)
    OrderBook findOrderBookByCode(@Param("code") long code, @Param("book_id") int book_id);
}
