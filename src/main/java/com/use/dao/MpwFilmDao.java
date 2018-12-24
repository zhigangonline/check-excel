package com.use.dao;

import com.use.po.MpwFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MpwFilmDao extends JpaRepository<MpwFilm,Integer> {

    List<MpwFilm> findByFilmNameLikeAndWebSource(String filmName, String webSource);

    @Query( value = "SELECT" +
                    " t.city_name," +
                    " fi.film_name," +
                    " m.cinema_name," +
                    " m.cinema_address," +
                    " a.date," +
                    " DATE_FORMAT(a.starttime, '%H:%i') as starttime," +
                    //" cast(a.starttime as varchar) starttime," +
                    " a.price," +
                    " f.seat," +
                    " f.field_id," +
                    " f.qr_code_content," +
                    " a.screening_hall," +
                    " a.language_version," +
                    " a.batch_id" +
                " FROM mpw_seatinfo f" +
                " LEFT JOIN mpw_cinema_business_buy a ON f.batch_id = a.batch_id AND f.field_id = a.field_id" +
            " LEFT JOIN mpw_citycourtyardline_relation r ON a.cinema_id = r.cinema_id  AND r.source_id = 2" +
            " LEFT JOIN mpw_city t ON r.city_id = t.city_id AND t.source = 2" +
            " LEFT JOIN mpw_cinema m ON m.cinema_id_source = a.cinema_id AND m.web_source = '2'" +
            " LEFT JOIN mpw_film fi ON fi.film_id_self = a.film_id AND fi.web_source = '2'" +
            " WHERE 1 = 1 AND a.film_id = ?1  and a.cinema_id = ?2",nativeQuery = true)
    public List<Object[]> queryByCheckTicket(String filmId, String cinema);
}
