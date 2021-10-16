package Lesson8.components;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AppWindow extends JFrame {
    private int winWidth = 1024;
    private int winHeight = 768;
    private int winPositionX = 450;
    private int winPositionY = 150;
    URL iconURL = getClass().getResource("icon1.png");
    private ImageIcon icon = new ImageIcon(iconURL);

    private GameMap map;
    private GuiPanel guiPanel;
    AppWindow() {
        setUpWindow();

        guiPanel = new GuiPanel(this);
        map = new GameMap(this);


        add(guiPanel, BorderLayout.EAST);
        add(map);

        setVisible(true);
    }
    private void setUpWindow() {
        setIconImage(icon.getImage());
        setTitle("GuiApplication");
        setLocation(winPositionX, winPositionY);
        setSize(winWidth, winHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    void log(String msg) {
        guiPanel.recordLog(msg);
    }

    void refreshGuiInfo(GameMap map) {
        guiPanel.refreshGui(map);
    }

    void startSession() {
        map.startNewGame();
    }

    void changePosition(int key) {
        map.update(key);
    }
}
