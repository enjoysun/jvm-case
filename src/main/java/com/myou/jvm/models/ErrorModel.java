package com.myou.jvm.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Author myou
 * @Date 2020/11/17  4:44 下午
 */
@Data
@Builder
public class ErrorModel {
    private String sheetName;
    private String errorMsg;
    private int errorRow;
    private String errorHeader;
}
