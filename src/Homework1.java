import java.util.Scanner;
public class Homework1 {
    public static void main(String[] args) {
        System.out.println("------------------------");
        printThreeWords();
        System.out.println("------------------------");
        checkSumSign();
        System.out.println("------------------------");
        printColor();
        System.out.println("------------------------");
        compareNumbers();
        System.out.println("------------------------");
    }

    static void printThreeWords() {
        System.out.println("""
                Orange
                Banana
                Apple""");
    }

    static void checkSumSign() {
        Scanner ia = new Scanner(System.in);
            System.out.print("Введите первое число: ");
        int a = ia.nextInt();
        Scanner ib = new Scanner(System.in);
            System.out.print("Введите второе число: ");
        int b = ib.nextInt();
        int sum = a + b;
            System.out.println("Сумма равна: " + sum);
        System.out.println(sum > 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    static void printColor() {
        Scanner iv = new Scanner(System.in);
            System.out.print("Введите число: ");
        int value = iv.nextInt();
        if (value <= 100 && value > 0){
            System.out.println("Желтый");
        } else if (value <= 0) {
            System.out.println("Красный");
        } else {
            System.out.println("Зеленый");
        }
    }

    static void compareNumbers() {
        Scanner ia = new Scanner(System.in);
            System.out.print("Введите значение числа a: ");
        int a = ia.nextInt();
        Scanner ib = new Scanner(System.in);
            System.out.print("Введите значение числа b: ");
        int b = ib.nextInt();
        System.out.println(a >= b ? "a >= b" : "a < b");
    }
}
