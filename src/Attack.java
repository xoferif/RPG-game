import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Morten on 11-02-2016.
 */
public class Attack {
    private Damage damage;
    private double levelMultiplier = 1;
    private double calculatedDMG;
    private double multiplier;

    Attack(Damage damage, int level){
        this.damage = damage;
        this.levelMultiplier += (level * 0.04)  ;
    }

    public double swing()
    {
        multiplier = 0.05 + levelMultiplier;
        calculatedDMG = calculateDMG() * multiplier;

        return calculatedDMG;
    }
    public double spin()
    {
        multiplier = 0.02 + levelMultiplier;
        calculatedDMG = calculateDMG() * multiplier;
        return calculatedDMG;
    }
    public double cleave()
    {
        multiplier = 0.07 + levelMultiplier;
        calculatedDMG = calculateDMG() * multiplier;
        return calculatedDMG;
    }

    private double calculateDMG()
    {
        double random = ThreadLocalRandom.current().nextDouble(damage.getMinDamage(), damage.getMaxDamage());
        return random;
    }
}
