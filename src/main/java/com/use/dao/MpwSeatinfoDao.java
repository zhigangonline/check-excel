package com.use.dao;

import com.use.po.MpwSeatinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface MpwSeatinfoDao extends JpaRepository<MpwSeatinfo,Integer> {

    @Modifying
    @Query(value = "UPDATE mpw_seatinfo m SET m.qr_code_content = REPLACE(TRIM(m.qr_code_content),'/','|') WHERE m.batch_id = ?1 AND m.qr_code_content LIKE '%/%'",nativeQuery = true)
    int updateForBatchIdAndSlash(String batchId);
}
