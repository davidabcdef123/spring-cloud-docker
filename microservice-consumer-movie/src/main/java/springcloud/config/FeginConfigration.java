package springcloud.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Super.Sun on 2017/12/14.
 *  * 该类为Feign的配置类
 * 注意：该不应该在主应用程序上下文的@ComponentScan中。
 */
@Configuration
public class FeginConfigration {

    /**
     * 将契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
     * @return 默认的feign契约
     */
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
