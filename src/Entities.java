/**
 * Created by Morten on 04-02-2016.
 *
 */
public class Entities {

    private Damage weapon;
    public int hitpoint;
    public int maxHitpoints;
    public int level = 1;
    private String name;
    private String description;

    /**
     *
     * @param name String: Character name
     * @param description String: Character description
     * @param hitpoint Int: Character hitpoints
     * @param weapon Damage: Damage object
     * @param level Int: Character level
     */
    public Entities(String name, String description, int hitpoint, Damage weapon, int level) {
        this.name = name;
        this.description = description;
        this.hitpoint = hitpoint;
        this.weapon = weapon;
        this.level = level;
        this.maxHitpoints  = hitpoint + (level * 15);
    }

    public void setWeapon(Damage weapon) {
        this.weapon = weapon;
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

    public double attackDamage(int attackType){
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
        return hitpoint > 0;
    }

}
