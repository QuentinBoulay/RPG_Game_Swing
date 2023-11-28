package rpg.ui;


import rpg.game.Map;
import rpg.game.Player;
import rpg.game.weapons.Weapon;
import rpg.game.weapons.WeaponStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MapPanel extends JPanel {

    static final int cellSize = 24;

    private int[][] mapGrid;

    private int playerX, playerY;

    private WeaponStore weaponStore;

    private Player player;

    private PlayerInfoPanel playerInfoPanel;

    public MapPanel(Map map, WeaponStore weaponStore, Player player, PlayerInfoPanel playerInfoPanel) {
        this.weaponStore = weaponStore;
        this.player = player;
        this.playerInfoPanel = playerInfoPanel;
        this.mapGrid = map.getMap();
        findPlayerStartPosition();
    }

    void handleKeyPress(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                System.out.println("UP");
                movePlayer(0, -1);
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                movePlayer(0, 1);
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                movePlayer(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                movePlayer(1, 0);
                break;
        }
        repaint();
    }

    private void movePlayer(int dx, int dy) {
        int newX = this.playerX + dx;
        int newY = this.playerY + dy;
        if (newX >= 0 && newX < this.mapGrid[0].length && newY >= 0 && newY < this.mapGrid.length) {
            if (this.mapGrid[newY][newX] != 1) {
                this.playerX = newX;
                this.playerY = newY;

                checkSpecialTile(newX, newY);
            }
        }
    }

    private void findPlayerStartPosition() {
        for (int row = 0; row < mapGrid.length; row++) {
            for (int col = 0; col < mapGrid[row].length; col++) {
                if (mapGrid[row][col] == 2) {
                    this.playerX = col;
                    this.playerY = row;
                    return; // Sortie dès que le joueur est trouvé
                }
            }
        }
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
                    case 1 : color = Color.BLACK; break;
                    case 2 : color = Color.CYAN; break;
                    case 3 : color = Color.GREEN; break;
                    case 4 : color = Color.YELLOW; break;
                    default : color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
                if (this.playerX == col && this.playerY == row) {
                    g.setColor(Color.RED);
                    g.fillOval(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
                }

                g.setColor(Color.BLACK); // contours
                g.drawRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
            }
        }
    }

    private void checkSpecialTile(int x, int y) {
        SwingUtilities.invokeLater(() -> {
            if (this.mapGrid[y][x] == 4) {
                // Gérer l'interaction avec la case d'achat d'arme
                handleWeaponShop();
            } else if (this.mapGrid[y][x] == 3) {
                // Gérer la victoire
                JOptionPane.showMessageDialog(this, "Vous avez gagné !", "Victoire", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
    }

    private void handleWeaponShop() {
        if (this.weaponStore.getWeapons().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Le magasin est vide", "Magasin", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JComboBox choixArme = new JComboBox(this.weaponStore.getWeapons().toArray());
            int option = JOptionPane.showOptionDialog(this, choixArme, "Choisissez une arme", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (option == JOptionPane.OK_OPTION) {
                Weapon selectedWeapon = (Weapon) choixArme.getSelectedItem();
                this.player.buyWeapon(selectedWeapon, this.weaponStore);
                this.player.addWeapon(selectedWeapon);
                playerInfoPanel.updatePlayerInfo();
                System.out.println("Player weapon : " + selectedWeapon);
            }
        }
    }

}
