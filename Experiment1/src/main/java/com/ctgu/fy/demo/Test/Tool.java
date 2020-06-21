package com.ctgu.fy.demo.Test;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class Tool {
    public static void main(String[] args) throws Exception{
        int[] sideA = { 1,2, 6, 11,12 };
        int[] sideB = { 1,2, 15, 30, 31};
        int[] sideC = { 0,1, 2, 50, 99, 100,101};
        FileOutputStream fos = new FileOutputStream("三角形健壮性测试用例.csv");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "a", "b", "c", "期望值");
        CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);

        int num = 0;
        for (int a : sideA) {
            for (int b : sideB) {
                for (int c : sideC) {
                    if (a == b && a == 50 || a == c & a == 50 || b == c && b == 50) {
                        csvPrinter.printRecord(++num, a, b, c, Triangle.TriangleTest(a, b, c));
                    }
                }
            }
        }
        csvPrinter.flush();
        csvPrinter.close();
    }

//    public static void main(String[] args) throws Exception{
//        int[] sideA = { 1,2,6,11,12 };
//        int[] sideB = { 1,2, 15, 50, 99, 100,101};
//        int[] sideC = {0,1, 2, 50, 99, 100,101};
//        FileOutputStream fos = new FileOutputStream("三角形最坏健壮性测试.csv");
//        OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
//        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("用例编号", "a", "b", "c", "期望值");
//        CSVPrinter csvPrinter = new CSVPrinter(osw, csvFormat);
//
//        int num = 0;
//        for (int a : sideA) {
//            for (int b : sideB) {
//                for (int c : sideC) {
//
//                        csvPrinter.printRecord(++num, a, b, c, Triangle.TriangleTest(a, b, c));
//
//                }
//            }
//        }
//        csvPrinter.flush();
//        csvPrinter.close();
//    }
}
