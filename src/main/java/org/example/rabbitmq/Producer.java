package org.example.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/31 21:46
 */
public class Producer {
//    交换机名称
    public static final String FAN_EXCHANGE = "FAN_EXCHANGE_DEMO";
    public static final String DIRECT_EXCHANGE = "DIRECT_EXCHANGE_DEMO";
    public static final String TOPIC_EXCHANGE = "TOPIC_EXCHANGE_DEMO";
    public static final String HEADERS_EXCHANGE = "HEADERS_EXCHANGE_DEMO";
//    队列名称
    public static final String FAN_QUEUE = "FAN_QUEUE_DEMO";
    public static final String DIRECT_QUEUE = "DIRECT_QUEUE_DEMO";
    public static final String TOPIC_QUEUE = "TOPIC_QUEUE_DEMO";
    public static final String HEADERS_QUEUE = "HEADERS_QUEUE_DEMO";
    public static final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());
    public static void FAN_METHOD() throws IOException, TimeoutException {
        Channel channel = RabbitUtil.conn();
        channel.exchangeDeclare(FAN_EXCHANGE, BuiltinExchangeType.FANOUT, true, true,false, null);
        channel.queueDeclare(FAN_QUEUE, true, false, true, null);
        channel.queueBind(FAN_QUEUE, FAN_QUEUE, "333");
        channel.confirmSelect();
        channel.basicPublish(FAN_EXCHANGE, "", null,"hello world".getBytes(StandardCharsets.UTF_8));

        channel.close();
        RabbitUtil.Channel_Close();
    }
    public static void DIRECT_METHOD() throws IOException, TimeoutException {
        Channel channel = RabbitUtil.conn();
        channel.exchangeDeclare(DIRECT_EXCHANGE, BuiltinExchangeType.FANOUT, true, true,false, null);
        channel.queueDeclare();
        channel.confirmSelect();
        channel.close();
        RabbitUtil.Channel_Close();
    }
    public static void TOPIC_METHOD() throws IOException, TimeoutException {
        Channel channel = RabbitUtil.conn();
        channel.exchangeDeclare(TOPIC_EXCHANGE, BuiltinExchangeType.FANOUT, true, true,false, null);
        channel.queueDeclare();
        channel.confirmSelect();
        channel.close();
        RabbitUtil.Channel_Close();
    }
    public static void HEADERS_METHOD() throws IOException, TimeoutException {
        Channel channel = RabbitUtil.conn();
        channel.exchangeDeclare(HEADERS_EXCHANGE, BuiltinExchangeType.FANOUT, true, true,false, null);
        channel.queueDeclare();
        channel.confirmSelect();
        channel.close();
        RabbitUtil.Channel_Close();
    }
//    发消息
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

    }
}
