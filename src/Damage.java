import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Morten on 04-02-2016.
 */
public class Damage {
    private WeaponTypes weaponType;
    private double minDamage;
    private double maxDamage;
    private double attackSpeed;

    Damage(WeaponTypes weapon){
        WeaponDamage wd = new WeaponDamage();
        List<Double> damage = wd.getSpeedAndDamage(weapon);
        this.attackSpeed = damage.indexOf(0);
        this.minDamage = damage.indexOf(1);
        this.maxDamage = damage.indexOf(2);

    }

    public double getAttackSpeed() {
        return attackSpeed;
    }
    public double getMaxDamage() {
        return maxDamage;
    }

    public double getMinDamage() {
        return minDamage;
    }
}
