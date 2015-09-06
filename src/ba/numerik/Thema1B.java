package ba.numerik;

import javax.swing.plaf.synth.SynthScrollBarUI;
import javax.swing.text.AbstractDocument.LeafElement;

public class Thema1B {
	public static void main(String[] args) {
		
	}
	
	public static void calcLikeY(double x, int prec){
		double x_rounded = NumUtils.myRound(x, prec);
		double z = x;
		System.out.format("Ohne Runden: %30s%.17E%n","x = ", z);
		System.out.format("Mit Runden: %31s%.17E%n","x = ", x_rounded);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(x_rounded,z));
		System.out.println();
		// --> 1/x
		double frac = NumUtils.myRound(1/x_rounded, prec);
		double fracZ = 1/z;
		System.out.format("Ohne Runden: %30s%.17E%n","frac = 1/x = ", fracZ);
		System.out.format("Mit Runden: %31s%.17E%n","frac = 1/x = ", frac);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(frac, fracZ));
		System.out.println();
		// --> x + 1/x
		double add = NumUtils.myRound((x_rounded+frac), prec);
		double addZ = z + fracZ;
		System.out.format("Ohne Runden: %30s%.17E%n","add = x + frac = ", addZ);
		System.out.format("Mit Runden: %31s%.17E%n","add = x + frac = ", add);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(add, addZ));
		System.out.println();
		// --> x - 1/x
		double sub = NumUtils.myRound((x_rounded-frac), prec);
		double subZ = z - fracZ;
		System.out.format("Ohne Runden: %30s%.17E%n","sub = x - frac = ", subZ);
		System.out.format("Mit Runden: %31s%.17E%n","sub = x - frac = ", sub);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(sub, subZ));
		System.out.println();
		// --> sqrt(x + 1/x)
		double sqrtLeft = NumUtils.myRound((Math.sqrt(add)), prec);
		double sqrtLeftZ = Math.sqrt(addZ);
		System.out.format("Ohne Runden: %30s%.17E%n","sqrtLeft = sqrt(add) = ", sqrtLeftZ);
		System.out.format("Mit Runden: %31s%.17E%n","sqrtLeft = sqrt(add) = ", sqrtLeft);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(sqrtLeft, sqrtLeftZ));
		System.out.println();
		// --> sqrt(x - 1/x)
		double sqrtRight = NumUtils.myRound((Math.sqrt(sub)), prec);
		double sqrtRightZ = Math.sqrt(subZ);
		System.out.format("Ohne Runden: %30s%.17E%n","sqrtRight = sqrt(sub) = ", sqrtRightZ);
		System.out.format("Mit Runden: %31s%.17E%n","sqrtRight = sqrt(sub) = ", sqrtRight);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(sqrtRight, sqrtRightZ));
		System.out.println();
		// --> sqrt(x + 1/x) - sqrt(x - 1/x)
		double y = NumUtils.myRound((sqrtLeft - sqrtRight), prec);
		double y_z = sqrtLeftZ - sqrtRightZ;
		System.out.format("Ohne Runden: %30s%.17E%n","y = sqrtLeft - sqrtRight = ", y_z);
		System.out.format("Mit Runden: %31s%.17E%n","y = sqrtLeft - sqrtRight = ", y);
		System.out.println();
		double relativerFehler = NumUtils.relError(y_z, y);
		System.out.format("Rel. Fehler: %30s%.17f%n","\u0394x/x = ", relativerFehler);
		System.out.format("Rel. Fehler: %30s%.17f%%%n","\u0394x/x = ", relativerFehler*100);
	}
	
	
	public static void calcImproved(double x, int prec){
		double x_rounded = NumUtils.myRound(x, prec);
		double z = x;
		System.out.format("Ohne Runden: %30s%.17E%n","x = ", z);
		System.out.format("Mit Runden: %31s%.17E%n","x = ", x_rounded);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(x_rounded,z));
		System.out.println();
		// --> 1/x
		double frac = NumUtils.myRound(1.0/x_rounded, prec);
		double fracZ = 1.0/z;
		System.out.format("Ohne Runden: %30s%.17E%n","frac = 1/x = ", fracZ);
		System.out.format("Mit Runden: %31s%.17E%n","frac = 1/x = ", frac);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(frac,fracZ));
		System.out.println();
		// --> x + (1 / x)
		double add = NumUtils.myRound((x+frac), prec);
		double addZ = z + fracZ;
		System.out.format("Ohne Runden: %30s%.17E%n","add = x + frac = ", addZ);
		System.out.format("Mit Runden: %31s%.17E%n","add = x + frac = ", add);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(add,addZ));
		System.out.println();
		// --> x - 1;
		double decr = NumUtils.myRound((x_rounded - 1.0), prec);
		double decrZ = z - 1.0;
		System.out.format("Ohne Runden: %30s%.17E%n","decr = x - 1 = ", decrZ);
		System.out.format("Mit Runden: %31s%.17E%n","decr = x - 1 = ", decr);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(decr,decrZ));
		System.out.println();
		// --> x + 1;
		double incr = NumUtils.myRound((x_rounded + 1.0), prec);
		double incrZ = z + 1.0;
		System.out.format("Ohne Runden: %30s%.17E%n","incr = x + 1 = ", incrZ);
		System.out.format("Mit Runden: %31s%.17E%n","incr = x + 1 = ", incr);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(incr,incrZ));
		System.out.println();
		double mult = NumUtils.myRound((decr * incr), prec);
		double multZ = decrZ * incrZ;
		System.out.format("Ohne Runden: %30s%.17E%n","mult = decr * incr = ", multZ);
		System.out.format("Mit Runden: %31s%.17E%n","mult = decr * incr = ", mult);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(mult,multZ));
		System.out.println();
		// --> (x - 1)(x + 1) / x;
		double div = NumUtils.myRound((mult / x_rounded), prec);
		double divZ = multZ / z;
		System.out.format("Ohne Runden: %30s%.17E%n","div = mult/x = ", divZ);
		System.out.format("Mit Runden: %31s%.17E%n","div = mult/x = ", div);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(div,divZ));
		System.out.println();
		// --> sqrt(x + 1 / x)
		double sqrtLeft = NumUtils.myRound((Math.sqrt(add)), prec);
		double sqrtLeftZ = Math.sqrt(addZ);
		System.out.format("Ohne Runden: %30s%.17E%n","sqrtLeft = sqrt(add) = ", sqrtLeftZ);
		System.out.format("Mit Runden: %31s%.17E%n","sqrtLeft = sqrt(add) = ", sqrtLeft);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(sqrtLeft,sqrtLeftZ));
		System.out.println();
		// --> sqrt((x - 1)(x + 1) / x)
		double sqrtRight = NumUtils.myRound(Math.sqrt(div), prec);
		double sqrtRightZ = Math.sqrt(divZ);
		System.out.format("Ohne Runden: %30s%.17E%n","sqrtRight = sqrt(div) = ", sqrtRightZ);
		System.out.format("Mit Runden: %31s%.17E%n","sqrtRight = sqrt(div) = ", sqrtRight);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(sqrtRight,sqrtRightZ));
		System.out.println();
		// --> sqrt(1 + 1 / x) + sqrt((x + 1 / x) + -1 + 2x)
		double sum = NumUtils.myRound(sqrtLeft + sqrtRight, prec);
		double sumZ = sqrtLeftZ + sqrtRightZ;
		System.out.format("Ohne Runden: %30s%.17E%n","sum = sqrtLeft + sqrtRight = ", sumZ);
		System.out.format("Mit Runden: %31s%.17E%n","sum = sqrtLeft + sqrtRight = ", sum);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(sum,sumZ));
		System.out.println();
		// --> x (sqrt(1 + 1 / x) + sqrt((x + 1 / x) + -1 + 2x))
		double multX = NumUtils.myRound(sum * x_rounded, prec);
		double multXZ = sumZ * z;
		System.out.format("Ohne Runden: %30s%.17E%n","multX = x * sum = ", multXZ);
		System.out.format("Mit Runden: %31s%.17E%n","multX = x * sum = ", multXZ);
		System.out.format("Rel. Fehler: %30s%.17E%n","\u0394x/x = ", NumUtils.relError(multX,multXZ));
		System.out.println();
		// --> 2 / sqrt(1 + 1 / x) + sqrt((x + 1 / x) + -1 + 2x)
		double divTwo = NumUtils.myRound(2 / multXZ, prec);
		double divTwoZ = 2.0 / multXZ;
		System.out.format("Ohne Runden: %30s%.17E%n","y = 2 / multX = ", divTwoZ);
		System.out.format("Mit Runden: %31s%.17E%n","y = 2 / multX = ", divTwo);
		double relativerFehler = NumUtils.relError(divTwo, divTwoZ);
		System.out.format("Rel. Fehler: %30s%.17f%n","\u0394x/x = ", relativerFehler);
		System.out.format("Rel. Fehler: %30s%.17f %%%n","\u0394x/x = ", relativerFehler*100);
	}
}
