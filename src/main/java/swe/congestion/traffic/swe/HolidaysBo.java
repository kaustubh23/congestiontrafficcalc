package swe.congestion.traffic.swe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * 
 * @author sharmak
 *
 */
public interface HolidaysBo extends JpaRepository<PublicHolidays, Integer>{
	
	
	@Query(value = "SELECT * FROM publicholidays  WHERE day = ?1 and month = ?2",
		       nativeQuery = true)
	PublicHolidays findHolidayByDate(int day, int month);

}
