package springcloud.microservicesimpleconsumermovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springcloud.microservicesimpleconsumermovie.entity.User;

/**
 * Created by Super.Sun on 2017/12/7.
 */
@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable long id){
        return this.restTemplate.getForObject("http://localhost:8080/" + id, User.class);

    }
}
