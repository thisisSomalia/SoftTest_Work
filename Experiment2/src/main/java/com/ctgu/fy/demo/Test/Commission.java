package com.ctgu.fy.demo.Test;

import java.util.Scanner;

public class Commission {
    public static String comTest(int locks, int stocks, int barrels) {
        double lockPrice = 45;
        double stockPrice = 30;
        double barrelPrice = 25;
        double totalLocks = 0;
        double totalStocks = 0;
        double totalBarrels = 0;
        double commission;
        if (locks == -1)
            return "当月销售结束";

        if (locks < 1 || locks > 70) {
            return "枪机不能为负数且小于70";

        }
        if (stocks < 1 || stocks > 80) {
            return "枪托不能为负数且小于80";

        }
        if (barrels < 1 || barrels > 90) {
            return "枪管不能为负数且小于90";

        }

        totalLocks += locks;

        totalStocks += stocks;

        totalBarrels += barrels;

        double locksales = lockPrice * totalLocks;
        double stocksales = stockPrice * totalStocks;
        double barrelsales = barrelPrice * totalBarrels;
        double sales = locksales + stocksales + barrelsales;
        if (sales > 1800) {
            commission = 0.1 * 1000;
            commission += 0.15 * 800;
            commission += 0.2 * (sales - 1800);
        } else if (sales > 1000) {
            commission = 0.1 * 1000;
            commission += 0.15 * (sales - 1000);
        } else commission = 0.1 * sales;
        return String.valueOf(commission);
    }

}
