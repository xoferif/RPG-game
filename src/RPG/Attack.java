package RPG;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Morten on 11-02-2016.
 *
 * Class that defines and calculate damage
 */
public class Attack {
    private Damage damage;
    private double levelMultiplier = 1;
    private double calculatedDMG;
    private double multiplier;

    /**
     *
     * @param damage initialize damage getting min. and max dmg.
     * @param level initialize level for multiplier
     */
    public Attack(Damage damage, int level){
        this.damage = damage;
        this.levelMultiplier += (level * 0.04)  ;
    }

    /**
     *
     * @return Calculated damage
     */
    public double swing()
    {
        multiplier = 0.05 + levelMultiplier;
        calculatedDMG = calculateDMG() * multiplier;

        return calculatedDMG;
    }

    /**
     *
     * @return Calculated damage
     */
    public double spin()
    {
        multiplier = 0.02 + levelMultiplier;
        calculatedDMG = calculateDMG() * multiplier;
        return calculatedDMG;
    }

    /**
     *
     * @return Calculated damage
     */
    public double cleave()
    {
        multiplier = 0.07 + levelMultiplier;
        calculatedDMG = calculateDMG() * multiplier;
        return calculatedDMG;
    }

    /**
     *
     * @return a random damage from between minimum and max damage.
     */
    private double calculateDMG()
    {
        double randomDamage = ThreadLocalRandom.current().nextDouble(damage.getMinDamage(), damage.getMaxDamage());
        return randomDamage;
    }
}
