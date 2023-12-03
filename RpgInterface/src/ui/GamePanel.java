package ui;


import game.Game;
import ui.MapPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {

    private MapPanel mapPanel;
    private PlayerInfoPanel playerInfoPanel;


    public GamePanel(Game game) {
        this.setLayout(new BorderLayout());

        // Add MapPanel to GamePanel
        this.mapPanel = new MapPanel(game.getMap());
        this.add(mapPanel, BorderLayout.NORTH);

        //Add PlayerInfoPanel to GamePanel
        this.playerInfoPanel = new PlayerInfoPanel(game.getPlayer());
        this.add(playerInfoPanel, BorderLayout.SOUTH);

        this.initcomponents();
    }

    private void initcomponents() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.mapPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        mapPanel.goUp();
                        break;
                    case KeyEvent.VK_DOWN:
                        mapPanel.goDown();
                        break;
                    case KeyEvent.VK_LEFT:
                        mapPanel.goLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        mapPanel.goRight();
                        break;
                }
                mapPanel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.mapPanel.setFocusable(true);
        this.mapPanel.requestFocusInWindow();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }


}
