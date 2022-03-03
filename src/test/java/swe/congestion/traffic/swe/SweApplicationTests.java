package swe.congestion.traffic.swe;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import swe.congestion.traffic.swe.dto.GetTaxRequest;
import swe.congestion.traffic.swe.dto.GetTaxResponse;
import swe.congestion.traffic.swe.dto.VehicleDetails;
import swe.congestion.traffic.swe.service.CongestionTaxService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SweApplicationTests {
	@Autowired
	CongestionTaxService service;

	@Test
	public void holidayTest() {
		// Call the REST API

		GetTaxRequest request = new GetTaxRequest();
		Date dates[] = new Date[3];
		dates[0] = parseDate("2022-01-01 06:30:27");
		dates[1] = parseDate("2022-01-01 07:41:27");
		dates[2] = parseDate("2022-01-01 07:32:27");

		request.setDates(dates);
		request.setVehicle(getVehicleObject("Car"));

		GetTaxResponse response = service.getTax(request);
		assertTrue(response.getAmount() == 0);

	}

	@Test
	public void checkForNonHolidayTest() { // Call the REST API

		GetTaxRequest request = new GetTaxRequest();
		Date dates[] = new Date[3];
		dates[0] = parseDate("2022-02-01 06:30:27");
		dates[1] = parseDate("2022-02-01 07:41:27");
		dates[2] = parseDate("2022-03-01 07:59:27");

		request.setDates(dates);
		request.setVehicle(getVehicleObject("Car"));

		GetTaxResponse response = service.getTax(request);
		assertTrue(response.getAmount() == 49);

	}

	@Test
	public void checkForTollFreeVehicle() {

		GetTaxRequest request = new GetTaxRequest();
		Date dates[] = new Date[3];
		dates[0] = parseDate("2022-02-01 06:30:27");
		dates[1] = parseDate("2022-02-01 07:41:27");
		dates[2] = parseDate("2022-03-01 07:59:27");

		request.setDates(dates);
		request.setVehicle(getVehicleObject("Motorcycle"));

		GetTaxResponse response = service.getTax(request);
		assertTrue(response.getAmount() == 0);

	}

	@Test
	public void checkOnedayBeforeHoliday() {

		GetTaxRequest request = new GetTaxRequest();
		Date dates[] = new Date[1];
		dates[0] = parseDate("2022-04-14 06:30:27");

		request.setDates(dates);
		request.setVehicle(getVehicleObject("car"));

		GetTaxResponse response = service.getTax(request);
		assertTrue(response.getAmount() == 0);

	}

	@Test
	public void checkfor60Mins() {

		GetTaxRequest request = new GetTaxRequest();
		Date dates[] = new Date[3];
		dates[0] = parseDate("2022-04-19 06:15:27");

		dates[1] = parseDate("2022-04-19 06:25:27");
		dates[2] = parseDate("2022-04-19 06:29:27");
		request.setDates(dates);
		request.setVehicle(getVehicleObject("car"));

		GetTaxResponse response = service.getTax(request);
		assertTrue(response.getAmount() == 8);

	}

	public Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
		} catch (Exception e) {
			return null;
		}
	}

	public VehicleDetails getVehicleObject(String name) {
		VehicleDetails vehicle = new VehicleDetails();
		vehicle.setType(name);
		return vehicle;
	}

}
