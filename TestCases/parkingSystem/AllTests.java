package parkingSystem;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ leaveTestCase.class, parkTestCase.class, registrationNumbersForCarsWithColourTestCase.class,
		setAvailableSpotsTestCase.class, spotNumberForRegistrationNumberTestCase.class,
		spotNumbersForCarsWithColourTestCase.class, statusTestCase.class })
public class AllTests {

}
