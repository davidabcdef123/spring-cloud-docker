package springcloud.microserviceconsumermovie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jdk.internal.dynalink.linker.LinkerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.microserviceconsumermovie.entity.User;
import springcloud.microserviceconsumermovie.fegin.UserFeginClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Super.Sun on 2017/12/7.
 */
@RestController
public class MovieController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    UserFeginClient userFeginClient;

    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        //return this.restTemplate.getForObject("http://localhost:8000/" + id, User.class);
        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }

    public User findByIdFallback(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认用户");
        return user;
    }

    @GetMapping("/user/instance")
    public List<ServiceInstance> showInfo() {
        return this.discoveryClient.getInstances("microservice-provider-user");
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的是哪个节点
        MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

   /* @GetMapping("/fegin/user/{id}")
    public User findById(@PathVariable long id) {
        return this.userFeginClient.findById(id);
    }*/


    @GetMapping("/get0")
    public User get0(){
        User user=new User();
        user.setId((long) 1);
        user.setUsername("张三");
        //user=userFeginClient.get(user);
        return user;
    }

    @GetMapping("/get1")
    public User get1(){
        return userFeginClient.get((long) 1,"张三");
    }

    @GetMapping("/get2")
    public User get2(Long id,String usernam){
        Map<String, Object> params = new HashMap<>();
        params.put("id", 1);
        params.put("username", "张三");
        return userFeginClient.get(params);
    }
}
