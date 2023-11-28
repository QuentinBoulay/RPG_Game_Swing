package rpg.game.weapons;

import java.util.ArrayList;

public class WeaponStore {

    private ArrayList<Weapon> weapons = new ArrayList<>();

    public WeaponStore() {
        weapons.add(new Axe(1));
        weapons.add(new Hammer(2));
        weapons.add(new Bow(3));

    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public String toString() {
        String str = "";
        for (Weapon weapon : weapons) {
            str += weapon.toString() + "\n";
        }
        return str;
    }

}
