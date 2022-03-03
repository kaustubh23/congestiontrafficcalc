package swe.congestion.traffic.swe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import swe.congestion.traffic.swe.dto.GetTaxRequest;
import swe.congestion.traffic.swe.dto.GetTaxResponse;
import swe.congestion.traffic.swe.dto.VehicleDetails;
import swe.congestion.traffic.swe.service.CongestionTaxService;
@RunWith(SpringRunner.class)
@SpringBootTest
class SweApplicationTests {

	
	
	@Test
	public void holidayTest() {
	   // Call the REST API
		
		CongestionTaxService service = new CongestionTaxService();
		GetTaxRequest request = new GetTaxRequest();
		Date dates[] = new Date[3];
		dates[0] = parseDate("2022-01-01 06:30:27");
		dates[1] = parseDate("2022-01-01 07:41:27");
		dates[2] = parseDate("2022-01-01 07:32:27");
		
		request.setDates(dates);
		request.setVehicle(getVehicleObject("Car"));
		
		
		GetTaxResponse response=	service.getTax(request);
		assertTrue(response.getAmount()==0);
		
	}
	/*
	 * 
	 * 
	 * @Test public void checkForNonHolidayTest() { // Call the REST API
	 * 
	 * CongestionTaxService service = new CongestionTaxService(); GetTaxRequest
	 * request = new GetTaxRequest(); Date dates[] = new Date[3]; dates[0] =
	 * parseDate("2022-02-01 06:30:27"); dates[1] =
	 * parseDate("2022-02-01 07:41:27"); dates[2] =
	 * parseDate("2022-03-01 07:32:27");
	 * 
	 * request.setDates(dates); request.setVehicle(getVehicleObject("Car"));
	 * 
	 * 
	 * GetTaxResponse response= service.getTax(request);
	 * assertTrue(response.getAmount()==0);
	 * 
	 * }
	 */
	
	public  Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public VehicleDetails getVehicleObject(String name) {
		VehicleDetails vehicle= new VehicleDetails();
		vehicle.setType(name);
		return vehicle;
	}

}
