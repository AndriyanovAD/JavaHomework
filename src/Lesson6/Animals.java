package Lesson6;

public class Animals {
    static final int Swim_OK = 1;
    static final int Swim_Fail = 0;
    static final int Swim_None = -1;
    private String type;
    private String name;
    private int maxRun;
    private int maxSwim;

    public static int countAnimal = 0;

Animals(String type, String name, int maxRun, int maxSwim){
    this.type = type;
    this.name = name;
    this.maxRun = maxRun;
    this.maxSwim = maxSwim;
    ++countAnimal;
}

    String getName() {
        return this.name;
    }
    String getType() {
        return this.type;
    }
    int getMaxRun() {
        return this.maxRun;
    }
    int getMaxSwim() {
        return this.maxSwim;
    }

    protected boolean running(int distance) {
    return (distance <= maxRun);
    }

    protected int swimming(int distance) {
        return (distance <= maxSwim)? Swim_OK: Swim_Fail;
    }

//    public static void main(String[] args) {
//
//    }
}
