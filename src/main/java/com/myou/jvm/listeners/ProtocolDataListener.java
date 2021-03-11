package com.myou.jvm.listeners;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.context.AnalysisContextImpl;
import com.alibaba.excel.event.AnalysisEventListener;
import com.myou.jvm.listeners.processor.AnalysisCompensationListener;
import com.myou.jvm.listeners.processor.AnalysisCompensationProcessor;
import com.myou.jvm.models.ErrorModel;
import com.myou.jvm.models.ExpropriationCompensationModel;
import com.myou.jvm.models.ProtocolData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author myou
 * @Date 2020/11/17  5:13 下午
 */
public class ProtocolDataListener extends AnalysisCompensationListener<ProtocolData> {
    private static final Logger logger = LoggerFactory.getLogger(ProtocolDataListener.class);

    private ExpropriationCompensationModel expropriationCompensation;

    public ProtocolDataListener(ExpropriationCompensationModel expropriationCompensation) {
        this.expropriationCompensation = expropriationCompensation;
    }

    @Override
    public void assembleCompensation(List<ProtocolData> t) {
        expropriationCompensation.setProtocolDataList(t);
    }

    @Override
    public void assembleErrors(List<ErrorModel> errorList) {
        expropriationCompensation.getErrorModels().addAll(errorList);
    }
}
