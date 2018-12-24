package com.use.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ImportExcelVo<T> {
    private String templateFilePath;
    private String filePath;
    private String importListName;
    private Class<T> clazz;
}
