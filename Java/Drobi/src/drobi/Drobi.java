package drobi;

public class Drobi {

    static class Fraction {

        protected int numerator; //числитель1
        protected int denominator; //знаменатель1
        protected int n; //числитель2
        protected int d; //знаменатель2

        public Fraction(int a, int b, int n, int d) {
            this.numerator = a;
            this.denominator = b;
            this.n = n;
            this.d = d;
        }
        
        public Fraction(){
            
        }
               

        public boolean Chek() {
            if ((denominator == 0) | (d == 0)) {
                System.out.println("Некорректно введеные данные");
                return false;
            }
            return true;
        }

        void Show() {
            System.out.println("Первая дробь " + numerator + "/" + denominator);
            System.out.println("вторая дробь " + n + "/" + d);
        }

        public void multiplication() {
            if ((numerator == 0) | (n == 0)) {
                System.out.println("Ответ: = 0");
            } else {
                int z = numerator * n;
                int k = denominator * d;
                System.out.println("Ответ = " + z + "/" + k);
            }
        }

        public void division() {
            if ((n == 0)) {
                System.out.println("Некорректный ввод данных.");
            } else if (numerator == 0) {
                System.out.println("Ответ: = 0");
            } else {
                int l = numerator * d;
                int o = denominator * n;
                System.out.println("Ответ = " + l + "/" + o);
            }
        }

        public void summa() {
            if (denominator == d) {     //если знаменатель одинаковый    
                int sum = numerator + n;
                System.out.println("Ответ = " + sum + "/" + d);
            } else {            //если нет, то находим общий знаменатель                                         
                int znam = denominator * d;
                int chisl1 = numerator * d;
                int chisl2 = n * denominator;
                int chisl = chisl1 + chisl2;
                System.out.println("Ответ = " + chisl + "/" + znam);
            }
        }

        public void residual() {
            if (denominator == d) {     //если знаменатель одинаковый    
                int sum = numerator - n;
                System.out.println("Ответ = " + sum + "/" + d);
            } else {            //если нет, то находим общий знаменатель                                         
                int znam = denominator * d;
                int chisl1 = numerator * d;
                int chisl2 = n * denominator;
                int chisl = chisl1 - chisl2;
                System.out.println("Ответ = " + chisl + "/" + znam);
            }
        }
    }

    public static void main(String[] args) {
        Fraction D = new Fraction(1, 5, 1, 4);
        if (D.Chek() == true) {
            D.Show();
            System.out.println("Умножение");
            D.multiplication();
            System.out.println("Деление");
            D.division();
            System.out.println("Сложение");
            D.summa();
            System.out.println("Разность");
            D.residual();
        }
    }
}
