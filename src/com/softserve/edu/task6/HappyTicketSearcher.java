package com.softserve.edu.task6;

public class HappyTicketSearcher {

	public int getAllMoskow() {
		int result = 0;
		for (int i = 0; i < 1000; i++) {
			for (int k = 0; k < 1000; k++) {
				if (getNumsSum(i) == getNumsSum(k)) {
					result++;
				}
			}
		}
		return result;
	}

	private int getNumsSum(int num) {
		int result = 0;
		while (num > 0) {
			result += num % 10;
			num = num / 10;
		}
		return result;
	}

	public int getAllPiter() {
		int result = 0;
		for (int i = 0; i < 1000000; i++) {
			if (getParityNumsSum(i, true) == getParityNumsSum(i, false)) {
				result++;
			}
		}
		return result;
	}

	private int getParityNumsSum(int num, boolean parity) {
		int parityNum;
		if (parity) {
			parityNum = 0;
		} else {
			parityNum = 1;
		}
		int result = 0;
		int digit = 0;
		while (num > 0) {
			digit = num % 10;
			if (digit % 2 == parityNum) {
				result += digit;
			}
			num = num / 10;
		}
		return result;
	}
}
