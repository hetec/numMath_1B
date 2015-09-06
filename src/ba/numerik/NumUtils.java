package ba.numerik;

import static java.lang.Math.abs;
import static java.lang.Math.ceil;
import static java.lang.Math.log;
import static java.lang.Math.pow;
import static java.lang.Math.round;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class NumUtils {
	
	private NumUtils(){}
	
	public static double myRound(double num, long precision){
		if(precision < 0){
			throw new IllegalArgumentException("Precision must not be lower than 0!");
		}
		double exp = (long)Math.floor(Math.log10(num) + 1);
		num *= Math.pow(10, precision-exp);
		num = Math.round(num);
		num /= Math.pow(10, (exp-precision)*-1);
		return num;
	}
	
	public static double relError(double rounded, double unrounded){
		return Math.abs((rounded - unrounded)/unrounded);
	}
}
