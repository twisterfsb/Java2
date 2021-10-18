/*
 * Java1. Homework3
 *
 * @author Zhuravlev.k
 * @version 18.10.2021
 */

import java.util.Arrays;

public class Homework3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayChangeValue()));
        System.out.println(Arrays.toString(arrayOneToHundred()));
        System.out.println(Arrays.toString(arrayMultiplyLess6()));
        arrayDiagonal();
        System.out.println(Arrays.toString(arrayInitialValue(7, 777)));
        System.out.println(Arrays.toString(arrayMinMax()));
    }

    static int[] arrayChangeValue() {
        int[] arr = {0, 1, 1, 1, 1, 0, 0, 0, 0, 1};
        for (int i = 0; i < arr.length; i++)
            arr[i] = (arr[i] > 0) ? 0 : 1;
        return arr;
    }

    static int[] arrayOneToHundred() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    static int[] arrayMultiplyLess6() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++)
            arr[i] = arr[i] < 6 ? arr[i] * 2 : arr[i];
        return arr;
    }

    static int[][] arrayDiagonal() {
        int[][] arr = new int[7][7];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, j2 = arr[i].length; j < arr[i].length; j++, j2--) {
                if (i == j || i == (j2 - 1))
                    arr[i][j] = 1;
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        return arr;
    }

    static int[] arrayInitialValue(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = initialValue;
        return arr;
    }

    static int[] arrayMinMax() {
        int[] arr = {5, 145, 1, 322, -54, 2, 16, 8};
        int min = arr[0], max = arr[0];
        for (int i : arr) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        return new int[]{min, max};
    }
}
