package romans.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import romans.RomanConverter;

public class RomanConverterTest {
	RomanConverter r;
	
	@Before
	public void setUp(){
		r = new RomanConverter();
	}
	
	private void testRomans(String expected, int num){
		assertEquals(expected, r.printRomans(num));
	}
	
	@Test
	public void testConverter() throws Exception {
		testRomans("MCMXLIX", 1949);
		testRomans("I", 1);
		testRomans("MMMDCCCLXXXVIII", 3888);
	}

}
