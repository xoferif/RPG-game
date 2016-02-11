/**
 * Created by Morten on 04-02-2016.
 */
public class Player extends Entities {
    private int numberOfPotions;

    public Player(String name, String description, int hitpoint, Damage weapon, int level, int numberOfPotions){
        super(name, description, hitpoint, weapon, level);
        this.numberOfPotions = numberOfPotions;
    }

    public void heal(){
        if (this.numberOfPotions > 0){
            Math.min(maxHitpoints,hitpoint + (maxHitpoints*0.3));
        }
    }

}
