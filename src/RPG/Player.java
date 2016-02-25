package RPG;

/**
 * Created by Morten on 04-02-2016.
 *
 * RPG.Player class, handles various player actions
 */
public class Player extends Entities {
    private int playerPosX;
    private int playerPosY;
    private int numberOfPotions;
    private IO io = new IO();
    public Player(String name, String description, int hitpoint, Damage weapon, int level, int numberOfPotions){
        super(name, description, hitpoint, weapon, level);
        this.numberOfPotions = numberOfPotions;
    }

    /**
     * Heal player if possible
     */
    public void heal(){
        if (numberOfPotions > 0){
            hitpoint = (int)Math.min(maxHitpoints,hitpoint + (maxHitpoints*0.3));
            io.print(String.format("%s drinks a potion and up to %d, you now only have %d potions left",getName(),hitpoint,numberOfPotions));
        }
        else{
            io.print("You have run out of potions!");
        }
    }

    /**
     *
     * @return Int: Returns players position on the x axle
     */
    public int getPlayerPosX() {
        return playerPosX;
    }

    /**
     *
     * @returnInt: Returns players position on the y axle
     */
    public int getPlayerPosY() {
        return playerPosY;
    }

    /**
     *
     * @param playerPosX Int: set players position on the x axle
     */
    public void setPlayerPosX(int playerPosX) {
        this.playerPosX = playerPosX;
    }

    /**
     *
     * @param playerPosY Int: set players position on the y axle
     */
    public void setPlayerPosY(int playerPosY) {
        this.playerPosY = playerPosY;
    }

    /**
     *
     * @param monster
     * @param attacktype
     * @return
     */
    public int attack(Monster monster, int attacktype){
        int attackDamage = (int)this.attackDamage(attacktype);
        monster.setHitpoint((monster.getHitpoint() > attackDamage) ? monster.getHitpoint() - attackDamage : 0);
        return attackDamage;
    }

}
