package laba2;

import java.util.Random;

public final class paladin extends person implements polimorf {

    private String rang;
    private int rang_id;

    public paladin(String name, String surname, String rang, int rang_id) {
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

    @Override
    public void displayInfo() {
        System.out.println("Имя: " + name + ". Фамилия: " + surname
                + "." + " Ранг паладина: " + rang + ".");
    }

    public void KillMonsters() {
        Random rand = new Random();
        int i = rand.nextInt(10);
        System.out.println("Паладин победил" + i + " кл-во монстров.");
        this.rang_id += i;
    }
}
