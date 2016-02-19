package romans;

public class RomanConverter {
	FactorFinder f;
	NumeralPrinter n;
	
	public RomanConverter(){
		f = new FactorFinder();
		n = new NumeralPrinter();
	}
	
	
	public String printRomans(int num){
		f.factor(num);
		return n.printNumerals(f.getFactors());
	}
}
