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
        } else {
            sign = true;
        }
        if (str.length() > 99) {
            throw new IllegalArgumentException();
        } else {
            num = new BigInteger(str);
        }
    }

    @Override
    public String toString() {
        String nstr = num.toString();
        StringBuilder result = new StringBuilder();
        RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"),
                RuleBasedNumberFormat.SPELLOUT);
        int length = nstr.length();
        int index = 0;
        Integer temp = 0;
        if (num.compareTo(BigInteger.ZERO) == 0) {
            return result.insert(0, nf.format(0)).toString();
        }
        if (length > 6) {
            index = length - 6;
            temp = Integer.valueOf(nstr.substring(index));
            if (temp != 0) {
                result.insert(0, nf.format(temp));
            }
            for (int i = 0; index > 0; i++) {
                index -= 3;
                if (index > 0) {
                    temp = Integer.valueOf(nstr.substring(index, index + 3));
                } else {
                    if (index == -3) {
                        break;
                    } else {
                        temp = Integer.valueOf(nstr.substring(0, index + 3));
                    }
                }
                if (temp != 0) {
                    result.insert(0, getEndOfWord(temp.toString()) + " ");
                    result.insert(0, BigNums.NUMS[i]);
                    result.insert(0, nf.format(temp) + " ");
                }
            }

        } else {
            result.insert(0, nf.format(Integer.valueOf(nstr.toString())));
        }

        if (!sign) {
            result.insert(0, "минус ");
        }

        return result.toString();
    }

    private String getEndOfWord(String str) {

        if (str.length() > 1 && str.charAt(1) == '1') {
            return BigNums.END_WORD_MORE_THAN_FIVE;
        }
        switch (str.charAt(str.length() - 1)) {

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
