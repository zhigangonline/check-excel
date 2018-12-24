package com.use.dao;

import com.use.po.MpwCinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MpwCinemaDao extends JpaRepository<MpwCinema,Integer> {

    List<MpwCinema> findByCinemaNameLikeAndWebSource(String cinemaName, String webSource);
}
