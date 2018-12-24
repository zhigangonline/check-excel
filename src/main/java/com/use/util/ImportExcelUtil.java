package com.use.util;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.use.vo.ImportExcelVo;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 将 excel 文件导入
public class ImportExcelUtil {

    // 将 excel 文件中的数据导入到List
    public static <T> List<T> importData(ImportExcelVo<T> vo) {
        XLSReader mainReader;

        try {
            InputStream inputXML=new BufferedInputStream(Thread.currentThread().getContextClassLoader().getResourceAsStream(vo.getTemplateFilePath()));
            mainReader=ReaderBuilder.buildFromXML(inputXML);
            InputStream inputXLS=new BufferedInputStream(new FileInputStream(vo.getFilePath()));
            List<T> dataList=Lists.newArrayList();

            Map<String, Object> beans=Maps.newHashMap();
            beans.put(vo.getImportListName(),dataList);
            XLSReadStatus readStatus=mainReader.read(inputXLS,beans);
            System.out.println(readStatus.isStatusOK());
            return dataList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return Lists.newArrayList();
    }
}
