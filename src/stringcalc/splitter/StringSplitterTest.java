package stringcalc.splitter;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class StringSplitterTest {
	StringSplitter ss;
	@Before
	public void getCalc(){
		ss = new StringSplitter();
	}
	
/*	private boolean strArraysAreEqual(String[] ret, String[] exp){
		if(ret == null || exp == null){
			return false;
		}
		
		if(ret.length != exp.length){
			return false;
		}
		for(String resS : ret){
			for(String)
		}
		return true;
	}*/
	
	@Test
	public void testSplitEmptyString() {
		assertTrue(Arrays.equals(ss.splitString("", null), new String[]{""}));
	}
	
	@Test
	public void testSplitCommaString(){
		assertTrue(Arrays.equals(ss.splitString("a,2,c,4", ","), new String[]{"a", "2", "c", "4"}));
	}
	
	@Test
	public void testSplitColonString(){
		assertTrue(Arrays.equals(ss.splitString("b:c:d", ":"), new String[]{"b", "c", "d"}));
	}
	
	@Test
	public void testSplitCommaNewlineString(){
		assertTrue(Arrays.equals(ss.splitString("a\n2,c\n4", ","), new String[]{"a", "2", "c", "4"}));
	}
	
	@Test
	public void testGetDelimeterSemicolon(){
		assertTrue(ss.getDelimeter("//;\n1;2").equals(";"));
	}
	
	@Test
	public void testGetDelimeterSlash(){
		assertTrue(ss.getDelimeter("///\n1;2").equals("/"));
	}
	
	@Test
	public void testProcessAndSplit1And2Semicolon(){
		assertTrue(Arrays.equals(ss.processAndSplitString("//;\n1;2"), new String[]{"1", "2"}));
	}
	
	@Test
	public void testProcessAndSplitMultiApostrophe(){
		assertTrue(Arrays.equals(ss.processAndSplitString("//'\n1'-2'-4'10"), new String[]{"1", "-2", "-4", "10"}));
	}
}
