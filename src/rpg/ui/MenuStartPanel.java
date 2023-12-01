package rpg.ui;

import rpg.game.GameInputs;
import rpg.game.PlayerCast;
import rpg.game.weapons.Weapon;
import rpg.game.weapons.WeaponStore;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuStartPanel extends JPanel {

    private GameInputs gameInputs;

    private JLabel title;

    private JLabel pseudoLabel;
    private JTextField pseudoField;

    private JRadioButton radioMage;
    private JRadioButton radioWarrior;
    private JRadioButton radioElf;

    private JComboBox combo;

    private JButton okButton;

    private WeaponStore weaponStore;

    private Weapon selectedItem;


    public MenuStartPanel(GameInputs gameInputs) {
        this.gameInputs = gameInputs;
        this.weaponStore = new WeaponStore();
        initComponents();
    }

    private void setPlayerName(String name) {
        this.gameInputs.setPlayerName(name);
    }

    private void setPlayerCast() {
        PlayerCast playerClass = null;
        if (this.radioMage.isSelected()) {
            playerClass = PlayerCast.MAGE;
            System.out.println("Mage choisi");
        } else if (this.radioElf.isSelected()) {
            playerClass = PlayerCast.ELF;
            System.out.println("Elf choisi");
        } else if (this.radioWarrior.isSelected()){
            playerClass = PlayerCast.WARRIOR;
            System.out.println("Warrior choisi");
        }
        this.gameInputs.setPlayerCast(playerClass);

        System.out.println("Classe choisie : " + playerClass.toString());

    }

    public void updateGameInputs() {
        setPlayerName(pseudoField.getText());
        setPlayerCast();
        setWeaponStore(this.weaponStore);
        // si l'arme n'est pas choisie, on prend la première de la liste
        if (getSelectedItem() == null) {
            setSelectedItem(this.weaponStore.getWeapons().get(0));
            setPlayerWeapon(getSelectedItem());
        }
        else {
            setPlayerWeapon(getSelectedItem());
        }
        System.out.println("Arme choisie : " + getSelectedItem());
    }

    private void setSelectedItem(Weapon weapon) {
        this.selectedItem = weapon;
    }

    private Weapon getSelectedItem() {
        return this.selectedItem;
    }

    private void setPlayerWeapon(Weapon weapon) {
        this.gameInputs.setPlayerWeapon(weapon);
    }

    private void setWeaponStore(WeaponStore weaponStore) {
        this.gameInputs.setWeaponStore(weaponStore);
    }

    private void initComponents() {
        // define components
        this.title = new JLabel("WELCOME TO MY RPG");
        this.pseudoLabel = new JLabel("Choose your name : ");
        this.pseudoField = new JTextField();

        this.radioMage = new JRadioButton("MAGE");
        this.radioWarrior = new JRadioButton("WARRIOR");
        this.radioElf = new JRadioButton("ELF");

        // choix de l'arme au début du jeu
        this.combo = new JComboBox(this.weaponStore.getWeapons().toArray());

        this.combo.addActionListener(e -> {
            JComboBox cb = (JComboBox) e.getSource();
            Weapon selectedWeapon = (Weapon) cb.getSelectedItem();
               setSelectedItem(selectedWeapon);
        });

        // define panel layout
        this.setBorder(new EmptyBorder(50, 50, 50, 50));
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        /* GridBagConstraints parameters :
            int gridx,
            int gridy,
            int gridwidth,
            int gridheight,
            double weightx,
            double weighty,
            int anchor,
            int fill,
            java.awt.Insets insets,
            int ipadx,
            int ipady
         */
        this.setLayout(gridbag);
        gbc.fill = GridBagConstraints.BOTH;

        // add components to panel
        // title
        this.title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        gbc.gridwidth = 3;  // 3 columns wide
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(this.title, gbc);
        this.add(this.title);


        // player classes radio buttons
        // mage
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.radioMage);
        buttonGroup.add(this.radioElf);
        buttonGroup.add(this.radioWarrior);

        this.radioMage.setSelected(true);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioMage, gbc);
        this.add(this.radioMage);
        // elf
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioElf, gbc);
        this.add(this.radioElf);
        // warrior
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 20, 0);
        gridbag.setConstraints(this.radioWarrior, gbc);
        this.add(this.radioWarrior);

        // pseudo of the player
        this.add(this.pseudoLabel,
                new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(50, 0, 30, 0), 0, 0));

        this.add(this.pseudoField,
                new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(50, 0, 30, 0), 0, 0));


        JLabel label = new JLabel("Choisissez une arme :");
        this.add(label,
                new GridBagConstraints(0, 3, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, -30, 0), 0, 0));

        this.add(combo,
                new GridBagConstraints(0, 4, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(50, 0, 30, 0), 0, 0));
    }


}
