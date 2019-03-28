package oop;

public class Runner {

	public static void main(String[] args) {
		testCounter();

		testCounter7Statements();

		// testModNCounter();

		// testDecrementableCounter();

		// testSeasonCounter();
	}

	
	public static void testCounter() {
		System.out.println("-- testing Counter");

		Counter c = new Counter();
		c.increment();
		System.out.println(c.value());

	}

	
	public static void testCounter7Statements() {
		Counter c = new Counter();
		System.out.println("-- testing 7 statements");
		// include exactly 7 increment() and reset() statements below

		System.out.println("current value: " + c.value());
	}

}
