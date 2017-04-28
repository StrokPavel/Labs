package laba2;
    
public class Laba2 {

    public static void main(String[] args) {
        trader a = new trader("Лол", "Кек", "Чебурек", 30);
        System.out.println("Имя " + a.getName());
        System.out.println("Фамилия " + a.getSurname());
        System.out.println("Товар " + a.getType());
        System.out.println("Начальный капитал " + a.getMoney());
        a.displayInfo();
        a.loos();
        a.sold();
        System.out.println("Капитал после продажи " + a.getMoney());
    }
    
}
