/**
 * Created by Morten on 04-02-2016.
 */
public class Entities {

    private Damage weapon;
    private int hitpoint;
    private int level = 1;
    private double minDamage;
    private double maxDamage;
    private double attackSpeed;
    private String name;
    private String description;

    public Entities(String name, String description, int hitpoint, Damage weapon, int level) {
        this.name = name;
        this.description = description;
        this.hitpoint = hitpoint;
        this.weapon = weapon;
        this.level = level;
    }

    public void setWeapon(Damage weapon) {
        this.weapon = weapon;
        this.minDamage = weapon.getMinDamage();
        this.maxDamage = weapon.getMaxDamage();
        this.attackSpeed = weapon.getAttackSpeed();
    }

    public Damage getWeapon() {
        return weapon;
    }

    public double getMinDamage() {
        return minDamage;
    }

    public void setHitpoint(int hitpoint) {
        this.hitpoint = hitpoint;
    }

    public int getHitpoint() {
        return hitpoint;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
