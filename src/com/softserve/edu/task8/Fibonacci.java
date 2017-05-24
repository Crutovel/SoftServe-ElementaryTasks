package com.softserve.edu.task8;

import java.math.BigInteger;

public class Fibonacci {

	public final static BigInteger[][] ONE = { { BigInteger.ZERO, BigInteger.ONE },
			{ BigInteger.ONE, BigInteger.ONE } };

	private BigInteger[] fNums;

	public Fibonacci() {
		fNums = new BigInteger[0];
	}

	public Fibonacci(int n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		fNums = new BigInteger[1];
		fNums[0] = powMatrix(ONE, n)[0][1];
	}

	public Fibonacci(int begin, int end) {
		if (end < begin || end < 0 || begin < 0) {
			throw new IllegalArgumentException();
		}
		fNums = new BigInteger[end - begin + 1];

		if (begin == end) {
			fNums[0] = powMatrix(ONE, begin)[0][1];
		} else {
			fNums[0] = powMatrix(ONE, begin)[0][1];
			fNums[1] = powMatrix(ONE, begin + 1)[0][1];

			if (begin + 1 < end) {
				for (int i = 2; i < end - begin + 1; i++) {
					fNums[i] = sumOfTwo(fNums[i - 2], fNums[i - 1]);
				}
			}
		}
	}

	public BigInteger[] getNumbers() {
		return fNums;
	}

	@Override
	public String toString() {
		if (fNums.length == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < fNums.length - 1; i++) {
			result.append(fNums[i].toString() + ", ");
		}
		result.append(fNums[fNums.length - 1]);
		return result.toString();
	}

	private BigInteger sumOfTwo(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	private BigInteger[][] multiplyMatrices(BigInteger[][] a, BigInteger[][] b) {
		BigInteger[][] result = {
				{ a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])),
						a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1])) },
				{ a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])),
						a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1])) } };
		return result;
	}

	private BigInteger[][] powMatrix(BigInteger[][] mtrx, int exp) {

		if (exp == 0) {
			return ONE;
		}
		if (exp == 1) {
			return mtrx;
		}
		if (exp == 2) {
			return multiplyMatrices(mtrx, mtrx);
		}
		if (exp % 2 == 1) {
			return multiplyMatrices(ONE, powMatrix(mtrx, exp - 1));
		}

		return powMatrix(powMatrix(mtrx, exp / 2), 2);
	}
}
