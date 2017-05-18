package mrnz;

import java.util.Scanner;

public class MRNZ {

    static int N;
    static double[] X;
    static double h;
    static double[] korni;
    static double[] korni2;
    static double[] xi;
    static double[] yi;
    static double[] yi_isk;
    static double[] s;

    static void Y() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter [a,b]:");
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.println("Enter n:");
        N = scanner.nextInt();
        X = new double[N];
        h = (b - a) / N;
        for (int i = 0; i < X.length; i++) {
            X[i] = i * h;
        }
        yi = new double[N];
        for (int i = 0; i < yi.length; i++) {
            yi[i] = f3(X[i]);
        }
    }

    static double f1(double a) { //точное решение
        return Math.pow(Math.E, a);
    }

    static double f2(double a, double b) { //a==t b==s ЯДРО
        if (b <= a) {
            return (b * (a - 1));
        } else {
            return (a * (b - 1));
        }
    }

    static double f3(double a) { // правая часть F(y)
        return Math.pow(Math.E, a) + (1 - Math.E) * a - 1;
    }

    static void isk_y() {
        yi_isk = new double[N];
        for (int i = 0; i < N; i++) {
            yi_isk[i] = (yi[i] * 100 + 0.5) / 100;
        }
    }

    static void prost_itr() {
        double temp = 0;
        double norma = 0;
        s = new double[32];
        xi = new double[N];
        korni = new double[N];
        s[0] = 0.0;
        for (int i = 1; i < N; i++) {
            s[i] = i * (0.03125);
        }
        for (int i = 0; i < N; i++) {
            xi[i] = f1(s[i]);
            System.out.println(Double.toString(xi[i]).replace(".", ","));
        }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp = f2(s[i], s[j]) * 0.03125 * xi[j];
                    korni[i] = xi[i] + 0.8 * (yi_isk[i] - temp) * xi[i];
                    norma = Math.sqrt(Math.pow(f2(s[i], s[j]) * 0.03125 * xi[j] - yi_isk[i], 2) * 0.03125);
                }
            }
    }

    static void metod2() {
        double temp = 0;
        double norma = 0;
        korni2 = new double[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp = f2(s[i], s[j]) * 0.03125 * xi[j];
                    korni2[i] = Math.pow(1 - 0.8 * temp, 2) * xi[i] + 2 * 0.8 * yi_isk[i];
                    norma = Math.sqrt(Math.pow(f2(s[i], s[j]) * 0.03125 * xi[j] - yi_isk[i], 2) * 0.03125);
                }
            }
    }

    public static void main(String[] args) {
        Y();
        isk_y();
        System.out.println("-----------------------------");
        prost_itr();
        System.out.println("-----------------------------");
        metod2();
        for (int i = 0; i < N; i++) {
            System.out.println(Double.toString(korni[i]).replace(".", ","));
        }
        System.out.println("-----------------------------");
        for (int i = 0; i < N; i++) {
            System.out.println(Double.toString(korni2[i]).replace(".", ","));
        }
    }
}
