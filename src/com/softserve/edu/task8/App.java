package com.softserve.edu.task8;

public class App {

	public static void main(String[] args) {
		int first = 0;
		int second = 0;
		Fibonacci nums = new Fibonacci();

		switch (args.length) {
		case 1: {
			try {
				first = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				System.out.println("Wrong number format, need Integer value");
				System.exit(0);
			}

			if (first <= 0 || second <= 0) {
				System.out.println("Parameters must be greater than zero");
				System.exit(0);
			}
			nums = new Fibonacci(first);
			break;
		}
		case 2: {
			try {
				first = Integer.valueOf(args[0]);
				second = Integer.valueOf(args[1]);
			} catch (NumberFormatException e) {
				System.out.println("Wrong number format, need Integer value");
				System.exit(0);

			}

			if (first <= 0 || second <= 0) {
				System.out.println("Parameters must be greater than zero");
				System.exit(0);
			}

			nums = new Fibonacci(first, second);
			break;
		}
		default: {
			System.out.println("There must be one or two parameters");
		}
		}

		System.out.println(nums.toString());
	}

}
