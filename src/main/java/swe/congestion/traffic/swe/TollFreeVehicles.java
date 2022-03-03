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
@Table(name="tollfreevehicles")
public class TollFreeVehicles {

	@Id
	private int id;
	private String name;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
