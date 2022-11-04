package org.example.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/31 22:32
 */
public class Consumer {
    public static final String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException {
//        创建连接工厂
        final Channel channel = RabbitUtil.conn();
        /**
         * 消费者消费消息
         * 1. 消费哪个队列
         * 2. 消费成功之后是否要自动应答 true代表的自动应答 false表示手动应答
         * 3. 消费者未成功消费的回调
         * 4. 消费者消费成功的回调
         */
        boolean autoAck = false;
        GetResponse getResponse = channel.basicGet(QUEUE_NAME, autoAck);
        System.out.println(new String(getResponse.getBody()));
        channel.basicReject(getResponse.getEnvelope().getDeliveryTag(), false);
//        channel.basicAck(getResponse.getEnvelope().getDeliveryTag(), false);
//        channel.basicConsume(QUEUE_NAME, autoAck, "myConsumerTag", new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag,
//                                       Envelope envelope,
//                                       AMQP.BasicProperties properties,
//                                       byte[] body) throws IOException {
//                String routingKey = envelope.getRoutingKey();
//                String contentType = properties.getContentType();
//                long deliveryTag = envelope.getDeliveryTag();
////                channel.basicAck(deliveryTag, false);
////                System.out.println(envelope.getRoutingKey() + " " + envelope.getExchange());
//            }
//        });
        channel.close();
        RabbitUtil.Channel_Close();
    }
}
