package laba1;

public class Laba1 {

    public static void main(String[] args) {
        StudentsGroup a = new StudentsGroup();
        int i = 1;
        a.AddStudentinGroup("Павел", "Строк", 12);
        a.AddStudentinGroup("Влад", "Петренко", 13);
        a.AddStudentinGroup("Криволь", "Игорь", 11);
        a.ShowAllList();
        System.out.println("--------------------------------------");
        //System.out.println(a.GetStudent(i));
        System.out.println("--------------------------------------");
        a.alphabetSort(a);
        System.out.println("--------------------------------------");
        a.RemoveRegisterOfStudent(i);
        a.ShowAllList();
        System.out.println("Поиск:");
        a.FindByName(a, "Павл");
        System.out.println("--------------------------------------");
        System.out.println(a.GetCount());
    }

}
