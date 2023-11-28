package rpg.game.weapons;

public class Axe extends Weapon {

    private static final String nomArme = "Axe";

    public static final double damage = 100;
    private static final double ratioDamageMonster = 0.8;
    private static final double ratioDamageObstacle = 0.2;
    private static final float price = 120;

    public Axe(int idArme) {
        super(idArme, nomArme, damage, ratioDamageMonster, ratioDamageObstacle, price);
    }


}
