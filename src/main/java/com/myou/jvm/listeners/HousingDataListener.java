package com.myou.jvm.listeners;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.myou.jvm.listeners.processor.AnalysisCompensationListener;
import com.myou.jvm.listeners.processor.AnalysisCompensationProcessor;
import com.myou.jvm.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author myou
 * @Date 2020/11/17  5:16 下午
 */
public class HousingDataListener extends AnalysisCompensationListener<HousinginformationData> {
    private static final Logger logger = LoggerFactory.getLogger(HousingDataListener.class);

    private ExpropriationCompensationModel expropriationCompensation;

    public HousingDataListener(ExpropriationCompensationModel expropriationCompensation) {
        this.expropriationCompensation = expropriationCompensation;
    }

    @Override
    public void assembleCompensation(List<HousinginformationData> t) {
        this.expropriationCompensation.setHousinginformationDataList(t);
    }

    @Override
    public void assembleErrors(List<ErrorModel> errorList) {
        this.expropriationCompensation.getErrorModels().addAll(errorList);
    }
}
