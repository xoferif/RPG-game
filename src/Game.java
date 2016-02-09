/**
 * Created by Morten on 04-02-2016.
 */
public class Game {

    Player player = new Player("FirstComer", "A mere newcomer to textbased RPC games.", 50, new Damage(WeaponTypes.Hands), 1);

    public void play(){
        Room room = new Room();
        room.createRooms();
    }

    public static void main(String[] args){
        Game game = new Game();
        game.play();
    }
}
