package swe.congestion.traffic.swe.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import swe.congestion.traffic.swe.dto.GetTaxRequest;
import swe.congestion.traffic.swe.service.CongestionTaxService;
/**
 * 
 * @author sharmak
 *
 */
@Component
public class CongestionTaxProcessor implements Processor {

	@Autowired
	private CongestionTaxService service;


	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub

		String data = exchange.getIn().getBody(String.class);
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss");

		Gson gson = builder.create();

		GetTaxRequest request = gson.fromJson(data, GetTaxRequest.class);

		// GetTaxRequest request = objectMapper.readValue(data, GetTaxRequest.class);
		ObjectMapper mapper = new ObjectMapper();
		// Converting the Object to JSONString
		String jsonString = mapper.writeValueAsString(service.getTax(request));
		exchange.getOut().setBody(jsonString);

	}

}  
