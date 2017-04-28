package zadanie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadanie1 {

    static double[][] L;
    static double[][] U;
    static double[][] Q;
    static double[] B;
    static int r;
    static int n;

    static void LU(double[][] A, double[][] L, double[][] U, int r) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < r; j++) {

                L[i][0] = A[i][0];
                U[0][j] = A[0][j] / L[0][0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < r; j++) {
                if (i >= j) {
                    sum = 0;
                    for (int k = 0; k < j; k++) {
                        sum += L[i][k] * U[k][j];
                    }
                    L[i][j] = A[i][j] - sum;
                } else {
                    sum = 0;
                    for (int k = 0; k < i; k++) {
                        sum += L[i][k] * U[k][j];
                        U[i][j] = (A[i][j] - sum) / L[i][i];
                    }
                }
            }
        }
    }

    static void proisv(double[][] A, double[][] B, double[][] R, int r) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < r; k++) {
                    R[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    static void show(double[][] A, int r) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void calc_Y() {
        double Y[] = new double[r];
        Y[0] = B[0] / L[0][0];

        System.out.println("y1 = " + Y[0]);
        for (int i = 1; i < r; i++) {
            double sum = 0;

            for (int k = 0; k < i; k++) {
                sum += L[i][k] * Y[k];
            }
            Y[i] = (B[i] - sum) / L[i][i];
            System.out.println("y" + (i + 1) + " = " + Y[i]);
            sum = 0;
        }
        System.out.println("-------------------------");
        calc_X(Y);
    }

    static void calc_X(double[] Y) {
        double X[] = new double[n];
        X[2] = Y[r - 1] / U[r - 1][r - 1];
        for (int i = 3; i >= 0; i--) {
            double sum = 0;

            for (int k = r - 1; k >= i + 1; k--) {
                sum += U[i][k] * X[k];
            }
            X[i] = (Y[i] - sum) / U[i][i];
            System.out.println("x" + (i + 1) + " = " + X[i]);
            sum = 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner f = new Scanner(new File("text.txt"));
        System.out.println("Введите размер матрицы");
        n = sc.nextInt();
        r = sc.nextInt();
        L = new double[n][r];
        U = new double[n][r];
        Q = new double[n][r];
        B = new double[n];
        double[][] A = new double[n][r];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= r; j++) {
                if (j == r) {
                    B[i] = f.nextDouble();
                } else {
                    A[i][j] = f.nextDouble();
                    L[i][j] = 0;
                    U[i][j] = 0;
                    if (i == j) {
                        U[i][j] = 1;
                    }
                }
            }
        }
        System.out.print("B = ");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
        System.out.println();
        LU(A, L, U, r);
        show(A, r);
        System.out.println("-------------------------");
        show(U, r);
        System.out.println("-------------------------");
        show(L, r);
        proisv(L, U, Q, r);
        System.out.println("-------------------------");
        show(Q, r);
        System.out.println("-------------------------");
        calc_Y();
    }
}
