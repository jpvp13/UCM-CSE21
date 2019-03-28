import java.util.Scanner;
public class cheeseShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s, b, sw;
		int i;
		System.out.println("We sell 3 differnt kinds of cheese:");
		System.out.println("Dalaran Sharp: $1.25 per pound");
		System.out.println("Stormwind Brie: $10.00 per pound");
		System.out.println("Alterac Swiss: $40.00 per pound");
		Scanner input = new Scanner(System.in);


		System.out.print("Enter how many pounds of Sharp you'd like: "  );
		s= input.nextInt();
		System.out.print("Enter how many pounds of Brie you'd like: "  );
		b = input.nextInt();
		System.out.print("Enter how many pounds of Swiss you'd like: "  );
		sw = input.nextInt();

		System.out.print("Display the itemized list? (1 for yes) ");
		i = input.nextInt();
		double t1 = (1.25 * s);
		double t2 = (10.00 * b);
		double t3 = (40.00 * sw); 
		double subTotal = (t1 + t2 + t3);
		if (i == 1) {

			System.out.println(s + " lbs of Sharp @ $1.25 per pound = $" + (1.25 * s));

			System.out.println(b + " lbs of brie @ $10.00 per pound = $" + (10.00 * b));

			System.out.println(sw + " lbs of Swiss @ $40.00 per pound = $" + (40.00 * sw));

			System.out.println("SubTotal: $" + subTotal);
		} else if (i < 1 || i > 1) {

			System.out.println("Sub Total: $" + subTotal);
		} 

		if (subTotal >= 50 && subTotal < 100) {
			subTotal = (subTotal - 10.0);
			System.out.println("-Discount: $10.0");
			System.out.println("Total: $" + subTotal);	
		} else if (subTotal >= 100) {
			subTotal = (subTotal - 25.0);
			System.out.println("-Discount: $ 25.0");
			System.out.println("Total: $" + subTotal);	
		}











	}

}
