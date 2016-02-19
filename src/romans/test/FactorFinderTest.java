package romans.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import romans.FactorFinder;

public class FactorFinderTest {

	FactorFinder f;
	
	@Before
	public void setUp(){
		f = new FactorFinder();
	}
	
	private void factorTest(int num, int[] expectedFactors) {
		f.factor(num);
		int[] returnedFactors = f.getFactors();
		for(int i = 0; i < expectedFactors.length; i++){
			assertEquals(expectedFactors[i], returnedFactors[i]);
		}
	}
	
	@Test
	public void testFactorOne() {
		factorTest(1, new int[]{1});
	}
	
	@Test
	public void testFactorThree() throws Exception {
		factorTest(3, new int[]{3});
	}
	
	@Test
	public void testFactorSeven() throws Exception{
		factorTest(7, new int[]{2,1});
	}
	
	@Test
	public void testFactorFourteen() throws Exception{
		factorTest(14, new int[]{4, 0, 1});
	}
	
	@Test
	public void testFactor99() throws Exception {
		factorTest(99, new int[]{4, 1, 4, 1});
	}
	
	@Test
	public void testFactor499() throws Exception {
		factorTest(499, new int[]{4, 1, 4, 1, 4});		
	}
	
	@Test
	public void testFactor999() throws Exception {
		factorTest(999, new int[]{4, 1, 4, 1, 4, 1});				
	}
	
	@Test
	public void testFactor1999() throws Exception {
		factorTest(1999, new int[]{4, 1, 4, 1, 4, 1, 1});
	}

}
