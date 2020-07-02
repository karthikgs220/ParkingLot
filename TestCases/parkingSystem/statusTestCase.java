package parkingSystem;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class statusTestCase {

	@Test
	public void test() throws Exception {
		Car c = new Car("KA-01-ZZ-1234","Red");
		ParkingLot p = new ParkingLot();
		p.setAvailableSpots(2);
		p.park(c);
		ArrayList<Car> test = p.status();
		assertEquals(c,test.get(0));
	}

}
