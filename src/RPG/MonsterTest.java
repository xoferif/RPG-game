package RPG;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Morten on 25-02-2016.
 */
public class MonsterTest {

    @Test
    public void testAttack() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Monster monster = new Monster("test","monster description",100,dmg,1);
        Player player = new Player("test","monster description",100,dmg,1,1);
        monster.attack(player);
        assertTrue(player.getHitpoint() != 100);
    }

    @Test
    public void testNewRandomInstance() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Monster monster = new Monster("test","monster description",100,dmg,1);
        Monster newMonster;
        newMonster = monster.newRandomInstance();
        assertTrue(newMonster != null);
        assertTrue(newMonster.getHitpoint() > 1);
        assertTrue(newMonster.getName() != null);
        assertTrue(newMonster.alive());
        assertTrue(newMonster.getDescription() != null);
        assertTrue(newMonster.status() != null);
    }

    @Test
    public void testLastInstance() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Monster monster = new Monster("test","monster description",100,dmg,1);
        Monster newMonster;
        newMonster = monster.lastInstance();
        assertTrue(newMonster != null);
        assertTrue(newMonster.getHitpoint() == 80);
        assertTrue(newMonster.getName() == "Queen Harpy");
        assertTrue(newMonster.alive());
        assertTrue(newMonster.getDescription() != null);
        assertTrue(newMonster.status() != null);
    }
}