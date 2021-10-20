/*
 * Java1. Homework3
 *
 * @author Zhuravlev.k
 * @version 21.10.2021
 */

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    final int SIZE_X = 5; // размер поля по оси X
    final int SIZE_Y = 5; // размер поля по оси Y
    final int TO_WIN = 4; // количество маркеров в линию для победы
    final char SIGN_X = 'X'; // маркер игрока
    final char SIGN_O = 'O'; // маркер компьютера
    final char SIGN_EMPTY = '*'; // маркер свободной клетки
    char[][] table;
    Random random;
    Scanner scanner;

    public static void main(String[] args) {
        new TicTacToe().game();
    }

    TicTacToe() {
        table = new char[SIZE_X][SIZE_Y];
        random = new Random();
        scanner = new Scanner(System.in);
    }

    void game() {
        initTable();
        while (true) {
            printTable();
            turnHuman();
            if (isWin(SIGN_X)) {
                System.out.println("Молодец! Будь у меня чувства я бы расстроился...");
                break;
            }
            if (isTableFull()) {
                System.out.println("Хм, ничья. У меня просто вирус в системе ;-)");
                break;
            }
            turnAi();
            if (isWin(SIGN_O)) {
                System.out.println("Зови меня HAL 9000! Превосходство кремниевой формы жизни очевидно!");
                break;
            }
            if (isTableFull()) {
                System.out.println("Хм, ничья. У меня просто вирус в системе ;-)");
                break;
            }
        }
        printTable();
    }

    // Заполняем поле пустыми маркерами
    void initTable() {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                table[i][j] = SIGN_EMPTY;
            }
        }
    }

    // Рисуем поле
    void printTable() {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                System.out.print(table[j][i] + " ");
            }
            System.out.println();
        }
    }

    // Установка маркера
    void setDot(int x, int y, char dot) {
        table[x][y] = dot;
    }

    // Ход игрока
    void turnHuman() {
        int x, y;
        do {
            System.out.print("Введите координаты: X (от 1 до " + SIZE_X + ") Y (от 1 до " + SIZE_Y + ") ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        setDot(x, y, SIGN_X);
    }

    // Ход ИИ
    void turnAi() {
        // Ищем выигрышный ход компьютера
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setDot(i, j, SIGN_O);
                    if (isWin(SIGN_O)) return;
                    setDot(i, j, SIGN_EMPTY);
                }
            }
        // Проверяем будет ли следующий ход игрока победным
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setDot(i, j, SIGN_X);
                    if (isWin(SIGN_X)) {
                        setDot(i, j, SIGN_O);
                        return;
                    }
                    setDot(i, j, SIGN_EMPTY);
                }
            }
        // Если следующий ход не выигрышный, то ставим на рандомное свободное поле
        int x, y;
        do {
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isCellValid(x, y));
        setDot(x, y, SIGN_O);

    }

    // Проверка свободно ли поле
    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return table [x][y] == SIGN_EMPTY;
    }

    // Проверка на победу
    boolean isWin(char dot) {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (checkLine(i, j, 1, 0,  dot)) return true;  // Проверим линию по х
                if (checkLine(i, j, 1, 1,  dot)) return true;  // Проверим по диагонали х у
                if (checkLine(i, j, 0, 1,  dot)) return true;  // Проверим линию по у
                if (checkLine(i, j, 1, -1, dot)) return true;  // Проверим по диагонали х -у
            }
        }
        return false;
    }

    // Проверка линии
    boolean checkLine(int x, int y, int vx, int vy, char dot) {
        int wayX = x + (TO_WIN - 1) * vx;
        int wayY = y + (TO_WIN - 1) * vy;
        if (wayX < 0 || wayY < 0 || wayX > SIZE_X - 1 || wayY > SIZE_Y - 1) return false;
        for (int i = 0; i < TO_WIN; i++) {
            int itemX = x + i * vx;
            int itemY = y + i * vy;
            if (table[itemX][itemY] != dot) return false;
        }
        return true;
    }

    // Проверка на ничью
    boolean isTableFull() {
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                if (table[i][j] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
