package Lesson2;
public class HomeWork2 {
    public static void main(String[] args) {
// №1
        compareNumbers(-1, 10);
        System.out.println("*********************");

// №2
        switch (positive_negative(0)) {
            case 0:System.out.println("********************");
                System.out.println("Negative");
                break;
            default:
                System.out.println("Positive");
        }
        System.out.println("*********************");
// №3
        switch (positive_negative(-6)) {
            case 0:
                System.out.println("True");
                break;
            default:
                System.out.println("False");
        }
        System.out.println("*********************");
// №4
                    cycle("Done", 2);
        System.out.println("*********************");
// №5
        System.out.println(leap_year(1700));

    }
// №1
    public static void compareNumbers(int a, int b){
        int c = a + b;
        if (c < 10) {
            System.out.println("False");
        } else if (c > 20) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
// №2 и №3
    public static int positive_negative(int a) {
        return (a < 0)?0:1;
    }
// №4
public static void cycle(String a, int b) {
    for ( int c = b ; c != 0; c --){
        if (b < 0){
            break;
        }
        System.out.println(a);
    }
    }
// №5
    public static boolean leap_year(int a){
        return (a % 400) == 0 | (a % 4) == 0 ^ (a % 100) == 0;
    }
}
/**
 * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
 * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
 * в противном случае – false.
 * 2. Написать метод, которому в качестве параметра передается целое число,
 * метод должен напечатать в консоль, положительное ли число передали или отрицательное.
 * Замечание: ноль считаем положительным числом.
 * 3. Написать метод, которому в качестве параметра передается целое число.
 * Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
 * 4. Написать метод, которому в качестве аргументов передается строка и число,
 * метод должен отпечатать в консоль указанную строку, указанное количество раз;
 * 5.* Написать метод, который определяет, является ли год високосным,
 * и возвращает boolean (високосный - true, не високосный - false).
 * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 */