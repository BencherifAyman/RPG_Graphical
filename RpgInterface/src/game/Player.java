package game;

import java.util.ArrayList;

public class Player {

    private  int damage;
    private String name;
    private PlayerCast cast;


    protected double money;
    protected double HP;

    public Player(String n, PlayerCast c) {
        this.name = n;
        this.cast = c;
        this.money = 3000;
        this.HP = 1000;
        this.damage = 200;
    }

    public String getName() {
        return this.name;
    }

    public PlayerCast getCast() {
        return this.cast;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCast(PlayerCast cast) {
        this.cast = cast;
    }

    public double getMoney() {
        return money;
    }
    public int getDamage(){
        return this.damage;
    }

    public double getHP(){
        return this.HP;
    }

    public String infoPlayer() {
        return "Name: " + this.name + " Cast : " + this.cast + " Money : "
                + this.money + "$  Life : " + this.HP + "HP" ;
    }


    public void setHP(double playerHP) {
        this.HP= this.HP-200;
    }
}
