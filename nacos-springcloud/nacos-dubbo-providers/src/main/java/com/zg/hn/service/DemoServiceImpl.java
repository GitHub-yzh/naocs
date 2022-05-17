package com.zg.hn.service;

import com.zg.hn.service.DemoService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author YangZhengHui
 * @date 2022/5/17 10:42
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Value("${demo.serviceName}")
    private String serviceName;

    @Override
    public String sayName(String name) {
        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Service [name :%s , port : %d] %s(\"%s\") : Hello,%s",
                serviceName,
                rpcContext.getLocalPort(),
                rpcContext.getMethodName(),
                name,
                name);
    }
}
