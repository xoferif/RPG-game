/**
 * Created by Morten on 04-02-2016.
 */
public class Entities {

    private Weapons weapon;
    private int damage;
    private int hitpoints;
    private int level = 1;

    public Entities(int hitpoints, Weapons weapon, int level){
        this.hitpoints = hitpoints;
        this.weapon = weapon;
        this.level = level;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public Weapons getWeapon() {
        return weapon;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getHitpoints() {
        return hitpoints;
    }
}
