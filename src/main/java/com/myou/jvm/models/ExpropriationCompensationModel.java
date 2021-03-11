package com.myou.jvm.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author myou
 * @Date 2020/11/18  10:30 上午
 */
@Data
public class ExpropriationCompensationModel {
    private List<ProtocolData> protocolDataList;
    private List<FamilyData> familyDataList;
    private List<HousinginformationData> housinginformationDataList;
    private List<ErrorModel> errorModels = new ArrayList<>();
}
