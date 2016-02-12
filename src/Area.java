import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Morten on 12-02-2016.
 */
public class Area {
    private List<Room> map = new ArrayList<>();
    private Room thisRoom;
    private boolean firstRoom = true;
    private int playerPosX;
    private int playerPosY;
    private IO io = new IO();

    private boolean isComplete(){
        return thisRoom.isLastRoom() && thisRoom.isComplete();
    }

    public void startQuest(Player player){
        while (player.alive() && !isComplete()){
            movePlayer(player);
        }
        if(player.alive())
        {
            io.print("\nYou've won !");
        }
        else
        {
            io.print("You died! try again?");
        }
    }

    public Area newInstance() {
        Room room = new Room();
        Area area = new Area();
        Damage damage = new Damage(WeaponTypes.Hands);
        Monster monster = new Monster("","",0, damage,0);
        area.map.add(room.newNormalRoom(monster));
        area.map.add(room.newNormalRoom(monster));
        area.map.add(room.newNormalRoom(monster));
        area.map.add(room.newNormalRoom(monster));
        area.map.add(room.newNormalRoom(monster));
        area.map.add(room.LastRoom(monster));
        area.thisRoom = area.map.get(0);
        return area;
    }

    private boolean allowedMove(int playerPosX, int playerPosY){
        List<String> currentLocation = new ArrayList<>();
        if (firstRoom){
            currentLocation = thisRoom.loadRoom("room" + 1);
        }
        for (int i = 0; i < currentLocation.size();i++){
            String lastY = "";
            String nextY = "";
            if (1 < i){
                lastY = currentLocation.get(i-1);
            }
            if (i < currentLocation.size()-1){
                nextY = currentLocation.get(i+1);
            }
            String currentY = currentLocation.get(i);
            CharSequence playerPos = "x";
            int ii = currentY.indexOf("x")-1;
            if (currentY.contains(playerPos)){
                if (!lastY.isEmpty() && !lastY.substring(currentY.indexOf("x"), currentY.indexOf("x")+1).equals("#"))
                {
                    return true;
                }
                else if(!nextY.isEmpty() && !nextY.substring(currentY.indexOf("x"), currentY.indexOf("x")+1).equals("#"))
                {
                    return true;
                }
                else if(!currentY.substring(currentY.indexOf("x")+1, currentY.indexOf("x")+2).equals("#"))
                {
                    return true;
                }
                else if(!currentY.substring(currentY.indexOf("x")-1, currentY.indexOf("x")).equals("#")){
                    return true;
                }
            }
        }
        return false;
    }
    private void movePlayer(Player player){
        boolean upAllowed = allowedMove(playerPosX, playerPosY + 1);
        boolean downAllowed = allowedMove(playerPosX, playerPosY - 1);
        boolean rightAllowed = allowedMove(playerPosX + 1, playerPosY);
        boolean leftAllowed = allowedMove(playerPosX - 1, playerPosY);
        io.print("Which way you want to go?");
        if (upAllowed){
            io.print("Up (w)");
        }
        if (downAllowed){
            io.print("Down (s)");
        }
        if (rightAllowed){
            io.print("Right (d)");
        }
        if (leftAllowed){
            io.print("Left (a)");
        }

        String move = io.scan();
        if (move.equals("w") && upAllowed){
            playerPosY++;
        }
        if (move.equals("s") && downAllowed){
            playerPosY--;
        }
        if (move.equals("d") && rightAllowed){
            playerPosX++;
        }
        if (move.equals("a") && leftAllowed){
            playerPosX--;
        }

    }

}
