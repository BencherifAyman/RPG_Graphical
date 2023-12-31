package game;

public class Game {

    private Map map;

    private Player player;

    public Game(GameInputs gameInputs) {
        this.player = gameInputs.getPlayer();
        this.map = new Map();
    }

    public Map getMap(){
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }
}
