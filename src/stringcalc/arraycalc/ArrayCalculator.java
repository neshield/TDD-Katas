package stringcalc.arraycalc;

public class ArrayCalculator {
	public int sumStringArray(String[] nums) {
		if(isEmptyArray(nums)){
			return 0;
		}
		
		int sum = 0;
		for(String num : nums){
			sum += Integer.parseInt(num);
		}
		return sum;
	}

	private boolean isEmptyArray(String[] nums) {
		return nums.length == 1 && nums[0].equals("");
	}
}
