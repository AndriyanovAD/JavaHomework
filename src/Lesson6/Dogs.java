package Lesson6;

public class Dogs extends Animals {
    public static int countDogs = 0;
    static String typeOfClass = "Собака ";
    static int maxRun = 500;
    static int maxSwim = 10;

    Dogs(String name){
     super(typeOfClass, name, maxRun,maxSwim);
     ++countDogs;
    }
}

