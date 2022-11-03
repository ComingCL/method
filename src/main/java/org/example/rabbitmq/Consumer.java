package org.example.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/31 22:32
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
//        创建连接工厂
        Channel channel = RabbitUtil.conn();
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
}
