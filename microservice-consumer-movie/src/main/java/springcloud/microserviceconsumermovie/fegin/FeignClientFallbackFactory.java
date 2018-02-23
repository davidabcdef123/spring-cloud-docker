package springcloud.microserviceconsumermovie.fegin;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import springcloud.microserviceconsumermovie.entity.User;

import java.util.Map;

/**
 * Created by Super.Sun on 2018/2/23.
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeginClient> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeginClient create(Throwable throwable) {
        return new UserFeginClient() {
            @Override
            public User findById(Long id) {
                // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
                // 否则在引用启动时，就会打印该日志。
                // 详见https://github.com/spring-cloud/spring-cloud-netflix/issues/1471
                FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", throwable);
                User user = new User();
                user.setId(-1L);
                user.setUsername("默认用户");
                return user;
            }

            @Override
            public User get(Long id, String username) {
                return null;
            }

            @Override
            public User get(Map<String, Object> map) {
                return null;
            }
        };
    }
}
