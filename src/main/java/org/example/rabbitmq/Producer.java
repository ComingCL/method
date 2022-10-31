package org.example.rabbitmq;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/31 21:46
 */
public class Producer {
//    队列名称
    public static final String QUEUE_NAME = "hello";
//    发消息
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitUtil.conn();
        /**
         * 生成一个队列
         * 1. 队列名称
         * 2. 队列里面的消息是否持久化(磁盘) 默认情况消息存储在内存中
         * 3. 该队列是否只供一个消费者进行消费 是否进行消息共享, true可以多个消费者消费
         * 4. 队列是否自动删除
         * 5. 其他参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        发消息
        String message = "hello world";
        /**
         * 发送一个消费
         * 1. 发送到哪个交换机
         * 2. 路由的key是哪个 本次是队列的名称
         * 3. 其他参数消息
         * 4. 发送消息的消息体
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        System.out.println("消息发送完毕");
    }
}
