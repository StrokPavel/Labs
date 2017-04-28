package madorskii2;

import java.util.Arrays;
import java.util.Scanner;

public class Madorskii2 {

    static double[] diagonalMatrixRun(double[][] arr, int n) {
        double[] x = new double[n];
        double[] ksi = new double[n];
        double[] hi = new double[n];

        ksi[0] = 0;
        hi[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            ksi[i + 1] = arr[i][2] / (arr[i][1] - arr[i][0] * ksi[i]);
            hi[i + 1] = (arr[i][0] * hi[i] - arr[i][3]) / (arr[i][1] - arr[i][0] * ksi[i]);
        }

        x[n - 1] = (arr[n - 1][0] * hi[n - 1] - arr[n - 1][3]) / (arr[n - 1][1] - arr[n - 1][0] * ksi[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            x[i] = (arr[i][2] * x[i + 1]) / (arr[i][1] - arr[i][0] * ksi[i]) + (arr[i][0] * hi[i] - arr[i][3]) / (arr[i][1] - arr[i][0] * ksi[i]);
        }

        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int m = 6;
        double[][] mass = new double[n][m];
      //  double[] temp = new double[n];
      String temp="";
       // while (sc.hasNextDouble()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mass[i][j] = sc.nextDouble();
                }
            }
        //}
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println("");
        }
        temp = Arrays.toString(diagonalMatrixRun(mass, n));
      //  for (int i = 0; i < temp.length; i++) {
            System.out.println(temp + " ");
        //}
    }
}
