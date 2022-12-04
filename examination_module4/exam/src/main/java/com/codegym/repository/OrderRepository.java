package com.codegym.repository;

import com.codegym.dto.IOderDto;
import com.codegym.model.OderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OderProduct,Integer> {
    @Query(value = "select od.id as id, pd.`name` as productName, pd.price as productPrice,\n" +
            "pdt.`name` as productType, od.day_order as dayOrder, od.amount_order as amountProduct,\n" +
            "ifnull((od.amount_order*pd.price),0) as total from `oder_product` od left join `product` pd \n" +
            "on od.product_id = pd.id\n" +
            "left join `product_type` pdt\n" +
            "on pd.product_type_id = pdt.id", nativeQuery = true)
    Page<IOderDto> showListOrder(Pageable pageable);
}
