import java.io.IOException;

/**
 * Created by Morten on 11-02-2016.
 *
 * Combat class is used for fighting... FIGHT!
 */
public class Combat {
    IO io = new IO();

    /**
     *
     * @param monster : object Monster - used for attack and hitpoint manipulation
     * @param player : object Player - used for attack and hitpoint manipulation
     * @param attackOption : determines which attack to use
     */
    private void playerAttack(Monster monster, Player player, int attackOption){
        int AttackDamage = player.attack(monster,attackOption);

        io.print(String.format("  " + monster.getName() + " is hit for %d HP of damage (%s)\n", AttackDamage, monster.status()));

        if (monster.getHitpoint() == 0) {
            io.print("  " + monster.getName() + " has been defeated");
        }
    }

    /**
     *
     * @param monster : object Monster - used for attack and hitpoint manipulation
     * @param player : object Player - used for attack and hitpoint manipulation
     */
    private void monsterAttack(Monster monster, Player player){
        int AttackDmg = monster.attack(player);

        io.print(String.format("  " + player.getName() + " is hit for %d HP of damage (%s)\n", AttackDmg, player.status()));

        if (player.getHitpoint() == 0) {
            io.print("  " + player.getName() + " has been defeated");
        }
    }

    /**
     *
     * @param player : object Player - used for attack and hitpoint manipulation
     * @param monster: object Monster - used for attack and hitpoint manipulation
     */
    public Combat(Player player, Monster monster) {

        io.print("You encounter " + monster + ": " + monster.getDescription());
        io.print("Battle with " + monster + " starts (" + player.status() + " / "
                + monster.status() + ")");
        while (player.alive() && monster.alive()) {
            io.print("Attack (a) or heal (h)? ");
            String action = io.scan();
            if (action.equals("h")) {
                player.heal();
            }
            if (action.equals("a")){
                io.print("attack types:\n1: Swing\n2: Cleave\n3: Spin");

                String aAction= "0";
                while (aAction != "1" || aAction != "2" || aAction != "3")
                    aAction = io.scan();

                Damage damage = player.getWeapon();
                // monster attacks first due to slowness
                if (damage.getAttackSpeed() == 1.0)
                {
                    //Monster surprice attack!
                    monsterAttack(monster,player);

                    //Player retaliates
                    playerAttack(monster,player,Integer.parseInt(aAction));
                }
                else{
                    // Player quickness FTW
                    playerAttack(monster,player,Integer.parseInt(aAction));

                    // Monster speed is slow compared to SUPER PLAYER!
                    monsterAttack(monster,player);
                }

            }

        }
    }


}
