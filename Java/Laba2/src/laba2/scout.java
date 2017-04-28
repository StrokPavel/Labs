package laba2;

import java.util.Random;

public final class scout extends person implements polimorf {

    private String rang;
    private int rang_id;

    public scout(String name, String surname, String rang, int rang_id) {
        super(name, surname);
        this.rang = rang;
        this.rang_id = rang_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRang() {
        return rang;
    }

    public int getRang_id() {
        return rang_id;
    }

    @Override
    public void displayInfo() {
        System.out.println("Имя: " + name + ". Фамилия: " + surname
                + "." + " Звание разведчика: " + rang + ".");
    }

    public void KillMonsters() {
        Random rand = new Random();
        int i = rand.nextInt(10);
        System.out.println("Разведчик победил" + i + " кл-во монстров.");
        this.rang_id += i;
    }
}
