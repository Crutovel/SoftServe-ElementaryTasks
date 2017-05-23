package com.softserve.edu.task7;

public class App {

	public static void main(String[] args) {

		int n = 0;

		try {
			n = Integer.valueOf(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Wrong number format, need Integer value");
			System.exit(0);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Enter more parametrs");
			System.exit(0);
		}
		if (n <= 0) {
			System.out.println("Parameters must be greater than zero");
			System.exit(0);
		}

		double max = (double) Math.sqrt(n);
		int trueMax = (int) max;
		if (max == (double) trueMax) {
			trueMax--;
		}

		for (int i = 1; i < trueMax; i++) {
			System.out.print(i + ",");
		}
		System.out.print(trueMax);
	}

}
