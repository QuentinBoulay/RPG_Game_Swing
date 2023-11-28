package rpg.game.weapons;

public class Bow extends Weapon {

    private static final String nomArme = "Bow";
    public static final double damage = 50;
    private static final double ratioDamageMonster = 2.5;
    private static final double ratioDamageObstacle = 0.5;
    private static final double price = 100;

    public Bow(int idArme) {
        super(idArme, nomArme, damage, ratioDamageMonster, ratioDamageObstacle, price);
    }

}