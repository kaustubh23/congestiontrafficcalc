package swe.congestion.traffic.swe.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 
 * @author sharmak
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetTaxRequest {
		
private	VehicleDetails vehicle;

@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
private	Date[] dates;
public VehicleDetails getVehicle() {
	return vehicle;
}
public void setVehicle(VehicleDetails vehicle) {
	this.vehicle = vehicle;
}
public Date[] getDates() {
	return dates;
}
public void setDates(Date[] dates) {
	this.dates = dates;
}


}
