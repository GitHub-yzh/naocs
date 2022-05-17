package com.zg.hn;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

/**
 * @author YangZhengHui
 * @date 2022/5/17 10:48
 */
@EnableDubbo(scanBasePackages = "com.zg.hn.service")   /*激活Dubbo注解驱动以及外部化配置    scanBasePackages指定扫描包   将所有标注 @Service 的服务接口实现类暴露为 Spring Bean，随即被导出 Dubbo 服务。*/
@PropertySource(value = "classpath:/provider-config.properties")    /*是 Spring Framework 3.1 引入的标准导入属性配置资源注解，它将为 Dubbo 提供外部化配置。*/
public class DemoServiceProviderBootstrap {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DemoServiceProviderBootstrap.class);
        context.refresh();
        System.out.println("DemoService provider is starting...");
        System.in.read();
    }
}
