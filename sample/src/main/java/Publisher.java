import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory cf = new ConnectionFactory();
        cf.setHost("localhost");
        Connection connection = cf.newConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare("myQueue1",false,false,false,null);

        channel.basicPublish("","myQueue1",null,"Cooku".getBytes());
        channel.close();
        connection.close();
    }
}
