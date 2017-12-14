package springcloud.microservicesimpleprovideruser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloud.microservicesimpleprovideruser.dao.UserRepository;
import springcloud.microservicesimpleprovideruser.entity.User;

import java.util.Collection;
import java.util.List;


@RestController
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
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

  /*@GetMapping("auth/{id}")
  public User authFindById(@PathVariable Long id) {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) {
      UserDetails user = (UserDetails) principal;
      Collection<? extends GrantedAuthority> collection = user.getAuthorities();
      for (GrantedAuthority c : collection) {
        // 打印当前登录用户的信息
        UserController.LOGGER.info("当前用户是{}，角色是{}", user.getUsername(), c.getAuthority());
      }
    } else {
      // do other things
    }
    User findOne = this.userRepository.findOne(id);
    return findOne;
  }*/
}
