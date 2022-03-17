package com.zhuling.order.component.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(topic = "operation-topic", //topic主题
        consumerGroup = "consumer-group",          //消费组
        messageModel = MessageModel.CLUSTERING,
        consumeMode = ConsumeMode.ORDERLY)
public class OperationTopicListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        log.info("接受到消息：{}", message);
    }
}
