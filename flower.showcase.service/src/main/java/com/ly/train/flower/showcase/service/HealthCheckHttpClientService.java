/**
 * Copyright © 2019 同程艺龙 (zhihui.li@ly.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
    return HttpFactory.httpAsyncClientFactory.get(requestContext);
  }

}
