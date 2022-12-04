package com.codegym.repository;

import com.codegym.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select * from `ticket` where status = 1;", nativeQuery = true)
    List<Ticket> findAll();

    @Modifying
    @Query(value = " insert into `ticket`( end_point, price, start_date, start_point, start_time, garage_id, amount) " +
            " value (:endPoint, :price, :startDate, :startPoint, :startTime, :garageId, :amount) ", nativeQuery = true)
    void create(@Param("endPoint") String endPoint,
                @Param("price") Double price,
                @Param("startDate") String startDate,
                @Param("startPoint") String startPoint,
                @Param("startTime") String startTime,
                @Param("garageId") int garageId,
                @Param("amount") int amount);

    @Modifying
    @Query(value = " update `ticket` set `end_point` = :endPoint , " +
            " `price` = :price , `start_date` = :startDate , " +
            " `start_point` = :startPoint , `start_time` = :startTime , " +
            " `garage_id` = :garageId , `amount` = :amount where (`id` = :id) ", nativeQuery = true)
    void edit(@Param("id") int id,
              @Param("endPoint") String endPoint,
              @Param("price") Double price,
              @Param("startDate") String startDate,
              @Param("startPoint") String startPoint,
              @Param("startTime") String startTime,
              @Param("garageId") int garageId,
              @Param("amount") int amount);
    @Modifying
    @Query(value = "update `ticket` set `status`=0 where `id`= :id",nativeQuery=true)
    void deleteById(@Param("id") int id);
    @Query(value = "SELECT * FROM `ticket` where start_point like %:startPoint% and end_point like %:endPoint% and date(start_date) BETWEEN date(:firstDate) and date(:secondDate) and status = 1" ,nativeQuery = true)
    List<Ticket> search(
            @Param("startPoint")String startPoint,
            @Param("endPoint")String endPoint,
            @Param("firstDate")String firstDate,
            @Param("secondDate")String secondDate);
}
