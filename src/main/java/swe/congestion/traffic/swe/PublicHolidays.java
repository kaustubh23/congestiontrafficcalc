package swe.congestion.traffic.swe;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author sharmak
 *
 */
@Entity
@Table(name="publicholidays")
public class PublicHolidays {
	
	@Id
	private int id;
	private int day;
	private int month;
	private String ocassion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getOcassion() {
		return ocassion;
	}
	public void setOcassion(String ocassion) {
		this.ocassion = ocassion;
	}

}
