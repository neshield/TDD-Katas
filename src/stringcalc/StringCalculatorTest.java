package stringcalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	StringCalculator calc;
	@Before
	public void getCalc(){
		calc = new StringCalculator();
	}
	
	private void testNums(String s, int expected) throws Exception{
		assertEquals(calc.add(s), expected);
	}
	
	@Test
	public void testEmptyString() throws Exception {
		testNums("", 0);
	}
	
	@Test
	public void testSingle0() throws Exception {
		testNums("0", 0);
	}
	
	@Test
	public void testSingle1() throws Exception{
		testNums("1", 1);
	}
	
	@Test
	public void testSingle2() throws Exception{
		testNums("2", 2);
	}

	@Test
	public void test1and1() throws Exception{
		testNums("1,1", 2);
	}
	
	@Test
	public void test2and2() throws Exception {
		testNums("2,2", 4);
	}
	
	@Test
	public void testDoubleDigits() throws Exception {
		testNums("12", 12);
	}
	
	@Test
	public void test1and2and12() throws Exception{
		testNums("1,2,12", 15);
	}
	
	@Test
	public void testManyNumbers() throws Exception{
		testNums("1,2,4,8,20", 35);
	}
	
	@Test
	public void testManyNumbersNegatives() throws Exception {
		boolean exceptionThrown = false;

		try {
			testNums("-1,2,4,-8,20", 17);
		} catch (Exception e) {
			exceptionThrown = true;
			assertTrue(e.getMessage().contains("-1"));
			assertTrue(e.getMessage().contains("-8"));
			assertFalse(e.getMessage().contains("4"));
			assertFalse(e.getMessage().contains("0"));
			assertFalse(e.getMessage().contains("2"));
		}

		assertTrue(exceptionThrown);
	}
	
	@Test
	public void testNewlines() throws Exception{
		testNums("1\n2,4,8\n20", 35);
	}
	
	@Test
	public void testNewlinesNegative() throws Exception {
		boolean exceptionThrown = false;

		try {
			testNums("-1\n2,-4,8\n20", 25);
		} catch (Exception e) {
			exceptionThrown = true;
			assertTrue(e.getMessage().contains("-1"));
			assertTrue(e.getMessage().contains("-4"));
			assertFalse(e.getMessage().contains("8"));
			assertFalse(e.getMessage().contains("0"));

		}

		assertTrue(exceptionThrown);
	}
	
	@Test
	public void testSemicolonDelimiter() throws Exception{
		testNums("//;\n1;2", 3);
		testNums("//;\n2;3;10", 15);
	}
	
	@Test
	public void testColonDelimiter() throws Exception{
		testNums("//:\n1:2:6", 9);
	}
	
	
	@Test
	public void testSingleNegative() throws Exception {
		boolean exceptionThrown = false;
		try {
			calc.checkForNegatives(new String[]{"1", "-2"});
		} catch (Exception e) {
			exceptionThrown = true;
			assertFalse(e.getMessage().contains("1"));
			assertTrue(e.getMessage().contains("-2"));
			assertTrue(e.getMessage().contains("negatives not allowed: "));
		}
		assertTrue(exceptionThrown);
	}
	
	@Test
	public void testMultipleNegatives() throws Exception {
		boolean exceptionThrown = false;
		try {
			calc.checkForNegatives(new String[]{"1", "-2", "4", "-12"});
		} catch (Exception e) {
			exceptionThrown = true;
			assertTrue(e.getMessage().contains("-2"));
			assertFalse(e.getMessage().contains("4"));
			assertTrue(e.getMessage().contains("-12"));
			assertTrue(e.getMessage().contains("negatives not allowed: "));
		}
		assertTrue(exceptionThrown);
	}
}
