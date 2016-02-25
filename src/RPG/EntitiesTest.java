package RPG;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Morten on 23-02-2016.
 */
public class EntitiesTest {

    @Test
    public void testSetWeapon() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        Damage dmgAltered = new Damage(WeaponTypes.Sword);
        entity.setWeapon(dmgAltered);
        assertEquals(dmgAltered, entity.getWeapon());
    }

    @Test
    public void testGetWeapon() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        assertEquals(dmg, entity.getWeapon());
    }

    @Test
    public void testSetHitpoint() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        entity.setHitpoint(200);
        assertEquals(200,entity.getHitpoint());
    }

    @Test
    public void testGetHitpoint() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        assertEquals(10,entity.getHitpoint());
    }

    @Test
    public void testGetLevel() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        assertEquals(1,entity.getLevel());
    }

    @Test
    public void testGetName() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        assertEquals("test",entity.getName());
    }

    @Test
    public void testGetDescription() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        assertEquals("unit",entity.getDescription());
    }

    @Test
    public void testAttackDamage() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        assertSame(Integer.TYPE,entity.attackDamage(1));
    }

    @Test
    public void testStatus() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        assertSame(String.format("%s HP: %d","test",10),entity.status());
    }

    @Test
    public void testAlive() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        Entities entity = new Entities("test","Unit",10,dmg,1);
        assertTrue(entity.alive());
    }
}