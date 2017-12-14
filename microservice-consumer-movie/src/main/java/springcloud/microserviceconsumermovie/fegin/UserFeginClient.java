package springcloud.microserviceconsumermovie.fegin;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springcloud.config.FeginConfigration;
import springcloud.microserviceconsumermovie.entity.User;

import java.util.Map;

/**
 * Created by Super.Sun on 2017/12/14.
 */

@FeignClient(name = "microservice-provider-user",configuration = FeginConfigration.class)
//@FeignClient(name = "microservice-provider-user")
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
    /*@RequestLine("GET /{id}")
    public User findById(@Param("id") Long id);*/

   //不能这样写
    /*@RequestMapping(value = "/get0",method = RequestMethod.GET)
    public User get(@RequestParam User user);*/

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public User get(@RequestParam("id") Long id,@RequestParam("username")String username);

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public User get(@RequestParam("map") Map<String,Object> map);
}
