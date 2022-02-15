import java.util.Scanner;
import java.util.Random;

public class Lab2 {
    // Функція отримання даних користувача:
    public static int user_input(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        if (input.hasNextInt()) {
            int m = input.nextInt();
            if (m > 0) return m;
        }
        return user_input("Некоректний ввід! Введіть ціле число > 0: ");
    }

    // Функція створення матриць:
    public static short[][] create(int rows, int columns) {
        short[][] matrix = new short[rows][columns];
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (short) (rand.nextInt(199) - 99);
            }
        }
        return matrix;
    }

    // Функція виводу матриць:
    public static void print(String message, short[][] matrix, int rows, int columns) {
        System.out.println();
        System.out.println(message);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((matrix[i][j] + "").length() < 2) System.out.print("  " + matrix[i][j] + " ");
                else if ((matrix[i][j] + "").length() < 3) System.out.print(" " + matrix[i][j] + " ");
                else System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Початкові дані за варіантом 1108:
        System.out.println("C5 = " + 1108 % 5 + " -> C = A ⊕ B");
        System.out.println("C7 = " + 1108 % 7 + " -> type short");
        System.out.println("C11 = " + 1108 % 11 + " -> середнє значення кожного рядка матриці");
        // Ввід розмірів матриць:
        int m = user_input("Введіть кількість рядків > 0 матриці A: ");
        int n = user_input("Введіть кількість стовпців > 0 матриці A: ");
        int m1 = user_input("Введіть кількість рядків > 0 матриці B: ");
        int n1 = user_input("Введіть кількість стовпців > 0 матриці B: ");
        // Генерація матриць і їх вивід:
        short[][] matrix_a = create(m, n);
        short[][] matrix_b = create(m1, n1);
        print("Матриця А:", matrix_a, m, n);
        print("Матриця B:", matrix_b, m1, n1);
        short[][] matrix_c = new short[m + m1][n + n1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix_c[i][j] = matrix_a[i][j];
            }
        }
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matrix_c[i + m][j + n] = matrix_b[i][j];
            }
        }
        print("Матриця С:", matrix_c, m + m1, n + n1);
        System.out.println();
        for (int i = 0; i < m + m1; i++) {
            float sum = 0;
            for (int j = 0; j < n + n1; j++) {
                sum += matrix_c[i][j];
            }
            System.out.println("Середнє значення рядка " + i + " - " + sum / (n + n1));
        }
    }
}

