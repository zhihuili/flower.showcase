package com.ly.train.flower.showcase.springboot.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ly.train.flower.common.annotation.Flower;
import com.ly.train.flower.showcase.model.User;
import com.ly.train.flower.showcase.service.EndService;
import com.ly.train.flower.showcase.service.simple.UserServiceA;
import com.ly.train.flower.showcase.service.simple.UserServiceB;
import com.ly.train.flower.web.spring.FlowerController;

/**
 * @author leeyazhou
 */
@Flower("flower-showcase")
@RestController
@RequestMapping("/api/")
public class ShowcaseController extends FlowerController {

  @RequestMapping("test")
  public void process(User user, HttpServletRequest req) {
    doProcess(user, req);
  }

  @Override
  public void buildFlower() {
    getServiceFlow().buildFlow(UserServiceA.class, UserServiceB.class);
    getServiceFlow().buildFlow(UserServiceB.class, EndService.class);
    getServiceFlow().build();
  }

}
