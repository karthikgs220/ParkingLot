package parkingSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class parkTestCase {

	@Test
	public void test() throws Exception {
		Car c = new Car("KA-01-ZZ-1234","Red");
		ParkingLot p = new ParkingLot();
		p.setAvailableSpots(2);
		boolean ret = p.park(c);
		Car test = p.getSpot().get(0);
		assertEquals(c, test);
		assertEquals(true, ret);
	}

}
