package springcloud.microserviceconsumermovie.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;
import springcloud.config.RibbonConfiguration;


/**
 * 使用RibbonClient，为特定name的Ribbon Client自定义配置.
 * 使用@RibbonClient的configuration属性，指定Ribbon的配置类.
 * 可参考的示例：
 */
/*@Configuration
@RibbonClient(name = "microservice-provider-user", configuration = RibbonConfiguration.class)*/
public class TestConfiguration {
}