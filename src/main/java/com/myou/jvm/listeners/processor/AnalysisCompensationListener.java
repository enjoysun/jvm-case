package com.myou.jvm.listeners.processor;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.myou.jvm.models.ErrorModel;
import com.myou.jvm.models.ProtocolData;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author myou
 * @Date 2020/11/18  2:52 下午
 */
public abstract class AnalysisCompensationListener<T> extends AnalysisEventListener<T> {

    private List<T> protocol = new ArrayList<>();
    private List<ErrorModel> errors = new ArrayList<>();

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        String sheetName = context.readSheetHolder().getSheetName();
        Integer rowIndex = context.readRowHolder().getRowIndex() + 1;
        String errMsg = exception.getMessage();
        errors.add(ErrorModel.builder().sheetName(sheetName).errorMsg(errMsg).errorRow(rowIndex).build());
    }

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        this.protocol.add(t);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        this.assembleCompensation(protocol);
        this.assembleErrors(errors);
    }

    public abstract void assembleCompensation(List<T> t);

    public abstract void assembleErrors(List<ErrorModel> errorList);
}
