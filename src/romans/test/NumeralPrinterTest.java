package romans.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import romans.NumeralPrinter;

public class NumeralPrinterTest {
	NumeralPrinter n;
	String[] numerals = {"I", "V", "X", "L", "C", "D", "M"};
	
	@Before
	public void setUp(){
		n = new NumeralPrinter();
	}
	
	private void testPrinter(String expected, int[] factors){
		assertEquals(expected,n.printNumerals(factors));
	}
	
	@Test
	public void testAllSingleSymbols(){
		testPrinter("I", new int[]{1, 0, 0, 0, 0, 0, 0});
		testPrinter("V", new int[]{0, 1, 0, 0, 0, 0, 0});
		testPrinter("X", new int[]{0, 0, 1, 0, 0, 0, 0});
		testPrinter("L", new int[]{0, 0, 0, 1, 0, 0, 0});
		testPrinter("C", new int[]{0, 0, 0, 0, 1, 0, 0});
		testPrinter("D", new int[]{0, 0, 0, 0, 0, 1, 0});
		testPrinter("M", new int[]{0, 0, 0, 0, 0, 0, 1});
	}
	
	@Test
	public void testPrintOneOfEach() throws Exception {
		testPrinter("MDCLXVI", new int[]{1, 1, 1, 1, 1, 1, 1});
	}
	
	@Test
	public void testPrintManyNoSpecialCase() throws Exception {
		//3888
		testPrinter("MMMDCCCLXXXVIII", new int[]{3, 1, 3, 1, 3, 1, 3});
	}
	
	@Test
	public void testEvenIndexSpecialCases() throws Exception {
		testPrinter("IX", new int[]{4, 1, 0, 0, 0, 0, 0});
		testPrinter("XC", new int[]{0, 0, 4, 1, 0, 0, 0});		
		testPrinter("CM", new int[]{0, 0, 0, 0, 4, 1, 0});		

	}
	
	@Test
	public void testOddIndexSpecialCases() throws Exception {
		testPrinter("IV", new int[]{4, 0, 0, 0, 0, 0, 0});
		testPrinter("XL", new int[]{0, 0, 4, 0, 0, 0, 0});
		testPrinter("CD", new int[]{0, 0, 0, 0, 4, 0, 0});
	}
	
	@Test
	public void test29() throws Exception {
		testPrinter("XXIX", new int[]{4, 1, 2, 0, 0, 0, 0});
	}
	
	@Test
	public void test140() throws Exception {
		testPrinter("CXL", new int[]{0, 0, 4, 0, 1, 0, 0});		
	}
	
	@Test
	public void testOddIndexSpecialCasesTogether() throws Exception {
		//444
		testPrinter("CDXLIV", new int[]{4, 0, 4, 0, 4, 0, 0});
	}
	
	@Test
	public void testEvenIndexSpecialCasesTogether() throws Exception {
		//1999
		testPrinter("MCMXCIX", new int[]{4, 1, 4, 1, 4, 1, 1});		
	}
	
	@Test
	public void test94Endigns() throws Exception {	
		//94
		testPrinter("XCIV", new int[]{4, 0, 4, 1, 0, 0, 0});
		
		//494
		testPrinter("CDXCIV", new int[]{4, 0, 4, 1, 4, 0, 0});

		//994
		testPrinter("CMXCIV", new int[]{4, 0, 4, 1, 4, 1, 0});

		//1494
		testPrinter("MCDXCIV", new int[]{4, 0, 4, 1, 4, 0, 1});

		//1994
		testPrinter("MCMXCIV", new int[]{4, 0, 4, 1, 4, 1, 1});
	}
	
	@Test
	public void testRandomNumbers() throws Exception {
		//3494
		testPrinter("MMMCDXCIV", new int[]{4, 0, 4, 1, 4, 0, 3});
		
		//1042
		testPrinter("MXLII", new int[]{2, 0, 4, 0, 0, 0, 1});
		
		//2159
		testPrinter("MMCLIX", new int[]{4, 1, 0, 1, 1, 0, 2});
		
		//3129
		testPrinter("MMMCXXIX", new int[]{4, 1, 2, 0, 1, 0, 3});

		//1135
		testPrinter("MCXXXV", new int[]{0, 1, 3, 0, 1, 0, 1});
		
		//2173
		testPrinter("MMCLXXIII", new int[]{3, 0, 2, 1, 1, 0, 2});
	}
	
	@Test
	public void testBasic49Endings() throws Exception {
		//49
		testPrinter("XLIX", new int[]{4, 1, 4, 0, 0, 0, 0});
		
		//449
		testPrinter("CDXLIX", new int[]{4, 1, 4, 0, 4, 0, 0});
		
		//949
		testPrinter("CMXLIX", new int[]{4, 1, 4, 0, 4, 1, 0});
		
		//1449
		testPrinter("MCDXLIX", new int[]{4, 1, 4, 0, 4, 0, 1});
		
		//1949
		testPrinter("MCMXLIX", new int[]{4, 1, 4, 0, 4, 1, 1});
	}
}
