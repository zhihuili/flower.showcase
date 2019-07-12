package com.ly.train.flower.showcase.http;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ly.train.flower.web.spring.context.FlowerComponentScan;

/**
 * @author leeyazhou
 */
@SpringBootApplication
@FlowerComponentScan("com.ly.train.flower.showcase")
public class HttpApplication {

  public static void main(String[] args) {
    SpringApplication.run(HttpApplication.class, args);
  }
}
