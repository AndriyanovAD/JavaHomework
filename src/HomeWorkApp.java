// №1
public class HomeWorkApp {

    public static void main(String[] args) {
       printThreeWords();

        System.out.println("*********************");

       if (checkSumSign(12, 0)){
           System.out.println("Сумма отрицательная");
       } else {
           System.out.println("Сумма положительная");
       }
        System.out.println("*********************");
       printcolor(99);

        System.out.println("*********************");

       compareNumbers(35, 25);
         }
// №2
         public static void printThreeWords(){
        System.out.println("_Orange");
        System.out.println("_Banana");
        System.out.println("_Apple");
    }

// №3
    public static boolean checkSumSign(int a, int b) {
        return (a + b) < 0;
    }
// №4
    public static void printcolor(int a) {
        if (a <= 0) {
            System.out.println("Red");
        } else if (a > 100) {
            System.out.println("Green");
        } else {
            System.out.println("Yellow");
        }
    }
// №5
    public static void compareNumbers(int a, int b) {
        if (a < b) {
            System.out.println("a < b");
        } else {
            System.out.println("a >= b");
        }
    }
}



/* 1. Создать пустой проект в IntelliJ IDEA, создать класс HomeWorkApp, и прописать в нем метод main().
// * 2. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple.
// * _Orange
// * _ Banana
// * _ Apple
// * 3. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите.
// * Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0,
// * то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
// * 4. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
// * Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
// * если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
// * если больше 100 (100 исключительно) - “Зеленый”;
// * 5. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b,
// * и инициализируйте их любыми значениями, которыми захотите.
// * Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”;
// * 6. Методы из пунктов 2-5 вызовите из метода main() и посмотрите корректно ли они работают.
// */