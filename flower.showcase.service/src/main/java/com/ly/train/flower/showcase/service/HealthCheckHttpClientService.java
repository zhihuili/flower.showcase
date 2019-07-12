package com.ly.train.flower.showcase.service;

import java.util.concurrent.CompletableFuture;
import com.ly.train.flower.common.annotation.FlowerService;
import com.ly.train.flower.common.core.service.ServiceContext;
import com.ly.train.flower.core.service.impl.AbstractService;
import com.ly.train.flower.showcase.model.HttpAsyncReq;
import com.ly.train.flower.tools.http.HttpFactory;
import com.ly.train.flower.tools.http.config.RequestContext;

/**
 * @author leeyazhou
 */
@FlowerService
public class HealthCheckHttpClientService extends AbstractService<HttpAsyncReq, CompletableFuture<String>> {

  @Override
  public CompletableFuture<String> doProcess(HttpAsyncReq message, ServiceContext context) throws Throwable {

    RequestContext requestContext = new RequestContext("http://10.100.216.147:12051/flowerdsfasync/demo/get");
    return HttpFactory.httpClientFactory.get(requestContext);
  }

}
