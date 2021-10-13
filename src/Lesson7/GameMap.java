package Lesson7;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {
    private JLabel sizeMap;
    GameMap() {
        setBackground(Color.CYAN);

        sizeMap = new JLabel("Размеры карты: -:- ");
        add(sizeMap, BorderLayout.NORTH);


    }
}