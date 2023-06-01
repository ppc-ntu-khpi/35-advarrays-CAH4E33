package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class RepeatNumber {

    private int N;
    private int M;

    /**
     * Генерує матрицю розміром N x M і знаходить число, яке найбільше повторюється.
     * Виводить матрицю та результат на екран.
     *
     * @param N кількість рядків матриці
     * @param M кількість стовпців матриці
     */
    public void GenMatAndFindNum(int N, int M) {
        Random random = new Random();
        this.N = N;
        this.M = M;

        int[][] matrix = new int[N][M];

        // Заповнення матриці випадковими числами
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }

        // Виведення матриці на екран
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));

        FindNumber(matrix);
    }

    /**
     * Знаходить число, яке найбільше повторюється у матриці.
     * Виводить результат на екран.
     *
     * @param matrix матриця, в якій шукається число
     */
    private void FindNumber(int[][] matrix){
        Map<Integer, Integer> numberCounts = new HashMap<>();
        int maxCount = 0;
        int mostNum = 0;

        // Підрахунок кількості повторень кожного числа у матриці
        for (int[] row : matrix) {
            for (int num : row) {
                int count = numberCounts.getOrDefault(num, 0);
                numberCounts.put(num, count + 1);
            }
        }

        // Знаходження числа, яке найбільше повторюється
        for (Map.Entry<Integer, Integer> entry : numberCounts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount) {
                maxCount = count;
                mostNum = num;
            }
        }

        System.out.println("Число "+ mostNum + ", яке повторюється найбільшу кількість разів: " + maxCount);
    }
}
