package Lesson8.models;

import Lesson8.Tools;
import javax.tools.Tool;

public class Enemy {

    private int health;
    private int power;
    private int enemyValueMin = 9;
    private int enemyValueMax = 16;

    private int x;
    private int y;

    private int countEnemies;

    public Enemy(int count) {
        this.health = Tools.randomValue(enemyValueMin, enemyValueMax);
        this.power = Tools.randomValue(enemyValueMin, enemyValueMax);
        this.countEnemies = count;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void decreaseHealth(int value){
        health -= value;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public boolean isExistEnemies() {
        return countEnemies > 0;
    }

    public void killEnemy() {
        --countEnemies;
    }


    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }
    public int getCountEnemies() {
        return countEnemies;
    }

    public int setHealth(int a) {
        return health = a;
    }
}
