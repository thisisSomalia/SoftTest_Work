package com.ctgu.fy.demo.Test;


public class NextDate {
    public static String nextDate(int year, int month, int day) {
        int nextYear = year, nextMonth = month, nextDay = day;
        if (day < 1 || day > 31) {
            return "Value of day not in the range 1..31";
        }
        if (month < 1 || month > 12) {
            return "Value of month not in the range 1..12";
        }
        if (year < 1900 || year >= 2051) {
            return "Value of year not in the range 1900..2050";
        }
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10: {
                if (day < 31)
                    nextDay = day + 1;
                else {
                    nextDay = 1;
                    nextMonth = month + 1;
                }
                return nextYear + "年" + nextMonth + "月" + nextDay + "日";
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                if (day < 30)
                    nextDay = day + 1;
                else {
                    if (day == 30) {
                        nextDay = 1;
                        nextMonth = month + 1;
                    } else {
                        return "Invalid input date";
                    }
                }
                return nextYear + "年" + nextMonth + "月" + nextDay + "日";

            }
            case 12: {
                if (day <31)
                    nextDay = day + 1;
                else {
                    nextDay = 1;
                    nextMonth = 1;
                    if (year == 2050) {
                        return "Invalid input date";
                    } else {
                        nextYear = year + 1;
                    }
                }
                return nextYear + "年" + nextMonth + "月" + nextDay + "日";
            }
            case 2: {
               if(isLeapYeay(year)){
                   if(day<=28){
                       nextDay=day+1;
                   }
                   else if(day==29){
                       nextDay=1;
                       nextMonth =month + 1;
                   }
                   else {
                       return "Invalid input date";
                   }
               }
               else {
                   if(day<=27){
                       nextDay =day + 1;
                   }
                   else if (day == 28){
                       nextDay =1;
                       nextMonth =month + 1;
                   }
                   else {
                       return "Invalid input date";
                   }
               }
                return nextYear + "年" + nextMonth + "月" + nextDay + "日";
            }
            default:
                return nextYear + "年" + nextMonth + "月" + nextDay + "日";

        }

    }

    public static boolean isLeapYeay(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

}
