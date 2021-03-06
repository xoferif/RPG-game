package RPG;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Morten on 04-02-2016.
 *
 * RPG.Monster class, used for generating monsters'n'stuff
 */
public class Monster extends Entities {
    private Random random = new Random();
    private Set<Integer> monsterEncountered = new HashSet<>();
    private int NUM_MONSTERS = 3;

    /**
     *
     * @param name String: Monsters name
     * @param description String: RPG.Monster descriptions
     * @param hitpoint Int: Monsters health
     * @param weapon RPG.Damage: RPG.Damage object to clarify monster damage
     * @param level Int: RPG.Monster level
     */
    public Monster(String name, String description, int hitpoint, Damage weapon, int level){
        super(name, description, hitpoint, weapon, level);

    }

    public Monster(){}

    /**
     *
     * @param player RPG.Player: RPG.Player object
     * @return Int: returns attack damage.
     */
    public int attack(Player player) {
        int attackDamage = (int) this.attackDamage(1);
        player.setHitpoint((player.getHitpoint() > attackDamage) ? player.getHitpoint() - attackDamage : 0);
        return attackDamage;
    }

    /**
     *
     * @return RPG.Monster: creates monster for room instances.
     */
    public Monster newRandomInstance() {
        if (monsterEncountered.size() == NUM_MONSTERS) {
            monsterEncountered.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_MONSTERS);
        } while (monsterEncountered.contains(i));
        monsterEncountered.add(i);

        if (i == 0) {
            Damage damage = new Damage(WeaponTypes.Flail);
            return new Monster("Harpy", "Bloodthirsty and cruel, harpies are a mix of human female and bird.", 40, damage, 2);
        }
        else if (i == 1) {
            Damage damage = new Damage(WeaponTypes.Axe);
            return new Monster("Gargoyle", "Stony and slow, But knocks you down when coming out of nowhere", 26, damage, 4);
        }
        else if (i == 2) {Damage damage = new Damage(WeaponTypes.Sword);
            return new Monster("Assassin", "Through murder and fear, the Assassin's are in no way any more innocent than the Harpys", 26, damage, 3);
        }
        else {
            Damage damage = new Damage(WeaponTypes.Hands);
            return new Monster("Hobgoblin","Imps are associated with Hell and fire, being a real threat for humanity and finding joy in manipulating with heat", 18,damage, 2);
        }
    }

    /**
     *
     * @return RPG.Monster: method to make "boss" for last level.
     */
    public Monster lastInstance(){
        Damage damage = new Damage(WeaponTypes.Sword);
        return new Monster("Queen Harpy", "Bloodthirsty and cruel, harpies are a mix of human female and bird.", 80, damage, 5);
    }

}
