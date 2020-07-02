package parkingSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class leaveTestCase {

	@Test
	public void test() throws Exception {
		Car c = new Car("KA-01-ZZ-1234","Red");
		ParkingLot p = new ParkingLot();
		p.setAvailableSpots(2);
		p.park(c);
		boolean ret1 = p.leave(1);
		Car test = p.getSpot().get(0);
		assertEquals(null, test);
		assertEquals(true,ret1);
	}

}
