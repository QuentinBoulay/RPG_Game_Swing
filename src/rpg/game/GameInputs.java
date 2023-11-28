package rpg.game;

import rpg.game.weapons.Weapon;
import rpg.game.weapons.WeaponStore;

import java.util.ArrayList;

public class GameInputs {
    private String playerName;
    private PlayerCast playerCast;

    private ArrayList<Weapon> playerWeapons;

    private WeaponStore weaponStore;

    public GameInputs() {
        this.playerName = "";
        this.playerCast = null;
        this.playerWeapons = new ArrayList<Weapon>();
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public PlayerCast getPlayerCast() {
        return this.playerCast;
    }

    public void setPlayerName(String n) {
        this.playerName = n;
    }

    public void setPlayerCast(PlayerCast c) {
        this.playerCast = c;
    }

    public void setPlayerWeapon(Weapon w) {
        this.playerWeapons.add(w);
    }
    public ArrayList<Weapon> getPlayerWeapons() {
        return this.playerWeapons;
    }
    public WeaponStore getWeaponStore() {
        return this.weaponStore;
    }
    public void setWeaponStore(WeaponStore weaponStore) {
        this.weaponStore = weaponStore;
    }
}
