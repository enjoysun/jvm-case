package com.myou.jvm.converts;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author myou
 * @Date 2020/11/17  5:46 下午
 */
public class StringLocalDateConvert implements Converter<LocalDate> {
    @Override
    public Class supportJavaTypeKey() {
        return LocalDate.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    // 读调用转换
    @Override
    public LocalDate convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (StringUtils.isEmpty(cellData.getStringValue()))
            return null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/M/dd");
        return LocalDate.parse(cellData.getStringValue(), fmt);
    }

    // 写调用转换
    @Override
    public CellData convertToExcelData(LocalDate s, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }
}
