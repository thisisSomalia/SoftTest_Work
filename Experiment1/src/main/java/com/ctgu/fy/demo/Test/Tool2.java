package com.ctgu.fy.demo.Test;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;


public class Tool2 {
    public static void main(String[] args) throws IOException {
//        int[] sideA = {1, 2, 35, 69, 70};
//        int[] sideB = {1, 2, 40, 79, 80};
//        int[] sideC = {1, 2, 45, 89, 90};
//        FileOutputStream fos = new FileOutputStream("commission边界值测试用例.csv");
//        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
//        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "a", "b", "c", "期望值");
//        CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);
//
//        int num = 0;
//        for (int value : sideA) {
//            csvPrinter.printRecord(++num, value, 40, 45, Commission.comTest(value, 40, 45));
//        }
//        for (int value : sideB) {
//            csvPrinter.printRecord(++num, 35, value,45, Commission.comTest(35, value, 45));
//        }
//        for (int value : sideC) {
//            csvPrinter.printRecord(++num, 35, 40, value, Commission.comTest(35, 40, value));
//        }
//        csvPrinter.flush();
//        csvPrinter.close();

        int[] sideA = {0,1, 2, 35, 69, 70,71};
        int[] sideB = {0,1, 2, 40, 79, 80,81};
        int[] sideC = {0,1, 2, 45, 89, 90,91};
        FileOutputStream fos = new FileOutputStream("commission最坏健壮性测试用例.csv");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "a", "b", "c", "期望值");
        CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

        int num = 0;
        for (int i = 0; i < sideA.length; i++) {
            for (int j = 0; j < sideB.length; j++) {
                for (int k = 0; k < sideC.length; k++) {
                    csvPrinter.printRecord(++num,sideA[i],sideB[j],sideC[k],Commission.comTest(sideA[i],sideB[j],sideC[k]));
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }
}
