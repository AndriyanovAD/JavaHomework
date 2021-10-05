package Lesson5;

public class Employee {
    private String name;
    private String secondName;
    private String surname;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public  Employee(String name, String secondName, String surname, String position, String email, String phone, int salary, int age ) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public String getFullData() {
        return getFullName() + "Должность: " + this.position + "; E-mail: " + this.email + "; Телефон: " + this.phone + "; Заработная плата: " + this.salary + "; Возраст:" + this.age;
    }

    public String getFullName() {
        return "ФИО: " + this.name + " " + this.secondName + " " + this.surname + "; ";
    }

    public String getPosition(){
        return position;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public int getSalary(){
        return salary;
    }
    public int getAge(){
        return age;
    }

}
