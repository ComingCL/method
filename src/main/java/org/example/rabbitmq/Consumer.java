package org.example.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.example.strategy.Dog;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/31 22:32
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
//        创建连接工厂
        final Channel channel = RabbitUtil.conn();
        boolean autoAck = false;
        // 单条接收
//        GetResponse getResponse = channel.basicGet("DIRECT2", autoAck);
//        System.out.println(new String(getResponse.getBody()));
//        channel.basicReject(getResponse.getEnvelope().getDeliveryTag(), true);
//        channel.basicGet()
//        channel.basicAck(getResponse.getEnvelope().getDeliveryTag(), false);
        channel.basicConsume("DIRECT1", autoAck, "myConsumerTag", new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                long deliveryTag = envelope.getDeliveryTag();
                channel.basicAck(deliveryTag, false);
                System.out.println(envelope.getRoutingKey() + " " + envelope.getExchange());
            }
        });
        channel.close();
        Dog dog = new Dog(0, 0);
        RabbitUtil.close();
    }
}
