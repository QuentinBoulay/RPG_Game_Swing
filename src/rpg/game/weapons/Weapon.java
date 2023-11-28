package rpg.game.weapons;

public abstract class Weapon {
    private int idArme;
    private String nomArme;
    private double damage;
    private double ratioDamageMonster;
    private double ratioDamageObstacle;
    private double price;


    // Constructeur pour créer mes armes
    public Weapon(int idArme, String nomArme, double damage, double ratioDamageMonster, double ratioDamageObstacle, double price) {
        this.idArme = idArme;
        this.nomArme = nomArme;
        this.damage = damage;
        this.ratioDamageMonster = ratioDamageMonster;
        this.ratioDamageObstacle = ratioDamageObstacle;
        this.price = price;
    }

    public String toString() {
        return this.nomArme+" : "+this.damage+" damage"+" | "+this.price+" golds";
    }

    // Getters
    public int getIdArme() {
        return this.idArme;
    }

    public String getName() {
        return this.nomArme;
    }

    public double getDamage() {
        return this.damage;
    }

    public double getPrice() {
        return this.price;
    }

}
