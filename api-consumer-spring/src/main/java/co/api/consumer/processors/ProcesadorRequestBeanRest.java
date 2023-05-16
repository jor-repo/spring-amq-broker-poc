package co.api.consumer.processors;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;
import org.apache.http.entity.StringEntity;

@Service
public class ProcesadorRequestBeanRest implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		//System.out.println("messageText = " + exchange.getIn().getBody());
		String bodyIn = (String) exchange.getIn().getBody();

		System.out.println("mensaje desde cola: " + bodyIn);
		
		/*HttpPost postD = new HttpPost("http://localhost:8090/evaluacion/api/evaluacion");
		postD.addHeader("content-type", "application/json");
		postD.addHeader("Authorization", "Basic ZG1BZG1pbjpyZWRoYXRkbTEh");

		StringBuilder jsonD = new StringBuilder();
		jsonD.append(bodyIn);

		try {
			postD.setEntity(new StringEntity(jsonD.toString()));
		} catch (UnsupportedEncodingException e2) {	
			e2.printStackTrace();
		}

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse response = httpClient.execute(postD)) {

			try {
				System.out.println("status-code: " + response.getStatusLine());
				String responseString = new BasicResponseHandler().handleResponse(response);
				System.out.println("proxy-response: " + responseString);
			} finally {
				response.close();
			}

		} catch (IOException e1) {
			System.out.println("Error consumiendo servicio con mensaje: " + bodyIn);
			
		}*/

	}

}
