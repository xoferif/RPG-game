import java.util.Map;

/**
 * Created by Morten on 04-02-2016.
 */
public class Weapons implements WeaponStat {
    WeaponTypes weaponType;


    @Override
    public void weaponMinDamage(double minDamage) {
    }

    @Override
    public void weaponMaxDamage(double maxDamage) {

    }

    @Override
    public void attackSpeed(double attackSpeed) {

    }
    @Override
    public void weaponType(WeaponTypes weaponType) {
    this.weaponType = weaponType;
    }

}
