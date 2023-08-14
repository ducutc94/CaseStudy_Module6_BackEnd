package com.example.casemd6.repository;

import com.example.casemd6.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface IVoucherRepository extends JpaRepository<Voucher,Long> {
    @Query(value = "select * from voucher inner join shops_voucher sv on voucher.id = sv.voucher_id inner join shops s on sv.shops_id = s.id\n" +
            "and s.id = ? where voucher.status_voucher = '0';",nativeQuery = true)
    List<Voucher> findAllByShop(@PathVariable Long id);
}
