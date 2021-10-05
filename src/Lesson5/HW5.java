package Lesson5;

public class HW5 {
    public static void main(String[] args) {
        Employee Person1 = new Employee("Акакий","Акакиевич", "Акакьев", "QA", "qwead@mail.ru","89113216565", 300000, 30);
        System.out.println(Person1.getFullData());
        Employee[] allEmployee = {
                Person1,
                new Employee ("Сергей", "Петрович", "Коновалов","Главбух","qweasd@mail.ru", "89113265987", 30000, 45),
                new Employee ("Петр", "Петрович", "Коновалов","Директор","qwe12asd@mail.ru", "89113265987", 300000, 40),
                new Employee ("Ольга", "Петровна", "Коновалова","Дворник","qwe3456asd@mail.ru", "89113262587", 10000, 22),
                new Employee ("Антон", "Петрович", "Варламов","Водитель","qweasdукsdfg@mail.ru", "89119851987", 50000, 80)
        };
        System.out.println("*************");

        getElderEmployee(allEmployee, 40);

    }
    public static void getElderEmployee(Employee[] allEmployee, int age) {
        System.out.println("Сотрудники старше " + age + ":");
        for (int i = 0; i < allEmployee.length; i++) {
            if (allEmployee[i].getAge() > age) {
        System.out.println(allEmployee[i].getFullData());
            }
        }
    }
}
