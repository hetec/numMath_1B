package ba.numerik;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class NumUtils {
	
	private NumUtils(){}
	
	public static double round(double num, long precision){
		if(precision < 0){
			throw new IllegalArgumentException("Precision must not be lower than 0!");
		}
		double exp = (int)Math.floor(Math.log10(num) + 1);
		num *= Math.pow(10, precision-exp);
		num = Math.round(num);
		num /= Math.pow(10, (exp-precision)*-1);
		return num;
	}
}
