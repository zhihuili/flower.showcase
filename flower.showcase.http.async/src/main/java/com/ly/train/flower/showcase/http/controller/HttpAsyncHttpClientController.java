package com.ly.train.flower.showcase.http.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ly.train.flower.common.annotation.Flower;
import com.ly.train.flower.showcase.model.HttpAsyncReq;
import com.ly.train.flower.showcase.service.EndService;
import com.ly.train.flower.showcase.service.HealthCheckHttpClientService;
import com.ly.train.flower.web.spring.FlowerController;

/**
 * @author leeyazhou
 */
@Flower("flower_showcase_http_async")
@RestController
@RequestMapping("/api/httpclient/")
public class HttpAsyncHttpClientController extends FlowerController {

  @RequestMapping("test")
  public void process(HttpAsyncReq param, HttpServletRequest req) {
    doProcess(param, req);
  }

  @Override
  public void buildFlower() {
    getServiceFlow().buildFlow(HealthCheckHttpClientService.class, EndService.class);
    getServiceFlow().build();
  }

}
