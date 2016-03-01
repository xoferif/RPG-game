package RPG;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Morten on 23-02-2016.
 */
public class DamageTest {

    @Test
    public void testGetAttackSpeed() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        assertTrue(1.0 == dmg.getAttackSpeed());
    }

    @Test
    public void testGetMaxDamage() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        assertTrue(3.9== dmg.getMaxDamage());
    }

    @Test
    public void testGetMinDamage() throws Exception {
        Damage dmg = new Damage(WeaponTypes.Hands);
        assertTrue(1.0 == dmg.getMinDamage());
    }
}