package game;

public class Map {
    static final String[][] MAP_TEMPLATE_DEFAULT = {
            {"D", "P", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D"},
            {"D", "", "D", "", "D", "", "D", "", "", "", "D", "", "", "", "M", "D"},
            {"D", "", "D", "", "D", "", "D", "", "D", "", "D", "", "D", "", "D", "D"},
            {"D", "", "", "", "", "", "M", "", "", "", "", "", "M", "", "", "D"},
            {"D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "D", "", "S"},
    };

    private String[][] map;

    public Map() {
        this.map = MAP_TEMPLATE_DEFAULT;
    }

    public String[][] getMap() {
        return this.map;
    }


}
