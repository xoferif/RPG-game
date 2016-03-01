package RPG;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;

import static org.junit.Assert.*;

/**
 * Created by Morten on 01-03-2016.
 */
public class WeaponDamageTest {
    @Test
    public void testGetSpeedAndDamageForAxe() throws Exception {
        WeaponDamage wd = new WeaponDamage();
        List<Double> dmg = wd.getSpeedAndDamage(WeaponTypes.Axe);
        //verify speed
        assertEquals(1.3, dmg.get(0),0);
        //verify min damage
        assertEquals(7.2, dmg.get(1),0);
        //verify max damage
        assertEquals(9.1, dmg.get(2),0);
    }

    @Test
    public void testGetSpeedAndDamageForFlail() throws Exception {
        WeaponDamage wd = new WeaponDamage();
        List<Double> dmg = wd.getSpeedAndDamage(WeaponTypes.Flail);
        //verify speed
        assertEquals(1.5, dmg.get(0),0);
        //verify min damage
        assertEquals(1.0, dmg.get(1),0);
        //verify max damage
        assertEquals(14.4, dmg.get(2),0);
    }

    @Test
    public void testGetSpeedAndDamageForHands() throws Exception {
        WeaponDamage wd = new WeaponDamage();
        List<Double> dmg = wd.getSpeedAndDamage(WeaponTypes.Hands);
        //verify speed
        assertEquals(1.0, dmg.get(0),0);
        //verify min damage
        assertEquals(1.0, dmg.get(1),0);
        //verify max damage
        assertEquals(3.9, dmg.get(2),0);
    }

    @Test
    public void testGetSpeedAndDamageForSword() throws Exception {
        WeaponDamage wd = new WeaponDamage();
        List<Double> dmg = wd.getSpeedAndDamage(WeaponTypes.Sword);
        //verify speed
        assertEquals(1.4, dmg.get(0),0);
        //verify min damage
        assertEquals(8.4, dmg.get(1),0);
        //verify max damage
        assertEquals(10.5, dmg.get(2),0);
    }
}