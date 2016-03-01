package RPG;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Morten on 01-03-2016.
 */
public class PlayerTest {

    @Test
    public void testHeal() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player player = new Player("test","Unit",100,dmg,1,1);
        player.setHitpoint(20);
        player.heal();
        assertTrue(player.getHitpoint() > 20 );
    }

    @Test
    public void testAttack() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player player = new Player("test","Unit",10,dmg,1,1);
        Monster monster = new Monster().newRandomInstance();
        int initMonsterHP = monster.getHitpoint();
        player.attack(monster,1);
        assertTrue(initMonsterHP > monster.getHitpoint());

    }
    @Test
    public void testSetWeapon() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player player = new Player("test","Unit",10,dmg,1,1);
        Damage dmgAltered = new Damage(WeaponTypes.Sword);
        player.setWeapon(dmgAltered);
        assertEquals(dmgAltered, player.getWeapon());
    }

    @Test
    public void testGetWeapon() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player entity = new Player("test","Unit",10,dmg,1,1);
        assertEquals(dmg, entity.getWeapon());
    }

    @Test
    public void testSetHitpoint() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player entity = new Player("test","Unit",10,dmg,1,1);
        entity.setHitpoint(200);
        assertEquals(200,entity.getHitpoint());
    }

    @Test
    public void testGetHitpoint() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player entity = new Player("test","Unit",10,dmg,1,1);
        assertEquals(10,entity.getHitpoint());
    }

    @Test
    public void testGetLevel() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player entity = new Player("test","Unit",10,dmg,1,1);
        assertEquals(1,entity.getLevel());
    }

    @Test
    public void testGetName() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player entity = new Player("test","Unit",10,dmg,1,1);
        assertEquals("test",entity.getName());
    }

    @Test
    public void testGetDescription() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player entity = new Player("test","Unit",10,dmg,1,1);
        assertEquals("Unit",entity.getDescription());
    }

    @Test
    public void testAttackDamage() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player entity = new Player("test","Unit",10,dmg,1,1);
        assertTrue(entity.attackDamage(1) > 1 && entity.attackDamage(1) < 4.3);
    }

    @Test
    public void testStatus() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player entity = new Player("test","Unit",10,dmg,1,1);
        assertEquals(String.format("%s HP: %d","test",10),entity.status());
    }

    @Test
    public void testAlive() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Player entity = new Player("test","Unit",10,dmg,1,1);
        assertTrue(entity.alive());
    }
}