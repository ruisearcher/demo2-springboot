package com.example.demo2.util.testRabbitMQ;
import com.example.demo2.util.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

import java.io.IOException;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/10/12 9:53
 */

// 这是一个工作线程，相当于之前的消费者
public class Worker01 {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception {

        Channel channel = RabbitMqUtils.getChannel();
        //Channel channel = new RabbitMqUtils().getChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicQos(1);
        //消息接受
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String receivedMessage = new String(delivery.getBody());
            System.out.println("接收到消息:" + receivedMessage);
        };
        //消息被取消
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");

        };

        System.out.println("C1 消费者启动等待消费.................. ");
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}

