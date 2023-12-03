package ui;

import game.Player;

import javax.swing.*;
import java.awt.*;


public class PlayerInfoPanel extends JPanel{
    private Player player;
    private static JLabel d;

    public PlayerInfoPanel(Player player) {
        this.player = player;
        this.setLayout(new GridLayout(5, 5));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        System.out.println(player.infoPlayer());
        d = new JLabel(player.infoPlayer());
        this.add(d);

    }




}
