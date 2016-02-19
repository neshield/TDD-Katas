package stringcalc.arraycalc;

import static org.junit.Assert.*;

import java.util.IllformedLocaleException;

import org.junit.Before;
import org.junit.Test;


public class ArrayCalculatorTest {
	ArrayCalculator calc;
	@Before
	public void getCalc(){
		calc = new ArrayCalculator();
	}
	
	@Test
	public void testSum1and2() {
		assertEquals(calc.sumStringArray(new String[]{"1", "2"}), 3);
	}
	
	@Test
	public void testEmptyArray() {
		assertEquals(calc.sumStringArray(new String[]{""}), 0);
	}

}
