package com.zg.hn;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zg.hn.service.DemoService;
import com.zg.hn.service.DemoServiceImpl;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author YangZhengHui
 * @date 2022/5/17 10:56
 */

@EnableDubbo
@PropertySource(value = "classpath:/consumer-config.properties")
public class DemoServiceConsumerBootstrap {

    @Resource
    private DemoService demoService;

    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            System.out.println(demoService.sayName("小马哥（mercyblitz）"));
        }
    }

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DemoServiceConsumerBootstrap.class);
        context.refresh();
        context.close();
    }
}
