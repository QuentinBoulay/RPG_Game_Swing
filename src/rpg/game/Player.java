package rpg.game;

import rpg.game.weapons.Weapon;
import rpg.game.weapons.WeaponStore;

import java.util.ArrayList;

public class Player {

    private String name;

    private PlayerCast cast;

    private double money = 1000;

    private ArrayList<Weapon> weapons;

    public Player(String n, PlayerCast c, ArrayList<Weapon> w) {
        this.name = n;
        this.cast = c;
        this.weapons = w;
    }

    public void buyWeapon(Weapon arme, WeaponStore store) {
        if(!store.getWeapons().contains(arme)) {
            System.out.println("L'arme n'est pas présente dans le catalogue");
        }
        else {
            if (this.money < arme.getPrice()) {
                System.out.println(this.name + ", tu n'as pas assez d'argent pour cette arme (prix arme : " + arme.getPrice() + ", argent possédé : " + this.money + ")");
            } else {
                store.getWeapons().remove(arme);
                this.money = this.money - arme.getPrice();
            }
        }

    }

    public String getName() {
        return this.name;
    }

    public PlayerCast getCast() {
        return this.cast;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    public double getMoney() {
        return this.money;
    }

    public void addWeapon(Weapon w) {
        this.weapons.add(w);
    }
}
