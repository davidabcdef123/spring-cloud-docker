package com.gatewat.zuul;

import com.gatewat.zuul.filter.pre.PreRequestLogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {

  @Bean
  public PreRequestLogFilter preRequestLogFilter() {
    return new PreRequestLogFilter();
  }

  public static void main(String[] args) {
    SpringApplication.run(ZuulApplication.class, args);
  }
}
