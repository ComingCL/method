package org.example.rabbitmq;

import com.rabbitmq.client.*;
import sun.reflect.generics.tree.Tree;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/31 21:46
 */
public class Producer {
    private final static SortedSet<Long> sortedSet = new TreeSet<>();
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
        channel.queueBind("DIRECT2", "amq.direct", "key2", null);
        channel.queueBind("DIRECT3", "amq.direct", "key3", null);
        String message = "hello world";
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("ok");
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("fail");
            }
        });
        channel.basicPublish("amq.direct", "key1", true, null, message.getBytes(StandardCharsets.UTF_8));
        channel.addReturnListener(System.out::println);
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
                if(multiple){
                    sortedSet.headSet(deliveryTag + 1).clear();
                }else{
                    sortedSet.remove(deliveryTag);
                }
                System.out.println("ok");
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) {
                // 此处进行消息重发
                if(multiple){
                    sortedSet.headSet(deliveryTag + 1).clear();
                }else{
                    sortedSet.remove(deliveryTag);
                }
            }
        });

        final String message = "hello world";
        channel.basicPublish("amq.topic", "key2.hello33", true, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
        channel.addReturnListener(System.out::println);

        System.out.println("消息发送完毕");
        channel.close();
        RabbitUtil.close();
    }
    public static void DLX() throws IOException, TimeoutException {
        Channel channel = RabbitUtil.conn();

        channel.txSelect();

        channel.exchangeDeclare("exchange.dlx", "direct", true);
        channel.exchangeDeclare("exchange.normal", "fanout", true);
        Map<String, Object> map = new HashMap<>();
        map.put("x-message-ttl", 10000);
        map.put("x-dead-letter-exchange", "exchange.dlx");
        map.put("x-dead-letter-routing-key", "routingkey");
        channel.queueDeclare("queue.normal", true, false, false, map);
        channel.queueBind("queue.normal", "exchange.normal", "");
        channel.queueDeclare("queue.dlx", true, false, false, null);
        channel.queueBind("queue.dlx", "exchange.dlx", "routingkey");
        channel.basicPublish("exchange.normal", "rk", MessageProperties.PERSISTENT_TEXT_PLAIN, "dlx".getBytes(StandardCharsets.UTF_8));
        RabbitUtil.close();
    }
//    发消息
    public static void main(String[] args) throws IOException, TimeoutException {
//        FAN();
//        DIRECT();
        TOPIC();
//        DLX();

    }
}
