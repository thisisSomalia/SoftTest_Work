package gradle;

public class TestTriangle {
    public static String classify(int a, int b, int c) {

        if (!((a + b > c) && (a + c > b) && (b + c > a))) {

            return "非三角形";

        } else if (a == b && a == c && b == c) {
            return "等边三角形";
        } else if (a != b && a != c && b != c) {
            return "不等边三角形";
        } else {
            return "等腰三角形";
        }
    }
}
