package laba1;

public class Student {

    protected String Name;
    protected String Surname;
    protected int phone_number;

    public Student() {
    }

    public Student(String a, String b, int phone) {
        Name = a;
        Surname = b;
        phone_number = phone;
    }

    public void ChangeName(Student student, String name) {
        student.Name = name;
    }

    public void ChangeSurname(Student student, String surname) {
        student.Surname = surname;
    }
}
