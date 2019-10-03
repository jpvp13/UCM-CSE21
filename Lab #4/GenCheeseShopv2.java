import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	public static void intro(String[] names, double[]prices, int[] amounts) {
		// Fill-in
		int number = amounts.length;

		System.out.println("We sell " + number + " types of cheeses");
		int j = 0;

		if(number > 0 ) {
			System.out.println("Dalaran Sharp : $1.25 per pound");
			prices[j] = 1.25;
		}
		if(number > 1) {
			System.out.println("Stormwind Brie : $10.0 per pound");
			prices[j+1] = 10.0;
		}
		if(number > 2 ) {
			System.out.println("Alterac Swiss : $40.0 per pound");
			prices[j+2] = 40.0;			
		}

		Random ranGen = new Random(100);

		if (number > 0) {
			for (int i = 3; i < number; i++) {
				names[i] = "Cheese Type " + (char)('A' + i);
				prices[i] = ranGen.nextInt(1000)/100.0;
				amounts[i] = 0;

				System.out.println(names[i] + ": $" + prices[i] + " per pound");
			} 
		}
		return;
	}

	public static void getAmount(Scanner input, String[] names, int[] amounts) {
		// Fill-in

		int number = amounts.length;

		int j = 0;

		System.out.println("Enter the amount of Dalaran Sharp:");
		amounts[j] = input.nextInt();
		System.out.println("Enter the amount of Stormwind Brie:");
		amounts[j+1] = input.nextInt();
		System.out.println("Enter the amount of Alterac Swiss:");
		amounts[j+2] = input.nextInt();

		for (int i = 3; i < number; i++) {
			System.out.println("Enter the amount of " + names[i] + ":");
			amounts[i] = input.nextInt();
		}
		return;

	}

	public static void itemizedList(String[] names, double[]prices, int[] amounts) {
		// Fill-in
		int number = amounts.length;
		int j = 0;
		System.out.println(amounts[j] + " lbs of Dalaran Sharp @ " + prices[j] + " = " + (amounts[j]*prices[j]));
		System.out.println(amounts[j+1] + " lbs of Dalaran Sharp @ " + prices[j+1] + " = " + (amounts[j+1]*prices[j+1]));
		System.out.println(amounts[j+2] + " lbs of Dalaran Sharp @ " + prices[j+2] + " = " + (amounts[j+2]*prices[j+2]));

		for (int i = 3; i < number; i++) {

			System.out.println( amounts[i] + " lbs of " + names[i] + " @ " + prices[i] + " = " + (amounts[i]*prices[i]));
		}
	}

	public static double calcSubTotal(double[] prices, int[] amounts) {
		// Fix
		double subTotal = 0.0;
		int number = amounts.length;

		for (int i = 0; i < number; i++ ) {
			subTotal =  subTotal + (prices[i]*amounts[i]);
		}
		return subTotal;
	}

	public static int discount(double subTotal){
		// Fix
		int dis = 0;

		if (subTotal > 100.0) {
			dis = 25;
		} else if (subTotal > 50){
			dis = 10;
		}

		return dis;
	}

	public static void printTotal(double subTotal, int discount) {

		// Fill-in
		//	int finalPrice = subTotal - discount;
		System.out.println("Sub Total: $"  + subTotal);
		System.out.println("-Discount: $" + discount);
		System.out.println("Total : $" + (subTotal - discount));
	}

	public static void main(String[] args) {

		final int MAXCHEESE = 10;

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		int[] amounts = new int[MAXCHEESE];

		Scanner input = new Scanner(System.in);

		intro(names, prices, amounts);

		getAmount(input, names, amounts);

		double total = calcSubTotal(prices, amounts);

		if (MAXCHEESE > 0) {
			System.out.print("Display the itemized list? (1 for yes) ");
			int itemized = input.nextInt();

			if (itemized == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		System.out.println();

		printTotal(total, discount(total));
	}
}