package rpg.game.weapons;

public class Hammer extends Weapon {

    private static final String nomArme = "Hammer";
    public static final double damage = 200;
    private static final double ratioDamageMonster = 1;
    private static final double ratioDamageObstacle = 0.5;
    private static final double price = 300;
    public Hammer(int idArme) {
        super(idArme, nomArme, damage, ratioDamageMonster, ratioDamageObstacle, price);
    }


}
