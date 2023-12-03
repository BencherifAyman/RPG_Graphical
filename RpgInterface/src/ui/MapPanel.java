package ui;

import game.Map;
import game.Player;
import game.PlayerCast;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MapPanel extends JPanel {

    static final int cellSize = 24;

    private String[][] mapGrid;

    private Image playerImage;
    private Image monsterImage;
    private Player player;  // Ajout de l'attribut Player

    public MapPanel(Map map) {
        this.mapGrid = map.getMap();
        this.player = new Player("Joueur1", PlayerCast.WARRIOR);

        // Chargement de l'image du joueur
        ImageIcon playerImg = new ImageIcon("C:\\Users\\ayman\\IdeaProjects\\RpgInterface\\link.png");
        this.playerImage = playerImg.getImage();

        // Chargement de l'image du monstre
        ImageIcon monsterImg = new ImageIcon("C:\\Users\\ayman\\IdeaProjects\\RpgInterface\\DemonFighter.png");
        this.monsterImage = monsterImg.getImage();
    }

    public Image getPlayerImage() {
        return this.playerImage;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int CoordX = 200;
        int CoordY = 50;

        for (int row = 0; row < this.mapGrid.length; row++) {
            for (int col = 0; col < this.mapGrid[0].length; col++) {
                Color color;
                switch (this.mapGrid[row][col]) {
                    case "D": color = Color.BLACK; break;
                    case "P": color = Color.CYAN; break;
                    case "S": color = Color.GREEN; break;
                    case "M":
                        // Dessiner l'image du monstre si la case contient "M"
                        g.drawImage(this.monsterImage, CoordX + cellSize * col, CoordY + cellSize * row, null);
                        continue;  // Passe à l'itération suivante de la boucle
                    default: color = Color.RED;
                }
                g.setColor(color);
                g.fillRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);

                // Dessiner l'image du joueur si la case contient "P"
                if ("P".equals(this.mapGrid[row][col])) {
                    g.drawImage(this.getPlayerImage(), CoordX + cellSize * col, CoordY + cellSize * row, null);
                }

                g.setColor(Color.BLACK); // contours
                g.drawRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
            }
        }
        this.requestFocusInWindow();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }

    public void goUp() {
        performMove(-1, 0);
    }

    public void goDown() {
        performMove(1, 0);
    }

    public void goLeft() {
        performMove(0, -1);
    }

    public void goRight() {
        performMove(0, 1);
    }

    private void performMove(int rowOffset, int colOffset) {
        int[] playerCoord = this.getPlayerCoord();
        int x = playerCoord[0];
        int y = playerCoord[1];

        int newX = x + rowOffset;
        int newY = y + colOffset;

        if (newX >= 0 && newX < this.mapGrid.length && newY >= 0 && newY < this.mapGrid[0].length
                && !this.mapGrid[newX][newY].equals("D")) {

            if ("M".equals(this.mapGrid[newX][newY])) {
                // Combat avec le monstre
                int monsterHP = 200;
                double playerDamage = this.player.getDamage();

                // Réduire les points de vie du monstre en fonction des dégâts du joueur
                monsterHP -= playerDamage;

                // Réduire les points de vie du joueur
                double playerHP = this.player.getHP();
                playerHP -= monsterHP;

                // Afficher un message de combat
                JOptionPane.showMessageDialog(this, "Combat !\n\n" +
                        "Vous infligez " + playerDamage + " points de dégâts au monstre.\n" +
                        "Le monstre a maintenant " + monsterHP + " points de vie.\n" +
                        "Vous avez " + playerHP + " points de vie restants.");

                // Si le monstre est vaincu, remplacez la case par une case vide
                if (monsterHP <= 0) {
                    this.mapGrid[newX][newY] = "";
                }

                // Mettez à jour les points de vie du joueur dans l'objet Player
                this.player.setHP(playerHP);
            } else if ("S".equals(this.mapGrid[newX][newY])) {
                JDialog dialog = new JDialog();
                dialog.setTitle("EXIT");
                dialog.setSize(200, 200);
                dialog.setLayout(new BorderLayout());
                JLabel label = new JLabel("Congratulations, you won", SwingConstants.CENTER);
                dialog.add(label, BorderLayout.CENTER);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            } else {
                this.mapGrid[x][y] = "";
                this.mapGrid[newX][newY] = "P";
            }
        }

        this.repaint();
    }

    private int[] getPlayerCoord() {
        int[] coord = new int[2];
        for (int row = 0; row < this.mapGrid.length; row++) {
            for (int col = 0; col < this.mapGrid[0].length; col++) {
                if (Objects.equals(this.mapGrid[row][col], "P")) {
                    coord[0] = row;
                    coord[1] = col;
                }
            }
        }
        return coord;
    }
}
