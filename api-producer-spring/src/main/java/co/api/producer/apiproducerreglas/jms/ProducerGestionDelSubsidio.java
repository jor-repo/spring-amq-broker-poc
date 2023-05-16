package co.api.producer.apiproducerreglas.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerGestionDelSubsidio {

	private static final Logger logger = LoggerFactory.getLogger(ProducerGestionDelSubsidio.class);

    @Autowired
    public JmsTemplate jmsTemplate;
	
    public void send(String cola, Object mensaje) {
    	long init = System.currentTimeMillis();
    	this.jmsTemplate.convertAndSend(cola, mensaje);
        logger.info("mensaje:: " + mensaje);	
    }
    
}
