package RPG;

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
     * @param weapon RPG.Damage: RPG.Damage object
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

    /**
     *
     * @param weapon RPG.Damage: set weapon and clarify damage.
     */
    public void setWeapon(Damage weapon) {
        this.weapon = weapon;
    }

    /**
     *
     * @return RPG.Damage: return Weapon data
     */
    public Damage getWeapon() {
        return weapon;
    }

    /**
     *
     * @param hitpoint Int: set hitpoint
     */
    public void setHitpoint(int hitpoint) {
        this.hitpoint = hitpoint;
    }

    /**
     *
     * @return Int: get hitpoints.
     */
    public int getHitpoint() {
        return hitpoint;
    }

    /**
     *
     * @return Int: Get level.
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @return String: get object name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return String: get object description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param attackType Int: define attacktype by int (1-3)
     * @return Double: Object damage.
     */
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

    /**
     *
     * @return String: Status for object.
     */
    public String status(){
        return String.format("%s HP: %d", name,hitpoint);
    }

    /**
     *
     * @return Boolean: return true if object is alive.
     */
    public boolean alive(){
        return hitpoint > 0;
    }

}
