package parkingSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class spotNumbersForCarsWithColourTestCase {

	@Test
	public void test() throws Exception {
		Car c = new Car("KA-01-ZZ-1234","Red");
		ParkingLot p = new ParkingLot();
		p.setAvailableSpots(2);
		p.park(c);
		boolean ret = p.spotNumbersForCarsWithColour("Red");
		assertEquals(true, ret);
	}

}
