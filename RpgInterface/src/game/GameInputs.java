package game;

import java.util.ArrayList;
public class GameInputs {


    private Player player;

    public GameInputs() {
        this.player = new Player("", null);

    }

    public void setPlayerName(String n) {
        this.player.setName(n);
    }

    public void setPlayerCast(PlayerCast c) {
        this.player.setCast(c);
    }





    public Player getPlayer() {
        return this.player;
    }

}
