package swe.congestion.traffic.swe.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swe.congestion.traffic.swe.HolidaysBo;
import swe.congestion.traffic.swe.TaxCalculator;
import swe.congestion.traffic.swe.TaxCalculatorBo;
import swe.congestion.traffic.swe.TollFreeVehiclesBo;
import swe.congestion.traffic.swe.dto.GetTaxRequest;
import swe.congestion.traffic.swe.dto.GetTaxResponse;
import swe.congestion.traffic.swe.dto.ResponseMapper;
import swe.congestion.traffic.swe.dto.VehicleDetails;
/**
 * 
 * @author sharmak
 *
 */
@Service
public class CongestionTaxService {
	@Autowired
	HolidaysBo holiday;
	@Autowired
	TollFreeVehiclesBo tollfree;
	@Autowired
	TaxCalculatorBo taxCalculatorBo;

	public GetTaxResponse getTax(GetTaxRequest request) {
		VehicleDetails vehicle = request.getVehicle();
		Date[] dates = request.getDates();
		Date intervalStart = dates[0];
		int totalFee = 0;

		for (int i = 0; i < dates.length; i++) {
			Date date = dates[i];
			int nextFee = GetTollFee(date, vehicle);
			int tempFee = GetTollFee(intervalStart, vehicle);

			long diffInMillies = date.getTime() - intervalStart.getTime();
			long minutes = diffInMillies / 1000 / 60;

			if (minutes <= 60) {
				if (totalFee > 0)
					totalFee -= tempFee;
				if (nextFee >= tempFee)
					tempFee = nextFee;
				totalFee += tempFee;
			} else {
				totalFee += nextFee;
			}
		}

		if (totalFee > 60)
			totalFee = 60;
		ResponseMapper responseMapper = new ResponseMapper();
		return responseMapper.mapper(totalFee);
	}

	private boolean IsTollFreeVehicle(VehicleDetails vehicle) {
		if (vehicle == null)
			return false;
		String vehicleType = vehicle.getType();

		if (tollfree.findTollFreeVehicles(vehicleType) != null) {
			return true;
		} else {
			return false;
		}

	}

	public int GetTollFee(Date date, VehicleDetails vehicle) {
		if (IsTollFreeDate(date) || IsTollFreeVehicle(vehicle))
			return 0;
		// Logic for month of July
		if (date.getMonth() == 6) {
			return 0;
		}

		int hour = date.getHours();
		int minute = date.getMinutes();
		TaxCalculator calc = taxCalculatorBo.findtax(hour, minute);
		if (calc != null) {

			return calc.getDcharges();

		}

		else {
			return 0;
		}

	}

	private Boolean IsTollFreeDate(Date date) {

		int year = date.getYear();
		int month = date.getMonth() + 1;
		int dayOfMonth = date.getDate();

		// check for Saturday Sunday
		if (date.getDay() == 0 || date.getDay() == 6)
			return true;

		// check if the holidays on the same day

		if (holiday.findHolidayByDate(dayOfMonth, month) != null) {
			return true;
		}

		// check if the next day is holiday
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		Date nextDay = cal.getTime();

		if (holiday.findHolidayByDate(nextDay.getDate(), nextDay.getMonth()+1) != null) {
			return true;
		}
		return false;
	}

}
