package com.ctgu.fy.demo.Test;

public class Triangle {

    public static String TriangleTest(int side1, int side2, int side3) {
        if (side1 < 1 || side1 > 100 || side2 < 1 || side2 > 100 || side3 < 1 || side3 > 100)
            return "输入错误";
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
            return "非三角形";
        if (side1 == side2 && side2 == side3)
            return "等边三角形";
        else if (side1 == side2 || side2 == side3 || side1 == side3)
            return "等腰三角形";
        else
            return "一般三角形";
    }


}
