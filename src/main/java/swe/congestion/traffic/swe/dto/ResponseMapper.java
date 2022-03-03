package swe.congestion.traffic.swe.dto;

import org.springframework.stereotype.Component;
/**
 * 
 * @author sharmak
 *
 */
@Component
public class ResponseMapper {
	
	
	public GetTaxResponse mapper(int i) {
		
		GetTaxResponse response = new GetTaxResponse();
		Response rsp = new Response();
		rsp.setResponseCode("200");
		rsp.setResponseMessage("Success");
		response.setAmount(i);
		response.setResponse(rsp);
		response.setCurrency("SEK");
		return response;
	}

}
