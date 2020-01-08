package com.ly.train.flower.showcase.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ly.train.flower.web.spring.context.FlowerComponentScan;

/**
 * @author leeyazhou
 */
@SpringBootApplication
@FlowerComponentScan("com.ly.train.flower")
public class FlowerApplication {

  public static void main(String[] args) {
    SpringApplication.run(FlowerApplication.class, args);
  }
}
