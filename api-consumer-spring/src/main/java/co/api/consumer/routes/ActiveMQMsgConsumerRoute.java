package co.api.consumer.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import co.api.consumer.processors.ProcesadorRequestBeanRest;

@Component
public class ActiveMQMsgConsumerRoute extends RouteBuilder {

	
    @Override
    public void configure() throws Exception {
        from("activemq:sping-queue-test")
        .bean(ProcesadorRequestBeanRest.class);
    }
            
}


