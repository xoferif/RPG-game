import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Morten on 04-02-2016.
 */
public class Game {

    Player player = new Player("FirstComer", "A mere newcomer to textbased RPC games.", 50, new Damage(WeaponTypes.Hands), 1,10);

    public void play(){
        Room room = new Room();
        Path folder = Paths.get(this.getClass().getClassLoader().getResource("").getPath());
        if (!Files.exists(folder)){
            room.createRooms();
        }


    }

    public static void main(String[] args){
        Game game = new Game();
        game.play();
    }
}
