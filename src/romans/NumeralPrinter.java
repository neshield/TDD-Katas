package romans;

import java.util.HashMap;
import java.util.Map;

public class NumeralPrinter {
	String[] numerals;
	String[] oddSpecialCase;
	String[] evenSpecialCase;
	Map<Integer, String> specialCases;
	
	public NumeralPrinter(){
		numerals = new String[]{"I", "V", "X", "L", "C", "D", "M"};
		oddSpecialCase = new String[]{"", "IV", "", "XL", "", "CD"};
		evenSpecialCase = new String[]{"", "", "IX", "", "XC", "", "CM"};
		specialCases = new HashMap<Integer, String>();
		specialCases.put(1, "IV");
		specialCases.put(2, "IX");
		specialCases.put(3, "XL");
		specialCases.put(4, "XC");
		specialCases.put(5, "CD");
		specialCases.put(6, "CM");
	}
	
	
	public String printNumerals(int[] factors){
		String ret = "";
		for(int factorsIndex = factors.length -1; factorsIndex >= 0; factorsIndex--){
			ret += getRepeatedNumeralString(factors, factorsIndex);
			ret += applySpecialCases(factors, factorsIndex);
		}
		
		return ret;
	}


	private String applySpecialCases(int[] factors, int factorsIndex) {
		String specialCaseAppend;
		if(factorsIndex % 2 == 0){
			specialCaseAppend = applyEvenIndexSpecialCase(factors, factorsIndex);
		} else {
			specialCaseAppend = applyOddIndexSpecialCase(factors, factorsIndex);
		}
		return specialCaseAppend;
	}


	private String getRepeatedNumeralString(int[] factors, int factorsIndex) {
		String s = "";
		for (int i = 0; i < factors[factorsIndex]; i++) {
			s += numerals[factorsIndex];
		}
		
		return s;
	}


	private String applyOddIndexSpecialCase(int[] factors, int factorsIndex) {
		String s = "";
		if(factors[factorsIndex-1] == 4){
			s = specialCases.get(factorsIndex);
			factors[factorsIndex-1] = 0;
		}
		return s;
	}


	private String applyEvenIndexSpecialCase(int[] factors, int factorsIndex) {
		String s = "";
		if(factorsIndex >= 2 && factors[factorsIndex-1] == 1 && factors [factorsIndex-2] == 4){
			s = specialCases.get(factorsIndex);
			factors[factorsIndex-1] = 0;
			factors[factorsIndex-2] = 0;
		}
		return s;
	}
	
}