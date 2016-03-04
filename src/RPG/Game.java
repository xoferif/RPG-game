package RPG;

import java.io.File;

/**
 * Created by Morten on 04-02-2016.
 *
 * Main file, which initializes game.
 */
public class Game {

    Player player = new Player("FirstComer", "A mere newcomer to textbased RPC games.", 50, new Damage(WeaponTypes.Hands), 1,10);

    public void play(Game game){
        Room room = new Room();
        try{
            File f = new File(this.getClass().getClassLoader().getResource("").getPath()+ "Rooms");
            if (!f.exists()) {
                room.createRoomFiles();
            }
        }
        catch (NullPointerException np){
            IO io = new IO();
            io.print(np.toString());
        }
        Area area = new Area();
        area.newInstance().startQuest(player,game);
    }


    public static void main(String[] args){
        Game game = new Game();
        game.play(game);
    }
}
