package com.tp.tp2;

import java.util.Random;

public class Calculatrice {

    public double[] racinesCarrees(int A, int B) {
        if (A >= B) {
            throw new IllegalArgumentException("A doit être inférieur à B");
        }
        
        int count = B - A + 1;
        double[] results = new double[count];
        for (int i = A, index = 0; i <= B; i++, index++) {
            results[index] = Math.sqrt(i);
        }
        return results;
    }

    public int[][] generateMatrix(int M, int N, int A, int B) {
        if (M <= 0 || N <= 0) {
            throw new IllegalArgumentException("M et N doivent être supérieurs à 0");
        }
        if (A >= B) {
            throw new IllegalArgumentException("A doit être inférieur à B");
        }

        Random rand = new Random();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = A + rand.nextInt(B - A + 1);
            }
        }
        return matrix;
    }
}
