package ba.numerik;

public class Runner {
	public static void main(String[] args) {
		//round up
		System.out.println(NumericOperatons.round(1234.556644, 3));
		//round down
		System.out.println(NumericOperatons.round(1234.556644, 5));
		//0
		System.out.println(NumericOperatons.round(0, 12));
		//precistion 0
		System.out.println(NumericOperatons.round(1234.556644, 0));
	}
}
