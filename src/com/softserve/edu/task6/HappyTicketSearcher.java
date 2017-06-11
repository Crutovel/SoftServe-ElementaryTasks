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
            if (getParityNumsSum(i, false) == getParityNumsSum(i, true)) {
                result++;
            }
        }
        return result;
    }

    private int getParityNumsSum(int num, boolean parity) {
        int parityNum = parity?0:1;
      
        int result = 0;
        int digitIndex = 0;
        while (num > 0) {
            if (digitIndex % 2 == parityNum) {
                result += num % 10;
            }
            num = num / 10;
            digitIndex++;
        }
        return result;
    }
}
