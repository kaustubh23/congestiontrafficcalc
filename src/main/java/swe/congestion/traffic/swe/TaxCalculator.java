package swe.congestion.traffic.swe;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author sharmak
 * 
 *
 */
@Entity
@Table(name="taxcalculator")
public class TaxCalculator {

	@Id
	private int id;
	private int ahour;
	private int btorange;
	private int cfromrange;
	private int dcharges;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAhour() {
		return ahour;
	}
	public void setAhour(int ahour) {
		this.ahour = ahour;
	}
	public int getBtorange() {
		return btorange;
	}
	public void setBtorange(int btorange) {
		this.btorange = btorange;
	}
	public int getCfromrange() {
		return cfromrange;
	}
	public void setCfromrange(int cfromrange) {
		this.cfromrange = cfromrange;
	}
	public int getDcharges() {
		return dcharges;
	}
	public void setDcharges(int dcharges) {
		this.dcharges = dcharges;
	}
	
	
	
}
