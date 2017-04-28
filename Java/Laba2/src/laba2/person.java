package laba2;

public abstract class person {
    
    protected String name;
    protected String surname;
      
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
    
    public person(String name, String surname){     
        this.name=name;
        this.surname=surname;
    }
    
    public void displayInfo(){
        System.out.println("Имя: " + name + ". Фамилия: " + surname + ".");
    }
    
}