package com.h4tiel;

import java.util.Scanner;

public class Main {

    private static int total = 0;

    public static void main(String[] args) {

        System.out.print("Input income: ");
        Scanner scanner = new Scanner(System.in);
        int income = scanner.nextInt();
        int bracket = bracket(income);
        switch (bracket) {
            case 1:
                total = calculateTax(income, 0f);
                break;
            case 2:
                total = calculateTax(income, 0f);
                total += calculateTax(income - 10000, 0.1f);
                break;
            case 3:
                total = calculateTax(income, 0f);
                total += calculateTax(30000 - 10000, 0.1f);
                total += calculateTax(income - 30000 , 0.25f);
                break;
            case 4:
                total = calculateTax(income, 0f);
                total += calculateTax(30000 - 10000, 0.1f);
                total += calculateTax(100000 - 30000, 0.25f);
                total += calculateTax(income - 100000, 0.40f);
                break;
        }

        System.out.println("Total tax: "+ total);
        System.out.println("Total tax: "+ progressiveTaxationOneline(income));
    }

    private static int bracket(int income) {
        int bracket = 0;
        if (income < 10000) {
            bracket = 1;
        } else if (income < 30000) {
            bracket = 2;
        } else if (income < 100000) {
            bracket = 3;
        } else {
            bracket = 4;
        }
        return bracket;
    }

    private static int calculateTax(int amount, float rate) {
        return (int) (amount * rate);
    }

    // u/porofessordad

    public static int taxOwed(int income) {
        int[] caps = {0,10000,30000,100000,Integer.MAX_VALUE};
        double[] rates = {0, 0, 0.10, 0.25, 0.40};
        int tax = 0;

        for (int i=1; i<caps.length-1; i++) {
            if (income <= caps[i]) break;
            tax += Math.floor( (Math.min(income, caps[i+1])- caps[i]) * rates[i+1] );
        }
        return tax;
    }
    // u/Vlatzko
    public static double progressiveTaxationOneline(int amount) {
        return amount > 100_000 ? (amount - 100_000) * 0.40 + progressiveTaxationOneline(100_000)
                : amount > 30_000 ? (amount - 30_000) * 0.25 + progressiveTaxationOneline(30_000)
                : amount > 10_000 ? (amount - 10_000) * 0.1
                : 0;
    }
}