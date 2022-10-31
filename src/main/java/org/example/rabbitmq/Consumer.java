package org.example.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

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
        Channel channel = RabbitUtil.conn();
        /**
         * 消费者消费消息
         * 1. 消费哪个队列
         * 2. 消费成功之后是否要自动应答 true代表的自动应答 false表示手动应答
         * 3. 消费者未成功消费的回调
         * 4. 消费者消费成功的回调
         */

    }
}
