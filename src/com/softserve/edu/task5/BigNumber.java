package com.softserve.edu.task5;

import java.math.BigInteger;
import java.util.Locale;

import com.ibm.icu.text.RuleBasedNumberFormat;

public class BigNumber {

	private boolean sign;
	private BigInteger num;

	public BigInteger getNum() {
		return num;
	}

	public BigNumber() {
		num = BigInteger.ZERO;
		sign = true;
	}

	public BigNumber(String str) {
		if (str.charAt(0) == '-') {
			sign = false;
			str = str.substring(1);
		}
		if (str.length() > 99) {
			throw new IllegalArgumentException();
		} else {
			num = new BigInteger(str);
		}
	}

	@Override
	public String toString() {
		StringBuilder numStr = new StringBuilder(num.toString());
		StringBuilder result = new StringBuilder();
		RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"),
				RuleBasedNumberFormat.SPELLOUT);

		if (numStr.length() < 7) {
			result.insert(0, nf.format(new BigInteger(numStr.toString())));
		} else {
			result.insert(0, nf.format(new BigInteger(numStr.substring(numStr.length() - 6))));
			numStr.delete(numStr.length() - 6, numStr.length());

			for (int i = 0; numStr.length() != 0; i++) {
				if (numStr.length() > 2) {
					result.insert(0, getEndOfWord(numStr.charAt(numStr.length() - 1)) + " ");
					result.insert(0, BigNums.NUMS[i]);
					result.insert(0, nf.format(new BigInteger(numStr.substring(numStr.length() - 3))) + " ");
					numStr.delete(numStr.length() - 3, numStr.length());
				} else {
					result.insert(0, getEndOfWord(numStr.charAt(numStr.length() - 1)) + " ");
					result.insert(0, BigNums.NUMS[i]);
					result.insert(0, nf.format(new BigInteger(numStr.substring(0))) + " ");
					numStr.setLength(0);
				}				
			}
			
		}
		
		if (!sign) {
			result.insert(0, "минус ");
		}
		
		return result.toString();
	}

	private String getEndOfWord(char num) {
		switch (num) {
		case '1': {
			return "";
		}
		case '2':
		case '3':
		case '4': {
			return BigNums.END_WORD_TWO_TO_FOUR;
		}
		default: {
			return BigNums.END_WORD_MORE_THAN_FIVE;
		}
		}
	}

	private static class BigNums {
		public static final String END_WORD_TWO_TO_FOUR = "а";
		public static final String END_WORD_MORE_THAN_FIVE = "ов";

		public static final String[] NUMS = { "миллион", "миллиард", "триллион", "квадриллион", "квинтиллион",
				"секстиллион", "септиллион", "октиллион", "нониллион", "дециллион", "андециллион", "дуодециллион",
				"тредециллион", "кваттордециллион", "квиндециллион", "сексдециллион", "септемдециллион",
				"октодециллион", "новемдециллион", "вигинтиллион", "анвигинтиллион", "дуовигинтиллион",
				"тревигинтиллион", "кватторвигинтиллион", "квинвигинтиллион", "сексвигинтиллион", "септемвигинтиллион",
				"октовигинтиллион", "новемвигинтиллион", "тригинтиллион", "антригинтиллион" };
	}

}
