package ba.numerik;

public class NumericOperatons {
	
	private NumericOperatons(){}
	
	public static double round(double num, long precision){
		if(precision < 0){
			throw new IllegalArgumentException("Precision must not be lower than 0!");
		}
		double rounded = num;
		rounded = num * Math.pow(10, precision);
		rounded = (double)Math.round(rounded);
		double resulte = rounded / Math.pow(10, precision);
		rounded = Math.floor(rounded);
		return resulte;
	}
}
