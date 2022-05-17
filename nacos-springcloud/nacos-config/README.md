# 初识nacos-config
Nacos Spring Cloud

添加依赖
- 添加依赖是一定要去官网看对应springboot的版本，版本兼容性非常差
```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
    <version>2.2.7.RELEASE</version>
</dependency>
```

配置naocs地址

addr需要在bootstrap.properties中配置,在application.properties中配置无效;
因为bootstrap是在spring还没加载默认配置时就执行,后者优先级比bootstrap低。
# 延伸阅读

