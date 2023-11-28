package rpg.ui;

import rpg.game.Player;
import rpg.game.weapons.Weapon;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class PlayerInfoPanel extends JPanel {

    private Player player;

    private JLabel nameLabel;
    private JLabel classLabel;
    private JLabel moneyLabel;
    private JList<Weapon> weaponsList;

    public PlayerInfoPanel(Player player) {
        this.player = player;
        init();
    }

    private void init() {
        this.setLayout(new GridLayout(4, 1)); // Utiliser GridLayout pour organiser les labels

        nameLabel = new JLabel("Nom: " + player.getName());
        classLabel = new JLabel("Classe: " + player.getCast().toString());
        moneyLabel = new JLabel("Argent: " + player.getMoney() + " pièces d'or");
        weaponsList = new JList<>(new Vector<>(player.getWeapons()));

        this.add(nameLabel);
        this.add(classLabel);
        this.add(moneyLabel);
        this.add(new JScrollPane(weaponsList));
    }

    public void updatePlayerInfo() {
        moneyLabel.setText("Argent: " + player.getMoney() + " pièces d'or");
        weaponsList.setListData(new Vector<>(player.getWeapons()));
    }

}
