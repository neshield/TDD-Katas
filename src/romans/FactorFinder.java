package romans;

public class FactorFinder {
	private int num;
	//I, V, X, L, C, D, M
	
	private int[] factors = new int[]{1, 5, 10, 50, 100, 500, 1000};
	private int[] factorsAmount = new int[]{0, 0, 0, 0, 0, 0, 0};
	
	public void factor(int num_){
		num = num_;		
		for(int factorIndex = factors.length - 1; factorIndex >= 0; factorIndex--){
			int factorAmount = (int) Math.floor(num/factors[factorIndex]);
			factorsAmount[factorIndex] = factorAmount;
			num -= factorAmount * factors[factorIndex];
		}
	}

	public int[] getFactors(){
		return factorsAmount;
	}
}
