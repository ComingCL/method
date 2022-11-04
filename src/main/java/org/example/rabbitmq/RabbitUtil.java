package org.example.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: ComingLiu
 * @Date: 2022/10/31 22:46
 */
public class RabbitUtil {
    static final ConnectionFactory factory = new ConnectionFactory();
    static Connection connection;
    public static Channel conn() throws IOException, TimeoutException {
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        connection = factory.newConnection();
        return connection.createChannel();
    }
    public static void Channel_Close() throws IOException {
        connection.close();
    }
}
