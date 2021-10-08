/*
 * Java1. Homework2
 *
 * @author Zhuravlev.k
 * @version 08.10.2021
 */
public class Homework2 {
    public static void main(String[] args) {
        System.out.println(inTwoNum(5,10));
        inPosNeg(-5);
        System.out.println(inTrueFalse(5));
        inStr("Тестовый тест", 5);
        System.out.println(inVisYear(2001));
    }
    static boolean inTwoNum (int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    static void inPosNeg (int a) {
        if (a < 0)
            System.out.println("Negative");
        else System.out.println("Positive");
    }
    static boolean inTrueFalse (int a) {
        return a < 0;
    }
    static void inStr (String str, int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(str);
        }
    }
    static boolean inVisYear(int year) {
        return ((year % 4 == 0) || (!(year % 100 == 0) && (year % 400 == 0)));
    }
}
