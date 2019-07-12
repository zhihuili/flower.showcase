package com.ly.train.flower.showcase.service;

import com.alibaba.fastjson.JSON;
import com.ly.train.flower.common.annotation.FlowerService;
import com.ly.train.flower.common.core.service.ServiceContext;
import com.ly.train.flower.core.service.Complete;
import com.ly.train.flower.core.service.impl.AbstractService;
import com.ly.train.flower.core.service.web.Flush;

/**
 * @author leeyazhou
 */
@FlowerService
public class EndService extends AbstractService<Object, Object> implements Flush, Complete {

  @Override
  public Object doProcess(Object message, ServiceContext context) throws Throwable {
    if (context.getWeb() != null) {
      if (message instanceof String) {
        context.getWeb().printJSON((String) message);
      } else
        context.getWeb().printJSON(JSON.toJSONString(message));
    }
    return message;
  }

}
