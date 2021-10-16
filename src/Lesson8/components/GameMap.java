package Lesson8.components;

import Lesson8.Tools;
import Lesson8.components.AppWindow;
import Lesson8.models.Enemy;
import Lesson8.models.Player;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    private JLabel currentlevel;
    private JLabel currentMapSize;

    private AppWindow appWindow;

    public static final int directionUp = 8;
    public static final int directionLeft = 4;
    public static final int directionRight = 6;
    public static final int directionDown = 2;

    private final int CELL_PLAYER = 1;
    private final int CELL_ENEMY = 2;
    private final int CELL_EMPTY = 0;
    private final int CELL_READY = 99;

    private int[][] room;
    private int[][] invisibleRoom;
    private int roomHeight;
    private int roomWidth;
    private int roomSizeMin = 3;
    private int roomSizeMax = 4;

    private int cellWidth;
    private int cellHeight;

    private boolean isExistMap;
    private boolean isGameStart;

    private int levelGame;

    private Player player;
    private Enemy enemy;

    GameMap(AppWindow appWindow) {
        this.appWindow = appWindow;
        isExistMap = false;
        isGameStart = false;
        setBackground(Color.CYAN);

        currentlevel = new JLabel("Level: -                    ");
        currentMapSize = new JLabel("Размеры карты: " + roomWidth + ":" + roomHeight);
        add(currentlevel, BorderLayout.NORTH);
        add(currentMapSize, BorderLayout.NORTH);
    }

    void startNewGame() {
        player = new Player();
        levelGame = 1;
        createNewLevel();
        isExistMap = true;
        isGameStart = true;
    }

    private void createNewLevel() {
        createRoom();
        spawnPlayer();
        spawnEnemies();
        appWindow.log("You start level " + levelGame);
        appWindow.refreshGuiInfo(this);
        refreshLevelInfo(levelGame);
         repaint();
        ++levelGame;
    }

    private void createRoom() {
        roomWidth = Tools.randomValue(roomSizeMin, this.roomSizeMax);
        roomHeight = Tools.randomValue(roomSizeMin, roomSizeMax);
        refreshMapSize(roomWidth, roomHeight);
        room = new int [roomHeight][roomWidth];
        invisibleRoom = new int [roomHeight][roomWidth];

        for (int y = 0; y < roomHeight; y++) {
            for (int x = 0; x < roomWidth; x++) {
                room[y][x] = CELL_EMPTY;
                invisibleRoom[y][x] = CELL_EMPTY;
            }
        }
    }

    private void spawnPlayer() {
        int x = Tools.randomValue(0, roomWidth - 1);
        int y = Tools.randomValue(0, roomHeight - 1);
        player.setPosition(x,y);
        room[player.getY()][player.getX()] = CELL_PLAYER; // поставить тут "P"
    }

    private void spawnEnemies(){
        enemy = new Enemy((roomWidth + roomHeight) / 2);        ;

        int enemyPosX;
        int enemyPosY;

        for (int i = 1; i <= enemy.getCountEnemies(); i++) {

            do {
                enemyPosX = Tools.random.nextInt(roomWidth); // найти в видео как писали этот код
                enemyPosY = Tools.random.nextInt(roomHeight);
            } while (!isEmptyCell(room, enemyPosX, enemyPosY) || !isEmptyCell(invisibleRoom, enemyPosX, enemyPosY));

            invisibleRoom[enemyPosY][enemyPosX] = CELL_ENEMY;
        }
    }

    private void playerNextMoveAction(int lastPosX, int lastPosY, int nextPosX, int nextPosY) {
        if (invisibleRoom[nextPosY][nextPosX] == CELL_ENEMY) {
            fightingWithEnemy();
            invisibleRoom[nextPosY][nextPosX] = CELL_EMPTY;
        }

        room[player.getY()][player.getX()] = CELL_PLAYER;
        room[lastPosY][lastPosX] = CELL_READY;
    }

    private boolean checkPlayerMove(int currentX, int currentY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < roomWidth && nextY >= 0 && nextY < roomHeight) {
            return true;
        } else {
            appWindow.log("Player - you Invalid! Your move is FAIL! Please try again!");
            player.setPosition(currentX, currentY);

            return false;
        }
    }

    private boolean isEmptyCell(int[][] checkRoom, int x, int y)
    {
        return checkRoom[y][x] == CELL_EMPTY;
    }

    private void fightingWithEnemy() {
        int originalEnemyHP = enemy.getHealth();
                while (player.isAlivePlayer() & enemy.getHealth() > 0) {
            player.decreaseHealth(enemy.getPower());
            appWindow.log("ALERT! Enemy give damage " + enemy.getPower() + ". Player HP now is " + player.getHealth());
            if (player.isAlivePlayer()) {

                this.enemy.decreaseHealth(player.getPower());
                appWindow.log("You hit the enemy and he has HP= " + enemy.getHealth() + "!");
            }
        }
        if (enemy.getHealth() <= 0){
            enemy.killEnemy();
            enemy.setHealth(originalEnemyHP);
            appWindow.log("You win this enemy and have " + enemy.getCountEnemies() + " enemies left on this map . Remember you have HP= " + player.getHealth() + "!");
        }
    }

    Enemy getInfoEnemy() {
        return enemy;
    }

    Player getInfoPlayer() {
        return player;
    }

    void refreshLevelInfo(int x) {
        currentlevel.setText("Level: " + x + "                    ");
    }

    void  refreshMapSize(int x, int y) {
        currentMapSize.setText("Размеры карты: " + x + ":" + y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if(!isExistMap) {
            return;
        }
        paintMap(g);

        for (int y = 0; y < roomHeight; y++){
            for (int x = 0; x < roomWidth; x++) {

                if (room [y][x] == CELL_EMPTY) {
                    continue;
                }

                if (room[y][x] == CELL_PLAYER) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
                if (room[y][x] == CELL_READY) {
                    g.setColor(Color.BLACK);
                    g.drawLine(x * cellWidth, y * cellHeight, (x + 1) *cellWidth, (y + 1) * cellHeight);
                    g.drawLine(x * cellWidth, (y + 1)  * cellHeight, (x + 1) * cellWidth, y * cellHeight);

                }
            }
        }
    }

    void update(int key) {
        if (!isExistMap) {
            return;
        }
        if (!isGameStart) {
            return;
        }
        int currentPlayerX = player.getX();
        int currentPlayerY = player.getY();

        switch (key) {
            case directionUp:
                player.moveUp();
                break;
            case directionDown:
                player.moveDown();
                break;
            case directionLeft:
                player.moveLeft();
                break;
            case directionRight:
                player.moveRight();
                break;
        }
        if (! checkPlayerMove(currentPlayerX, currentPlayerY, player.getX(), player.getY())) {
            return;
        }
        playerNextMoveAction(currentPlayerX, currentPlayerY, player.getX(), player.getY());
        appWindow.refreshGuiInfo(this);
        repaint();


        if (!player.isAlivePlayer()) {
            isGameStart = false;
            JOptionPane.showMessageDialog(this, "Player is DEAD! ====GAME OVER====");
        }

        if (!enemy.isExistEnemies()) {
            createNewLevel();
        }
    }

    private void paintMap(Graphics g) {
        int widthMap = getWidth();
        int heightMap = getHeight();

        cellWidth = widthMap / roomWidth;
        cellHeight = heightMap / roomHeight;

        for (int i = 0; i <= roomHeight; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, widthMap, y);
        }
        for (int i = 0; i <= roomWidth; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, heightMap);
        }
    }
}

