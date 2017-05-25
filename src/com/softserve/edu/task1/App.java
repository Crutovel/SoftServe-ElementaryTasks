package com.softserve.edu.task1;

public class App {

	public static void main(String[] args) {
		int w = 0, h = 0;
		if (args.length != 2) {
			System.out.println("Enter more parametrs");
			System.exit(0);
		} else {
			try {
				w = Integer.valueOf(args[0]);
				h = Integer.valueOf(args[1]);
			} catch (NumberFormatException e) {
				System.out.println("Wrong number format, need Integer value");
				System.exit(0);
			}
			if (w <= 0 || h <= 0) {
				System.out.println("Parameters must be greater than zero");
				System.exit(0);
			}
			int n = (w * 2 * h) + (h / 2) - 1;
			if (n < 0) {
				System.out.println("Parameters too big");
				System.exit(0);
			}
			System.out.print(makeChessBoard(w, h, n));
		}
	}

	public static char[] makeChessBoard(int w, int h, int n) {
		char[] array = new char[n];
		w *= 2;
		int m = 0;
		for (int i = 0; i < h; i++) {
			for (int k = 1; k < w; k++, m++) {
				if (k % 2 == 0) {
					array[m] = ' ';
				} else {
					array[m] = '*';
				}
			}
			if (m < array.length) {
				array[m] = '\n';
				m++;

				if (i % 2 == 0) {
					array[m] = ' ';
					m++;
				}
			}
		}
		return array;
	}

}
