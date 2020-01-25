import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory cf = new ConnectionFactory();
        cf.setHost("localhost");
        cf.setPort(5672);
        Connection connection = cf.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("myQueue1",false,false,false,null);
        //Delivery call back , Cancel call back
        channel.basicConsume("myQueue1", (consumerTag,delivery)-> System.out.println(new String(delivery.getBody())),
                (consumerTag)->System.out.println("No Delivery message found"));

    }
}
