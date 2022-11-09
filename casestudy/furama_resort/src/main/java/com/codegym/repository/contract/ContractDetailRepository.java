package com.codegym.repository.contract;

import com.codegym.dto.IContractDetailDto;
import com.codegym.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value = "select attach_facility.name as nameDto, " +
            "attach_facility.unit as unitDto, sum(ifnull(contract_detail.quantity, 0)) as quantityDto, " +
            "attach_facility.service_status as statusDto, attach_facility.cost as costDto " +
            "from contract_detail join attach_facility " +
            "on contract_detail.attach_facility_id = attach_facility.id " +
            "where contract_detail.contract_id = :idFind group by attach_facility.id", nativeQuery = true)
    List<IContractDetailDto> showAll(@Param("idFind") Integer id);
}
