package Lesson6;

public class Cats extends Animals {
    public static int countCats = 0;
    static String typeOfClass = "Котейка ";
    static int maxRun = 200;
    static int maxSwim = 0;

    Cats(String name){
        super(typeOfClass, name, maxRun,maxSwim);
        ++countCats;
    }

    @Override
    protected int swimming(int distance){
        return Animals.Swim_None;
    }
}
