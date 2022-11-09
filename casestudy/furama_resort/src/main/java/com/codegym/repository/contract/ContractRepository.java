package com.codegym.repository.contract;

import com.codegym.dto.IContractDto;
import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "SELECT  f.`name` AS facilityName,\n" +
            "             c.`name` AS customerName,\n" +
            "       ct.id AS id,\n" +
            "                 ct.start_date AS startDate,\n" +
            "                   ct.end_date AS endDate,\n" +
            "                    ct.deposit,\n" +
            "                   (IFNULL(SUM(cd.quantity * af.cost), 0) + IFNULL(f.cost,0)) AS total\n" +
            "                FROM\n" +
            "                contract ct\n" +
            "                       LEFT JOIN\n" +
            "                    facility f ON ct.facility_id = f.id\n" +
            "                      LEFT JOIN\n" +
            "                  contract_detail cd ON ct.id = cd.contract_id\n" +
            "                       LEFT JOIN\n" +
            "                   attach_facility af ON cd.attach_facility_id = af.id\n" +
            "                        LEFT JOIN\n" +
            "                customer c ON ct.customer_id = c.id\n" +
            "                GROUP BY ct.id",
            nativeQuery = true,countQuery = "select count(*) from contract")
    Page<IContractDto> showListConTract(Pageable pageable);
}
