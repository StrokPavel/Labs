package laba2;

import java.util.Random;

public final class trader extends person implements polimorf {

    private int money;
    private String type;

    public trader(String name, String surname, String type, int money) {
        super(name, surname);
        this.type = type;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getType() {
        return type;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public void displayInfo() {
        System.out.println("Имя: " + name + ". Фамилия: " + surname
                + "." + " Тип товаров: " + type + ". " + "Начальный капитал: " + money);
    }

    public void sold() {
        Random rand = new Random();
        int i = rand.nextInt(10);
        int price = 15;
        System.out.println("Торговец продал " + i + " единиц товара и получил "
                + i * price + " прибыли.");
        this.money += i * price;
    }

    public void loos() {
        Random rand = new Random();
        int i = rand.nextInt(10);
        System.out.println("Торговец потерял " + i + " единиц товара.");
    }
}