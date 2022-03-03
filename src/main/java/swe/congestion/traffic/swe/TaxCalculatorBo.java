package swe.congestion.traffic.swe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * 
 * @author sharmak
 *
 */
public interface TaxCalculatorBo extends JpaRepository<TaxCalculator, Integer>{
	
	
	@Query(value = "SELECT * FROM taxcalculator  WHERE ahour = ?1 and btorange <= ?2 AND cfromrange >= ?2",
		       nativeQuery = true)
	TaxCalculator findtax(int hour,int minute);

}
