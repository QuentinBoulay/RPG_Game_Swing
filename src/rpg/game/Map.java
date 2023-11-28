package rpg.game;

public class Map {
    static final int[][] MAP_TEMPLATE_DEFAULT = {
            {2, 0, 1, 1},
            {1, 0, 1, 1},
            {1, 0, 4, 1},
            {1, 1, 0, 3},
    };

    private int[][] map;

    public Map() {
        this.map = MAP_TEMPLATE_DEFAULT;
    }

    public int[][] getMap() {
        return this.map;
    }


}
