package laba1;

import java.util.ArrayList;
import java.util.Collections;

class StudentsGroup {

    ArrayList<Student> group = new ArrayList<Student>();

    public void AddStudentinGroup(String name, String surname, int phone_number) {
        Student a = new Student(name, surname, phone_number);
        group.add(a);

    }

    public String GetStudent(int i) {
        return group.get(i).Name + " " + group.get(i).Surname
                + " " + group.get(i).phone_number;
    }

    public String GetStudentName(int i) {
        return group.get(i).Name + " " + group.get(i).Surname;
    }

    public void RemoveRegisterOfStudent(int i) {
        group.remove(i);
    }

    public int GetCount() {
        System.out.println("number of students");
        return group.size();
    }

    public void ShowAllList() {
        int i = 0;
        System.out.println("All list: ");
        while (i < group.size()) {
            System.out.println(group.get(i).Name + " " + group.get(i).Surname
                    + " " + group.get(i).phone_number);
            i++;
        }
    }

    public void alphabetSort(StudentsGroup b) {
        String[] mass = new String[group.size()];
        ArrayList<String> a = new ArrayList<>();
        for (int j = 0; j < mass.length; j++) {
            mass[j] = b.GetStudent(j);
            a.add(mass[j]);
        }
        Collections.sort(a);
        for (int j = 0; j < mass.length; j++) {
            a.add(mass[j]);
            System.out.println(a.get(j));
        }
    }

    public void FindByName(StudentsGroup a, String Name) {
        int i = 0;
        boolean bool = false;
        int temp = 0;
        while (i < group.size()) {
            if (group.get(i).Name.equals(Name)) {
                temp = i;
                bool =true;

            }
            i++;
        }
        if (bool) {
            System.out.println(a.GetStudent(temp));
        } else {
            System.out.println("Такого нет");
        }
    }

    
}
