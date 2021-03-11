package com.myou.jvm.models;

import com.alibaba.excel.annotation.ExcelProperty;
import com.myou.jvm.converts.StringLocalDateConvert;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Author myou
 * @Date 2020/11/17  4:51 下午
 */
@Data
public class ProtocolData {
    private int seq;
    private String ownerCardNumber;
    @ExcelProperty(converter = StringLocalDateConvert.class)
    private LocalDate signDate;
    private double area;
    private String resettlementType;
    private int resettlementNums;
}
