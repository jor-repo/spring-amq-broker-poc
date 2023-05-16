package co.api.producer.apiproducerreglas.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.Queue;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("co.api.producer")
@EnableJms
public class ApplicationContext {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("sping-queue-test");
    }

    @Bean
    public ActiveMQConnectionFactory connectionFatory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("vm://ex-aao-amq-hdls-svc.amq-broker.svc.cluster.local:61616");
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        return new JmsTemplate(connectionFatory());
    }
	
}
