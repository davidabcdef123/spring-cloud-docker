package springcloud.microservicesimpleprovideruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.microservicesimpleprovideruser.dao.UserRepository;
import springcloud.microservicesimpleprovideruser.entity.User;

import java.util.List;


@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    User findOne = this.userRepository.findOne(id);
    return findOne;
  }

  @GetMapping("/user/instance")
  public List<ServiceInstance> showInfo(){
    return this.discoveryClient.getInstances("microservice-provider-user");
  }
}
