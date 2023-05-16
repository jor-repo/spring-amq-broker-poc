package co.api.producer.apiproducerreglas.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.api.producer.apiproducerreglas.jms.ProducerGestionDelSubsidio;

@RestController
@RequestMapping(path = "/api")
public class RestControllers {

	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	private static final String CONTEXT = "context";
	private static final String APPLICATION_JSON = "application/json";
	
	@Autowired
	ProducerGestionDelSubsidio producer;

	@PostMapping("/producer/api/spring")
	public ResponseEntity<?> execProducer() {
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl("no-cache, no-store, must-revalidate");
		headers.setPragma("no-cache");
		headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		headers.add(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON);
		
		try {
			this.procesarArchivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("{\"status\":\"ok\"}", headers, HttpStatus.OK);
	}

	private boolean procesarArchivo() throws IOException {

		try {
			for (int i = 0; i < 100000; i++) {

				String usuario = "{\"dni\": 1234" + i + ",\"amount\":"+i+",\"duration\":24,\"name\":\"usuario-"+i+"\",\"creditScore\":"+i+",\"interestRate\":1.5}";
				
				producer.send("sping-queue-test", usuario);
			}
		} catch (DataAccessException ex) {
			logger.error(CONTEXT, ex);
			return false;
		}
		return true;
	}

}