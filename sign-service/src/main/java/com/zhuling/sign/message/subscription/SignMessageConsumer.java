package com.zhuling.sign.message.subscription;

import com.zhuling.repository.entities.GcPersonEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RocketMQMessageListener(topic = "sign", //topic主题
        consumerGroup = "sign-group",          //消费组
        messageModel = MessageModel.CLUSTERING,
        consumeMode = ConsumeMode.ORDERLY)
public class SignMessageConsumer implements RocketMQListener<GcPersonEntity> {

    @Override
    public void onMessage(GcPersonEntity gcPersonEntity) {
        log.info("消费到消息:{}", gcPersonEntity);
    }
}
