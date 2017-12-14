package springcloud.microserviceconsumermovie.fegin;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springcloud.config.FeginConfigration;
import springcloud.microserviceconsumermovie.entity.User;

/**
 * Created by Super.Sun on 2017/12/14.
 */

@FeignClient(name = "microservice-provider-user",configuration = FeginConfigration.class)
public interface UserFeginClient {

    //未使用fegin配置的时候
    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);*/

    /**
     * 使用feign自带的注解@RequestLine
     * @see https://github.com/OpenFeign/feign
     * @param id 用户id
     * @return 用户信息
     */
    @RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);
}
