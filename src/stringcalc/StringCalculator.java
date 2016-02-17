package stringcalc;

import stringcalc.arraycalc.ArrayCalculator;
import stringcalc.splitter.StringSplitter;

public class StringCalculator {
	ArrayCalculator arrCalc = new ArrayCalculator();
	StringSplitter strSplitter = new StringSplitter();
	
	public int add(String s) throws Exception{
		String[] nums = strSplitter.processAndSplitString(s);
		checkForNegatives(nums);
		return arrCalc.sumStringArray(nums);	
	}
	
	public void checkForNegatives(String[] nums) throws Exception{
		String exceptionMessage = "negatives not allowed: ";
		boolean negativeFound = false;
		for(String num : nums){
			if(num.length() == 0 ){
				continue;
			}
			int i = Integer.parseInt(num);
			if(i < 0){
				negativeFound = true;
				exceptionMessage += num + ", ";
			}
		}
		
		if(negativeFound){
			throw new Exception(exceptionMessage);
		}
	}

}
