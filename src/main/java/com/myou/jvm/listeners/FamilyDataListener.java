package com.myou.jvm.listeners;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.myou.jvm.listeners.processor.AnalysisCompensationListener;
import com.myou.jvm.listeners.processor.AnalysisCompensationProcessor;
import com.myou.jvm.models.ErrorModel;
import com.myou.jvm.models.ExpropriationCompensationModel;
import com.myou.jvm.models.FamilyData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author myou
 * @Date 2020/11/17  3:33 下午
 */
public class FamilyDataListener extends AnalysisCompensationListener<FamilyData> {

    private static final Logger logger = LoggerFactory.getLogger(FamilyDataListener.class);

    private ExpropriationCompensationModel expropriationCompensation;

    public FamilyDataListener(ExpropriationCompensationModel expropriationCompensation) {
        this.expropriationCompensation = expropriationCompensation;
    }

    @Override
    public void assembleCompensation(List<FamilyData> t) {
        this.expropriationCompensation.setFamilyDataList(t);
    }

    @Override
    public void assembleErrors(List<ErrorModel> errorList) {
        this.expropriationCompensation.getErrorModels().addAll(errorList);
    }
}
