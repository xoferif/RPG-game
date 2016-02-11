import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Morten on 11-02-2016.
 */
public class Combat {
    IO io = new IO();
    public Combat(Player player, Monster monster) throws IOException {

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
                if (damage.getAttackSpeed() != 1.0)
                {

                    player.attack(monster,aAction.);

                    io.print("  " + monster.getName() + " is hit for %d HP of damage (%s)\n", attackStrength,
                            getStatus());
                    if (hitPoints == 0) {
                        System.out.println("  " + name + " has been defeated");
                    }
                }
            }

        }
    }


}
