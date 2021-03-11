package com.myou.jvm.listeners.processor;

import com.myou.jvm.models.ErrorModel;
import com.myou.jvm.models.ExpropriationCompensationModel;

import java.util.List;

public abstract class AnalysisCompensationProcessor<T> {
    public abstract void assembleCompensation(List<T> t);

    public abstract void assembleErrors(List<ErrorModel> errorList);
}
