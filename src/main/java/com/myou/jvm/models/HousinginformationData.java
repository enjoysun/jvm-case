package com.myou.jvm.models;

import com.alibaba.excel.annotation.ExcelProperty;
import com.myou.jvm.converts.StringLocalDateConvert;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Author myou
 * @Date 2020/11/17  5:00 下午
 */
@Data
public class HousinginformationData {
    private int seq;
    private String ownerCardNumber;
    private String ownerName;
    @ExcelProperty(converter = StringLocalDateConvert.class)
    private LocalDate deliveryDate;
    private String houseNumber;
    private String projectName;
    private String country;
    private String location;
    private int buildingNumber;
    private int unitNumber;
    private int tier;
    private int roomNumber;
}
