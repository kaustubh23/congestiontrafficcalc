package swe.congestion.traffic.swe.source;

import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import swe.congestion.traffic.swe.dto.GetTaxRequest;
import swe.congestion.traffic.swe.dto.GetTaxResponse;
import swe.congestion.traffic.swe.processor.CongestionTaxProcessor;
/**
 * 
 * @author sharmak
 *
 */
@Component
public class ApplicationRestProcess extends RouteBuilder {

	@BeanInject
	private CongestionTaxProcessor processor;

	@Override
	public void configure() throws Exception {
		rest().post("/getTaxDetails").consumes(MediaType.APPLICATION_JSON_VALUE).type(GetTaxRequest.class).outType(GetTaxResponse.class)
				.route().process(processor).endRest();

	}

}
