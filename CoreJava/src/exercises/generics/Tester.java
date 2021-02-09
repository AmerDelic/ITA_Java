package exercises.generics;

public class Tester {

	public static void main(String[] args) {
		Bank<Visa> visaBank = new Bank<Visa>(new Visa(200));
		Bank<Master> masterBank = new Bank<Master>(new Master(400));
		
		visaBank.pay(0, 22);
		masterBank.pay(0, 100);

	}

}
