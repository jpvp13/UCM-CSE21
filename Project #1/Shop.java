import java.util.Scanner;
public class Shop {

	//static is chosen because if "final" is used then the variable wont be able to update itself
	static double discount = 0;         //Both of these variables keep track of discount which
	static double discountRate = 0;     // is required to calculate total prices at the end.
	//These are global variables so that all methods are able to receive this information

	// I. SetUp Shop
	public static int setUpShop(Scanner input, double [] price, String[]name) {

		//1. Asking for the number of items to sell
		//
		System.out.println("Please enter the number of items:");
		int totalItems = input.nextInt();


		//
		//2.Asking for name and price of item
		for (int index = 0 ; index < totalItems; index++) {   //for loop needed to loop these print statements until desired index is achieved
			System.out.println("Enter name of product " + index + ":");
			name[index] = input.next(); //gets name and is assigned to correlated index

			System.out.println("Enter price of product " + index + ":");
			price[index] = input.nextDouble(); // gets price and is assigned to correlated index

		}

		/*3.these next lines calculate discount
		 * a. entering price and name
		 */
		System.out.println("Please enter the amount to qualify for discount: ");
		discount = input.nextInt();// this number is used to calculate after how many units can a discount be assigned

		System.out.println("Please enter the discount rate (0.1 for 10%):");
		discountRate = input.nextDouble();// this is at which rate the rate will be calculated at


		return totalItems; 
		//
		//4. Check in main() for updating setUp
	}

	//II. Buy Items, for 1. Check main()
	public static void buyShop(Scanner input, String [] name, int totalItems, int [] amount, double [] price) {


		for(int index = 0; index < totalItems; index++) {

			System.out.print("Enter the amount of " + name[index] + ":");
			amount[index] = input.nextShort(); //2. How many things they want to purchase
		}
		/* 3. For each item purchased (non-zero amount)
		a. Display amount purchase and price per item */
	}
	//III. List of Items, for 3. check main()
	public static void listShop(int [] amount, String[]name, double [] price, Scanner input,int totalItems) {
		//3. displays each item purchased that is a non zero amount
		for(int index = 0; index <= totalItems; index++) {
			if(amount[index] > 0){
				double totalCost = (price[index]*amount[index]);
				System.out.print(amount[index] + " count of " + name[index] + " @ ");		//a. Displays amount purchased and price per item
				System.out.println(price[index] + " = $" + (totalCost));
			}
		} 
	}
	//IV. Check Out, for 1. and 2. check main()
	public static void checkOutShop(int totalItems,int[] amount,double [] price) {
		//total calculation
		double total = 0;
		for(int index = 0; index <= totalItems; index++ ){
			total = (price[index] * amount[index] + total); // this loop will calculate the entire total of the buyers entire order because of the loop will iterate as many times as there is items
		}
		//discount calculation
		double disc = 0;
		disc = (total*(discountRate));

		//3. Display Summary
		if (total >= discount) { //if the total amount is greater than the discount required amount, then discount is applied if not, no discount applied
			System.out.println();
			System.out.println("Thanks for coming!");   
			System.out.println("Sub Total:" + total);	//a.subtotal
			System.out.println("-Discount:" + (disc));	//b. discount
			System.out.println("Total    :" + (total - (disc))); //c. total
		} else if (total < discount) {
			System.out.println();
			System.out.println("Thanks for coming!");
			System.out.println("Sub Total:" + total);  //a.subtotal
			System.out.println("-Discount:" + "0.0"); // b. discount ,     0.0 displays because not enough items were purchased in order to qualify for a discount
			System.out.println("Total    :" + (total));  //c. total
		}


	}

	public static void main(String[] args) {

		final int MAX = 1000;   //to allow enough space in the array for any amount of items

		int choice = 0;

		int setNumber = 0;     // set represents which question has been previously completed
		int buy = 0;
		int totalItems = 0;    // represents how many things are being sold

		int [] amount = new int[MAX];
		double [] price = new double[MAX];
		String [] name = new String[MAX];


		do {
			Scanner input = new Scanner(System.in);
			System.out.println("This program supports 4 functions:");
			System.out.println("   1. Setup Shop");
			System.out.println("   2. Buy");
			System.out.println("   3. List Items");
			System.out.println("   4. Checkout");
			System.out.println("PLease choose the function you want:");
			choice = input.nextInt();


			if(1 >= choice || choice <= 4) { //is set to these limits so that the numbers are in between
				/*
				 * I.
				 * 4.User can run setup multiple times so keep the latest version
				 */
				if (choice == 1) {
					if(setNumber == 0 || setNumber == 1) {
						totalItems = setUpShop(input, price, name);  //setUpShop initialized to totalItems to allow other methods to know the total amount of items
					}
					setNumber = 1; //reinitializes setNumber so that when program moves on, next step can be reached, unless previous step was not completed
				}

				if(choice == 2){
					if (setNumber == 1){
						System.out.println();
						buyShop(input, name, totalItems, amount, price);
						System.out.println();
						buy = 1;
					} else {
						System.out.println();
						System.out.println("Shop is not setup yet!");	//II.Buy Items
						System.out.println();							//2.This section tells the user that they haven't bought anything yet

						//this tells customers that the shop hasn't been set up yet and needs to be set up first
					}

				}

				if (choice == 3) {				 
					if(setNumber == 0) {
						System.out.println();							//III.List of Items
						System.out.println("Shop is not setup yet!");	// 1. Lets know they need to set up shop
						System.out.println();

					} 
					if (setNumber == 1 && buy == 0){
						System.out.println();											//III. List of Items
						System.out.println("Try again: You have not bought anything");	//2. lets them know they haven't bought anything
						System.out.println();

					}
					if(buy == 1) {

						System.out.println();
						listShop(amount, name, price, input,totalItems);
						System.out.println();
						// this section lets the user know that they haven't setup shop yet and should do it first
					}
				}

				if(choice == 4 ) {
					if(setNumber == 0) {
						System.out.println();							//IV Check out
						System.out.println("Shop is not setup yet!");	//1. This section lets the user know that they haven't setup shop yet and should do it first
						System.out.println();

					} 
					if(buy == 0){
						System.out.println();											//IV Check out
						System.out.println("Try again: You have not bought anthing");		//2. lets user know that they haven't bought anything
						System.out.println();
						System.out.println();
					}
					if(buy == 1) {
						checkOutShop(totalItems, amount, price);
						break;
					}
				}

				else if(choice < 0  || choice > 4 || choice == 0) {
					System.out.println();
					System.out.println("Error: Do not know " + choice);
					System.out.println();
					//4.end of program 
				}

			} 
		} while (true);

	}
}