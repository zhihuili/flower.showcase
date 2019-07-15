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
package com.ly.train.flower.showcase.simple;

import com.ly.train.flower.core.akka.router.FlowRouter;
import com.ly.train.flower.core.service.container.FlowerFactory;
import com.ly.train.flower.core.service.container.ServiceFlow;
import com.ly.train.flower.core.service.container.simple.SimpleFlowerFactory;
import com.ly.train.flower.showcase.model.User;
import com.ly.train.flower.showcase.service.EndService;
import com.ly.train.flower.showcase.service.simple.UserServiceA;
import com.ly.train.flower.showcase.service.simple.UserServiceB;

/**
 * @author leeyazhou
 */
public class SimpleAsyncFlower {

  public static void main(String[] args) throws InterruptedException {
    FlowerFactory flowerFactory = new SimpleFlowerFactory("flower.yml");

    final String flowName = "flower.simpleflow";

    ServiceFlow serviceFlow = flowerFactory.getServiceFactory().getOrCreateServiceFlow(flowName);
    serviceFlow.buildFlow(UserServiceA.class, UserServiceB.class);
    serviceFlow.buildFlow(UserServiceB.class, EndService.class);
    serviceFlow.build();

    FlowRouter flowRouter = flowerFactory.getActorFactory().buildFlowRouter(flowName, 8);

    User user = new User();
    user.setName("simple flower");
    user.setAge(0);
    flowRouter.asyncCallService(user);
    
    Thread.sleep(1000);
    flowerFactory.stop();
  }
}
