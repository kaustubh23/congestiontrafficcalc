package swe.congestion.traffic.swe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * 
 * @author sharmak
 *
 */
public interface TollFreeVehiclesBo extends JpaRepository<TollFreeVehicles, Integer>{
	
	
	@Query(value = "SELECT * FROM tollfreevehicles  WHERE name = ?1",
		       nativeQuery = true)
	TollFreeVehicles findTollFreeVehicles(String name);

}
