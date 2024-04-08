package com.yzm.dev;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description:
 *
 * @author yzm
 * @date 2024/4/8  16:41
 */
@RestController
public class ProduceController {
    @Resource
    private RocketMQTemplate rocketmqTemplate;

    @GetMapping("/test")
    public void test() {
        Message<String> msg = MessageBuilder.withPayload("Hello,RocketMQ").build();
//        SendResult sendResult = rocketmqTemplate.send(topic, msg);
    }
}
