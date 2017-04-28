package gausa;

import java.io.IOException;
import java.util.*;

public class Gausa {

    public static class MX //класс, реализующий работы с матрицей
    {

        int n;   //количество неизвестных матрицы
        double[][] MX;   //двумерный массив, задающий коэффициенты матрицы
        double[] X;     //вектор корней матрицы
        int[] A;
        double norm;
        double norma;
        double b0 = 0.01;
        double b1;
        double eps = 0.001;

        void create() //функция, создающая матрицу
        {
            A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = i;
            }
            X = new double[n];  //освобождается память для вектора корней
            MX = new double[n][n + 1]; //освобождается память под матрицу +1 столбец
            Scanner sc = new Scanner(System.in);  // класс для ввода данных
            System.out.println("Введите расширенную матрицу: ");
            for (int i = 0; i < n; i++) //следующие циклы задают ввод матрицы с клавиатуры
            {
                for (int j = 0; j <= n; j++) {
                    MX[i][j] = sc.nextDouble();
                }
            }
        }

        void print() //функция, выводящая матрицу
        {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    System.out.print(MX[i][j] + " ");
                }
                System.out.println();
            }
        }

        void Obmen2(int j1, int j2) // функция обмна 2-х столбцов
        {
            for (int i = 0; i < n; i++) {
                double k = MX[i][j1];
                MX[i][j1] = MX[i][j2];
                MX[i][j2] = k;
                int k1 = A[j1];
                A[j1] = A[j2];
                A[j2] = k1;
            }

        }

        void Delenie(int i) //выбор главного элемента и деление строки на него
        {
            double max = 0;
            int imax = i, jmax = i;
            for (int k = i; k < n; k++) {
                for (int j = i; j < n; j++) {
                    double mx = MX[k][j];
                    if (mx < 0) {
                        mx = -mx;
                    }
                    if (mx > Math.abs(max)) {
                        max = MX[k][j];
                        imax = k;
                        jmax = j;
                    }
                }
            }
            int j = i;
            Obmen(imax, i);// Меняем строки
            Obmen2(jmax, j);// Меняем столбцы
            for (j = i; j < n + 1; j++) //Делим строку на максимальный элемент
            {
                MX[i][j] /= max;
            }
        }

        void Sum(int i) //Обнуление элементов под [i,i] элементом
        {
            for (int s = 1; s < n - i; s++) {
                double k = -MX[i + s][i];
                for (int j = i; j < n + 1; j++) {
                    MX[i + s][j] = MX[i + s][j] + k * MX[i][j];
                }
            }
        }

        void Sum1(int i) //Обнуление элементов над [i,i] элементом
        {
            for (int s = 1; s <= i; s++) {
                double k = -MX[i - s][i];
                for (int j = i; j < n + 1; j++) {
                    MX[i - s][j] = MX[i - s][j] + k * MX[i][j];
                }
            }
        }

        boolean Treug() //пользуясь имеемыми функциями приводим матрицу к диагональному виду
        {
            for (int i = 0; i < n; i++) {
                Delenie(i);
                print();
                System.out.println();

                if (i != n - 1) {
                    Sum(i);
                }
                if (i != 0) {
                    Sum1(i);
                }
            }
            return true;
        }

        void Obmen(int i1, int i2) //Функция обмена местами двух строк
        {
            for (int j = 0; j < n + 1; j++) {
                double k = MX[i1][j];
                MX[i1][j] = MX[i2][j];
                MX[i2][j] = k;
            }
        }

        void Pkorni() //функция, печатающая корни уравнения на экран
        {
            for (int i = 0; i < n; i++) {
                System.out.println("X" + (i + 1) + " = " + MX[A[i]][n]);
            }
            System.out.println();
        }

        MX() {
        }

        MX(int n) {
            this.n = n;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("введите размер матрицы");
        int n = sc.nextInt();
        MX M = new MX(n); //создается экземпляр матрицы
        M.create();       //матрица заполняется значениями        
        M.Treug();       //приводим к диагональному виду
        M.print();      //выводим саму приведенную матрицу
        M.Pkorni();     //выводим корни системы
    }
}
