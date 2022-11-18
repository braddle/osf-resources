package com.example.tdd;

public class LeapYearCalculator {
    public boolean isLeapYear(int year) {
        if (isDevisableBy(year, 400)) {
            return true;
        }

        if (isDevisableBy(year, 100)) {
            return false;
        }

        if (isDevisableBy(year, 4)) {
            return true;
        }

        return false;
    }

    private static boolean isDevisableBy(int year, int x) {
        return year % x == 0;
    }
}
