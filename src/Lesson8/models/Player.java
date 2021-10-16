package Lesson8.models;

public class Player {


    private int health = 100;
    private int power = 8;
    private int x;
    private int y;

    public Player() {
        this.health = 100;
        this.power = 20;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void decreaseHealth(int value){
        health -= value;
    }

    public boolean isAlivePlayer() {
        return health > 0;
    }

    public void moveUp() {
        this.y -= 1;
    }
    public void moveLeft() {
        this.x -= 1;
    }
    public void moveRight() {
        this.x += 1;
    }
    public void moveDown() {
        this.y += 1;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public String getPosition() {
        return "Player Position: " + (this.x + 1) + ":" + (this.y + 1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

