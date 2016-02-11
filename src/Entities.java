import java.util.function.ToIntFunction;

/**
 * Created by Morten on 04-02-2016.
 */
public class Entities {

    private Damage weapon;
    private int hitpoint;
    private int maxHitpoints;
    private int level = 1;
    private int numerOfPotions;
    private double minDamage;
    private double maxDamage;
    private double attackSpeed;
    private String name;
    private String description;

    public Entities(String name, String description, int hitpoint, int numberOfPotions, Damage weapon, int level) {
        this.name = name;
        this.description = description;
        this.hitpoint = hitpoint;
        this.numerOfPotions = numberOfPotions;
        this.weapon = weapon;
        this.level = level;
        this.maxHitpoints  = hitpoint + (level * 15);
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

    public double attackType(int attackType){
        Attack attack = new Attack(weapon,level);
        double damage = 0;
        switch (attackType){
            case 1:
                damage = attack.swing();
                break;
            case 2:
                damage = attack.cleave();
                break;
            case 3:
                damage = attack.spin();
                break;
        }
        return damage;
    }

    public String status(){
        return String.format("%s HP: %d", name,hitpoint);
    }

    public boolean alive(){
        if (hitpoint < 0){
            return false;
        }
        else{
            return true;
        }
    }

    public void heal(){
        if (numerOfPotions > 0){
            Math.min(maxHitpoints,hitpoint + (maxHitpoints*0.3));
        }
    }

    public int attack(Monster monster, int attacktype){
        int attackDamage = (int)this.attackType(attacktype);
        monster.setHitpoint((monster.getHitpoint() > attackDamage) ? monster.getHitpoint() - attackDamage : 0);
        return attackDamage;
    }
}
