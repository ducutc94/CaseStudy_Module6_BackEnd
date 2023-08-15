package com.example.casemd6.repository;

import com.example.casemd6.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface IVoucherRepository extends JpaRepository<Voucher,Long> {
    @Query(value = "select * from voucher inner join products_voucher pv on voucher.id = pv.voucher_id\n" +
            "inner join products p on pv.products_id = p.id and p.id = ? where status_voucher =0;",nativeQuery = true)
    List<Voucher> findAllByProduct(@PathVariable Long id);
}
