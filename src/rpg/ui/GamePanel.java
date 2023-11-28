package rpg.ui;


import rpg.game.Game;
import rpg.game.Player;
import rpg.game.weapons.WeaponStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private MapPanel mapPanel;
    private PlayerInfoPanel playerInfoPanel;
    private WeaponStore weaponStore;

    private Player player;

    public GamePanel(Game game, WeaponStore weaponStore, Player player) {
        this.player = player;
        this.weaponStore = weaponStore;
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        // Ajouter PlayerInfoPanel
        this.playerInfoPanel = new PlayerInfoPanel(game.getPlayer());

        // Ajouter MapPanel
        this.mapPanel = new MapPanel(game.getMap(), this.weaponStore, this.player, this.playerInfoPanel);
        this.add(mapPanel, BorderLayout.CENTER); // Utiliser BorderLayout.CENTER pour la carte

        mapPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                mapPanel.handleKeyPress(e.getKeyCode());
            }
        });

        this.add(playerInfoPanel, BorderLayout.EAST); // Ajouter à l'est pour les infos du joueur
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }

    public MapPanel getMapPanel() {
        return mapPanel;
    }


}
