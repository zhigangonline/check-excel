package com.use;

import com.google.common.collect.Lists;
import com.use.constant.NpwConstant;
import com.use.dao.MpwCinemaDao;
import com.use.dao.MpwFilmDao;
import com.use.po.MpwCinema;
import com.use.po.MpwFilm;
import com.use.util.ImportExcelUtil;
import com.use.util.PropertyNameParser;
import com.use.vo.CheckTicketVo;
import com.use.vo.ImportExcelVo;
import com.use.vo.StatisticsVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportFileTest {


    /*
    @Test
    public void exportBuyerData() {
        ImportExcelVo importExcelVo = new ImportExcelVo("jxl/buy.xml", "D:\\问题收集\\数据excel\\黄金兄弟buy.xlsx", "buyVoList", BuyVo.class);
        List<BuyVo> voList = ImportExcelUtil.importData(importExcelVo);

        voList.stream().forEach(vo -> {
            System.out.println(vo);
        });
    }
    */

    @Autowired
    private MpwCinemaDao mpwCinemaDao;

    @Autowired
    private MpwFilmDao mpwFilmDao;

    @Test
    public void exportStatisticsData() {

        ImportExcelVo importExcelVo = new ImportExcelVo("jxl/statistics.xml", "D:\\问题收集\\数据excel\\黄金兄弟票码统计.xlsx", "statisticsVoList", StatisticsVo.class);
        List<StatisticsVo> voList = ImportExcelUtil.importData(importExcelVo);

        List<MpwCinema> allCinemaList = Lists.newArrayList();
        voList.forEach(vo -> {
            allCinemaList.addAll(mpwCinemaDao.findByCinemaNameLikeAndWebSource(vo.getCinemaName(), NpwConstant.WEB_SOURCE_MPW));
            System.out.println(vo);
        });

        System.out.println("1.------------------------------ cinema  符合条件数据  ------------------------------");
        allCinemaList.forEach(mpwCinema -> {
            System.out.println(mpwCinema);
        });
        System.out.println("2.------------------------------ film 符合条件数据  ------------------------------");
        List<MpwFilm> allFilmList = Lists.newArrayList();
        voList.forEach(vo -> {
            allFilmList.addAll(mpwFilmDao.findByFilmNameLikeAndWebSource(vo.getFilmName(), NpwConstant.WEB_SOURCE_MPW));
        });

        allFilmList.forEach(mpwFilm -> {
            System.out.println(mpwFilm);
        });

        System.out.println("3.------------------------------  查看票索票数据  ------------------------------");
        List<Object[]> objectsList = mpwFilmDao.queryByCheckTicket("27325", "3322");
        objectsList.stream().map(objects ->  PropertyNameParser.getBean(new CheckTicketVo(),objects)).forEach(checkTicketVo -> {
            System.out.println(checkTicketVo.toString());
        });


    }
}
