import java.util.Scanner;
public class RemainderFunc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.print("Please enter the max number:");
		int maxNumber = input.nextInt();

		System.out.print("Please enter a divisor:");
		int divisor = input.nextInt();



		for (int i = 1;i <= maxNumber; i++){
			System.out.println("Num: " + i + "%" + divisor + "=" + (i % divisor));
		}





	}

}
