package com.softserve.edu.task2;

import java.util.Scanner;

public class App {

	public static double parseDouble(String str) {
		str = str.replace(",", ".");
		return Double.valueOf(str);
	}

	public static void main(String[] args) {
		double a = 0, b = 0, c = 0, d = 0;
		String confirm = "";
		String number = "";
		Scanner scanner = new Scanner(System.in);

		for (;;) {

			try {
				System.out.println("Enter a: ");
				number = scanner.next();
				a = parseDouble(number);

				System.out.println("Enter b: ");
				number = scanner.next();
				b = parseDouble(number);

				System.out.println("Enter c: ");
				number = scanner.next();
				c = parseDouble(number);

				System.out.println("Enter d: ");
				number = scanner.next();
				d = parseDouble(number);
			} catch (NumberFormatException e) {
				scanner.close();
				System.out.println("Wrong number format");
				System.exit(0);
			}

			if (a <= 0 || b <= 0 || c <= 0 || d <= 0) {
				scanner.close();
				System.out.println("Parameters must be greater than zero");
				System.exit(0);
			}

			if ((a < c && b < d) || (a < d && b < c) || (c < a && d < b) || (c < b && d < a)) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}

			System.out.println("Do you want to continue?");
			confirm = scanner.next();
			confirm = confirm.toLowerCase();
			switch (confirm) {
			case "y": {
				break;
			}
			case "yes": {
				break;
			}
			default: {
				scanner.close();
				System.out.println("bb");
				System.exit(1);
			}
			}
		}
	}

}
