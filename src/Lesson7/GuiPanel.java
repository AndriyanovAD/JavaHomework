package Lesson7;

import javax.swing.*;
import java.awt.*;

public class GuiPanel extends JPanel {


    private JPanel start;
    private JButton btnStart;


    private JPanel infoGame;
    private JLabel currentLevel;
    private JLabel countEnemy;
    private JLabel enemyHP;
    private JLabel enemyStr;


    private JPanel playerInfo;
    private JLabel playerHP;
    private JLabel playerStr;
    private JLabel playerPosition;

    private JPanel gameCtrl;
    private JButton moveLEFT;
    private JPanel moveY;
    private JButton moveUP;
    private JButton moveDOWN;
    private JButton moveRIGHT;

    private JTextArea gameLog;
    private JScrollPane scrollLogs;

    private JPanel finish;
    private JButton btnExit;
    private JButton btnSave;

    GuiPanel(){
        setLayout(new GridLayout(6, 1));



        setupStart();
        setupInfoGame();
        setupPlayerInfo();
        setupGameCtrl();
        setupGameLog();
        setupFinish();

        constructPanel();
    }

    private void constructPanel() {
        add(start);
        add(infoGame);
        add(playerInfo);
        add(gameCtrl);
        add(scrollLogs);
        add(finish);

    }

    private void setupStart() {

        start = new JPanel();
        start.setLayout(new GridLayout(2, 1));
        btnStart = new JButton("Start New Game");
        Label title = new Label("+++++Запуск игры+++++");

        start.add(title);
        start.add(btnStart);

    }

    private void setupInfoGame() {
        infoGame = new JPanel();
        infoGame.setBackground(Color.darkGray);
        infoGame.setLayout(new GridLayout(5,1));
        currentLevel = new JLabel("Level: - ");
        currentLevel.setForeground(Color.WHITE);
        countEnemy = new JLabel("Количество врагов: - ");
        countEnemy.setForeground(Color.WHITE);
        enemyHP = new JLabel("Enemy HP = - ");
        enemyHP.setForeground(Color.WHITE);
        enemyStr = new JLabel("Enemy Str = - ");
        enemyStr.setForeground(Color.WHITE);
        JLabel titlePanel = new JLabel("=====Game Control=====");
        titlePanel.setForeground(Color.WHITE);


        infoGame.add(titlePanel);
        infoGame.add(currentLevel);
        infoGame.add(countEnemy);
        infoGame.add(enemyHP);
        infoGame.add(enemyStr);
    }

    private void setupPlayerInfo() {
        playerInfo = new JPanel();
        playerInfo.setBackground(Color.lightGray);
        playerInfo.setLayout(new GridLayout(4, 1));
        playerHP = new JLabel("Player HP = - ");
        playerStr = new JLabel("Player Str = - ");
        playerPosition = new JLabel("Player Position -^- ");

        playerInfo.add(new JLabel("=====Player Info====="));
        playerInfo.add(playerHP);
        playerInfo.add(playerStr);
        playerInfo.add(playerPosition);
    }

    private void setupGameCtrl() {
        gameCtrl = new JPanel();
        gameCtrl.setLayout(new GridLayout(1, 3));
        moveLEFT = new JButton("←");
        moveY = new JPanel();
        moveUP = new JButton("↑");
        moveDOWN = new JButton("↓");
        moveRIGHT = new JButton("→");

        moveY.setLayout(new GridLayout(2,1));
        moveY.add(moveUP);
        moveY.add(moveDOWN);

        gameCtrl.add(moveLEFT);
        gameCtrl.add(moveY);
        gameCtrl.add(moveRIGHT);
    }

    private void setupGameLog() {
        gameLog = new JTextArea();
        scrollLogs = new JScrollPane(gameLog);

        gameLog.setLineWrap(true);
    }

    private void setupFinish() {
        finish = new JPanel();
        finish.setLayout(new GridLayout(3,1));
        btnSave = new JButton("Save Game");
        btnExit = new JButton("Exit Game");
        finish.add(new Label("++++Выход из игры++++"));
        finish.add(btnSave);
        finish.add(btnExit);

    }
}
