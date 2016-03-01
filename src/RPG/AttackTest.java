package RPG;

import jdk.internal.org.objectweb.asm.Type;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Morten on 23-02-2016.
 */
public class AttackTest {
    Damage dmg;
    Attack at;

    @Test
    public void testSwing() throws Exception {
        dmg = new Damage(WeaponTypes.Hands);
        at = new Attack(dmg, 1);
        double ad = at.swing();
        assertTrue(at.swing() > 1 && at.swing() < 4.3);

    }

    @Test
    public void testSpin() throws Exception {
        dmg = new Damage(WeaponTypes.Hands);
        at = new Attack(dmg, 1);
        double ad = at.spin();
        System.out.println(ad);
        assertTrue(at.spin() > 1 && at.spin() < 4.3);
    }

    @Test
    public void testCleave() throws Exception {
        dmg = new Damage(WeaponTypes.Hands);
        at = new Attack(dmg, 1);
        double ad = at.cleave();
        System.out.println(ad);
        assertTrue(at.spin() > 1 && at.spin() < 4.4);
    }
}