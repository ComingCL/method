package org.example.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/31 21:46
 */
public class Producer {
    public static void FAN() throws IOException, TimeoutException {
        Channel channel = RabbitUtil.conn();

        channel.queueDeclare("FANOUT1", true, false, false, null);
        channel.queueDeclare("FANOUT2", true, false, false, null);
        channel.queueDeclare("FANOUT3", true, false, false, null);

        String message = "hello world";

        channel.queueBind("FANOUT1", "amq.fanout", "", null);
        channel.queueBind("FANOUT2", "amq.fanout", "", null);
        channel.queueBind("FANOUT3", "amq.fanout", "", null);

        channel.basicPublish("amq.fanout", "DIRECT", null, message.getBytes(StandardCharsets.UTF_8));
        System.out.println("消息发送完毕");
        RabbitUtil.close();
    }
    public static void DIRECT() throws IOException, TimeoutException {
        Channel channel = RabbitUtil.conn();
        channel.queueDeclare("DIRECT1", true, false, false, null);
        channel.queueDeclare("DIRECT2", true, false, false, null);
        channel.queueDeclare("DIRECT3", true, false, false, null);

        channel.queueBind("DIRECT1", "amq.direct", "key1", null);
        channel.queueBind("DIRECT2", "amq.direct", "key1", null);
        channel.queueBind("DIRECT3", "amq.direct", "key3", null);
        String message = "hello world";
        channel.basicPublish("amq.direct", "key1", null, message.getBytes(StandardCharsets.UTF_8));
        System.out.println("消息发送完毕");
        RabbitUtil.close();
    }
    public static void TOPIC() throws IOException, TimeoutException {
        Channel channel = RabbitUtil.conn();
        channel.queueDeclare("TOPIC1", true, false, false, null);
        channel.queueDeclare("TOPIC2", true, false, false, null);
        channel.queueDeclare("TOPIC3", true, false, false, null);

        channel.queueBind("TOPIC1", "amq.topic", "key1.*", null);
        channel.queueBind("TOPIC2", "amq.topic", "key1.topic1", null);
        channel.queueBind("TOPIC3", "amq.topic", "key3.*", null);
        channel.confirmSelect();

        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) {
                System.out.println("ok");
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) {
                System.out.println("fail");
            }
        });

        final String message = "hello world";

        channel.basicPublish("amq.topic", "key2.hello33", true, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) {
                System.out.println(replyCode);
                System.out.println(message);
            }
        });
        System.out.println("消息发送完毕");
        channel.close();
        RabbitUtil.close();
    }
//    发消息
    public static void main(String[] args) throws IOException, TimeoutException {
//        FAN();
//        DIRECT();
//        TOPIC();
    }
}
