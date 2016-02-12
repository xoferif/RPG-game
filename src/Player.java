/**
 * Created by Morten on 04-02-2016.
 */
public class Player extends Entities {
    private int numberOfPotions;
    private IO io = new IO();
    public Player(String name, String description, int hitpoint, Damage weapon, int level, int numberOfPotions){
        super(name, description, hitpoint, weapon, level);
        this.numberOfPotions = numberOfPotions;
    }

    public void heal(){
        if (numberOfPotions > 0){
            hitpoint = (int)Math.min(maxHitpoints,hitpoint + (maxHitpoints*0.3));
            io.print(String.format("%s drinks a potion and up to %d, you now only have %d potions left",getName(),hitpoint,numberOfPotions));
        }
        else{
            io.print("You have run out of potions!");
        }
    }

    public int attack(Monster monster, int attacktype){
        int attackDamage = (int)this.attackType(attacktype);
        monster.setHitpoint((monster.getHitpoint() > attackDamage) ? monster.getHitpoint() - attackDamage : 0);
        return attackDamage;
    }

}
