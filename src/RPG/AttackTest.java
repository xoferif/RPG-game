package RPG;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Morten on 23-02-2016.
 */
public class AttackTest {
    Damage dmg;
    Attack at;
    @Before
    public void setUp() throws Exception {
        dmg = new Damage(WeaponTypes.Hands);
        at = new Attack(dmg, 1);
    }

    @Test
    public void testSwing() throws Exception {
        assertSame(Double.TYPE, at.swing());
    }

    @Test
    public void testSpin() throws Exception {
        assertSame(Double.TYPE, at.spin());
    }

    @Test
    public void testCleave() throws Exception {
        assertSame(Double.TYPE, at.cleave());
    }
}