package rpg.game;

public class Game {

    private Map map;

    private Player player;

    public Game(GameInputs gameInputs) {
        this.player = new Player(gameInputs.getPlayerName(), gameInputs.getPlayerCast(), gameInputs.getPlayerWeapons());
        this.player.buyWeapon(gameInputs.getPlayerWeapons().get(0), gameInputs.getWeaponStore());
        this.map = new Map();
    }

    public Map getMap(){
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }
}
