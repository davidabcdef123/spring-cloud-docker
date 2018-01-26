package springcloud.microserviceconsumermovie.fegin;

import org.springframework.stereotype.Component;
import springcloud.microserviceconsumermovie.entity.User;

import java.util.Map;

/**
 * Created by Super.Sun on 2017/12/14.
 */
@Component
public class FeignClientFallback implements UserFeginClient{
    @Override
    public User get(Long id, String username) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }

    @Override
    public User get(Map<String, Object> map) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }
}
