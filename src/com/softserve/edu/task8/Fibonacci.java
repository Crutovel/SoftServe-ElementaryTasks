package com.softserve.edu.task8;

import java.math.BigInteger;

/**
 * 
 * I use the matrix formula to find N fibonacci number F0=0; F1=1;
 *
 * P=|0 1| |1 1|
 * 
 * (F0,F1)*P^n = (Fn Fn+1)
 */
public class Fibonacci {

    private BigInteger[] nums;

    public Fibonacci() {
        nums = new BigInteger[0];
    }

    public Fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        nums = new BigInteger[1];
        nums[0] = Matrix.one.pow(n).get(0, 1);
    }

    public Fibonacci(int begin, int end) {
        if (end < begin || end < 0 || begin < 0) {
            throw new IllegalArgumentException();
        }
        nums = new BigInteger[end - begin + 1];
        Matrix temp = Matrix.one.pow(begin);
        nums[0] = temp.get(0, 1);
        if (begin != end) {
            nums[1] = temp.get(1, 1);
            if (begin + 1 < end) {
                // when i got 2 fib numbers i can continue to make fibonacci
                // sequence by summing
                for (int i = 2; i < end - begin + 1; i++) {
                    nums[i] = sumOfTwo(nums[i - 2], nums[i - 1]);
                }
            }
        }
    }

    public BigInteger[] getNumbers() {
        return nums;
    }

    @Override
    public String toString() {
        if (nums.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < nums.length - 1; i++) {
            result.append(nums[i].toString() + ", ");
        }
        result.append(nums[nums.length - 1]);
        return result.toString();
    }

    private BigInteger sumOfTwo(BigInteger a, BigInteger b) {
        return a.add(b);
    }

}
