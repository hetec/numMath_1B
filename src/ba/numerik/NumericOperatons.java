package ba.numerik;

public class NumericOperatons {
	
	private NumericOperatons(){}
	
	public static double round(double num, long precision){
		if(precision < 0){
			throw new IllegalArgumentException("Precision must not be lower than 0!");
		}
		double exp = Math.pow(10, precision);
		return Math.round(num*exp)/exp;
	}
}
