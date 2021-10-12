package Lesson6;

public class HW6 {
    public static void main(String[] args) {
        String possible = " И это возможно!";
        String impossible = " И это невозможно!";
        String eventName;
        String eventResult;

        Dogs dog1 = new Dogs("Барбос");
        Dogs dog2 = new Dogs("Белка");
        Dogs dog3 = new Dogs("Стрелка");
        Cats cat1 = new Cats("Мурзик");
        Cats cat2 = new Cats("Барсик");
        Cats cat3 = new Cats("Коржик");

        Animals[] allAnimals = new Animals[] {dog1, dog2, dog3, cat1, cat2, cat3};

        int runDistance = 300;
        int swimDistance = 2;

        for (int i = 0; i < allAnimals.length; i++) {
            String nameString = allAnimals[i].getType() + "по имени " + allAnimals[i].getName();
            eventName = " может пробежать максимум на " + allAnimals[i].getMaxRun() + " м. Ему предлагают пробежать " + runDistance + " м.";
           eventResult = (allAnimals[i].running(runDistance))? possible: impossible;
           result(nameString,eventName, runDistance, eventResult);

           int swimResult = allAnimals[i].swimming(swimDistance);
           eventName = " может проплыть максимум " + allAnimals[i].getMaxSwim() + " м. Ему предлагают проплыть " + swimDistance + " м.";
           eventResult = (swimResult == allAnimals[i].Swim_OK)? possible:impossible;
           if (swimResult == allAnimals[i].Swim_None) {
               eventName = " не умеет плавать! Ему предлагают проплыть " + swimDistance + " м. ";
               eventResult = "и это невозможно, так как котики не плавают!";
           }
            result(nameString,eventName, runDistance, eventResult);
            System.out.println("Общее количество животных составляет " + Animals.countAnimal + " шт. Из них собак - " + Dogs.countDogs + " шт., а котиков - " + Cats.countCats + " шт.");
            }
        }
    private static void result(String nameString, String eventName, int distance, String eventResult) {
        System.out.println(nameString + eventName + eventResult);
    }
}


