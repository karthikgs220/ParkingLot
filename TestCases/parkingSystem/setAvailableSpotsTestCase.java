package parkingSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class setAvailableSpotsTestCase {

	@Test
	public void test() {
		ParkingLot p = new ParkingLot();
		p.setAvailableSpots(2);
		assertEquals(2,p.getAvailableSpots());
	}

}
