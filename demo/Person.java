package demo;

public class Person{
    String name;
    int age;
    String phone, email;
    public void getPerson(String name, int age, String phone, String email){
        this.name=name;
        this.age=age;
        this.phone= phone;
        this.email= email;
    }
    public void showPerson(){
        System.out.println(name+" "+age+" "+phone+" "+email);
    }
}