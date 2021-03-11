package com.myou.jvm.dao;

import com.myou.jvm.annotatuon.RpcReference;

public interface RpcService {
    @RpcReference("select id=1;")
    String testProxy();
}
