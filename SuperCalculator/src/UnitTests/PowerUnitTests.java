/*
 * PowerUnitTests Class
 * 
 * August 10th 2021
 * 
 */

import org.junit.Test;
import static org.junit.Assert.*;
import supercalculator.Power;

public class PowerUnitTests {
	@Test
	public void TestPowerOfZero() {
		Power power = new Power();
		assertEquals(1, power.calculate(34525.345, 0), 0);
	}
	
	@Test
	public void TestBaseZero() {
		Power power = new Power();
		assertEquals(0, power.calculate(0, 99999), 0);
	}
	
	@Test
	public void TestPowerValuesAreCalculatedCorrectly() {
		Power power = new Power();
		assertEquals(3004528456.931144, power.calculate(234.123, 4), 0);
		assertEquals(483736625, power.calculate(785, 3), 0);
	}
}
