package com.codegym.repository;

import com.codegym.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {
    @Query(value = "select * from order_book where code= :code and book_id= :book_id and status_code=0", nativeQuery = true)
    OrderBook findOrderBookByCode(@Param("code") long code, @Param("book_id") int book_id);

    @Modifying
    @Query(value = "update order_book set status_code=1 where code= :code", nativeQuery = true)
    void deteleBookCode(@Param("code") long code);
}
