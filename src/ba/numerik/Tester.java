package ba.numerik;

public class Tester {
	public static void main(String[] args) {
		if(args.length < 1){
			double num1 = 1.0014;
			double num2 = 2.0004E+18;
			int prec = 4;
			runCalc(num1, prec);
			System.out.println();
			System.out.println("###############################################################################");
			System.out.println();
			runCalc(num2, prec);
		}else if(args.length >= 2){
			double number;
			int precision;
			try {
				number = Double.valueOf(args[0]);
				try {
					precision = Integer.valueOf(args[1]);
					if(precision < 0){
						System.out.println("Fehler: Die Zahl muss > 0 sein");
						System.exit(1);
					}
					runCalc(number, precision);
				} catch (NumberFormatException e) {
					System.out.println("Fehler: Die Zahl ist kein Integer!");
					System.exit(1);
				}
			} catch (NumberFormatException e) {
				System.out.println("Fehler: Die Zahl ist keine Gleitkommazahl!");
				System.exit(1);
			}
		}else if(args.length == 1){
			System.out.println("Fehler: Zu wenig Argumente!");
			System.exit(1);
		}
		
	}
	
	private static void runCalc(double num, int prec){
		System.out.println("\nAlgorithmus aequivalent zu Y: " + num + ", " + prec + " -------------------------------\n");
		Thema1B.calcLikeY(num, prec);
		System.out.println("\nVerbesserter Algorithmus:------ " + num + ", " + prec + " -------------------------------\n");
		Thema1B.calcImproved(num, prec);
	}

}
