package me.xfly.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        test("1996-03-01");
    }

    private static void test(String str) {
        int days = date2Int(str);

        if (days < 0) {
            System.out.println("Invalid input");
            return;
        }

        int ans = days % 5;
        if (ans < 3) {
            System.out.println("He is working !");
            return;
        }
        System.out.println("He is having a rest !");
    }

    private static int date2Int(String date) {
        String[] dates = date.split("-");

        if (!isValid(dates)) {
            return -1;
        }

        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);

        return getYearGaps(year,month) + getMonthGaps(month) + day - 1 + 1;
    }

    private static int getMonthGaps(int month) {
        switch (month) {
            default:
                return 0;
            case 2:
                return 31;
            case 3:
                return 59;
            case 4:
                return 90;
            case 5:
                return 120;
            case 6:
                return 151;
            case 7:
                return 181;
            case 8:
                return 212;
            case 9:
                return 243;
            case 10:
                return 273;
            case 11:
                return 304;
            case 12:
                return 334;
        }
    }

    private static int getYearGaps(int year,int month) {
        int yearGaps = (year - 1990) * 365;
        boolean bigThan1992 = year - 1992 >= 0;
        int num = 0;
        if (bigThan1992) {
            num =  (year - 1992) / 4 +1;
            if (month < 2){
                num-=1;
            }
        }

        yearGaps+= num;
        return yearGaps;
    }

    private static boolean isValid(String[] dates) {
        if (dates == null || dates.length < 3 || dates.length > 3) {
            return false;
        }

        if (dates[0].length() < 4) {
            return false;
        }

        int year = Integer.parseInt(dates[0]);

        if (year < 1990) {
            return false;
        }


        if (dates[1].length() != 2) {
            return false;
        }

        int month = Integer.parseInt(dates[1]);

        if (month < 1 || month > 12) {
            return false;
        }

        if (dates[2].length() != 2) {
            return false;
        }

        int day = Integer.parseInt(dates[2]);

        if (day < 1) {
            return false;
        }

        switch (month) {
            case 1:
                ;
            case 3:
                ;
            case 5:
                ;
            case 7:
                ;
            case 8:
                ;
            case 10:
                ;
            case 12:
                if (day > 31) {
                    return false;
                }
                break;
            case 2:
                if (day > 29) {
                    return false;
                }
                if (year % 4 != 0 && day > 28) {
                    return false;
                }
                break;
            case 4:
                ;
            case 6:
                ;
            case 9:
                ;
            case 11:
                if (day > 30) {
                    return false;
                }
                break;
        }


        return true;
    }


}
