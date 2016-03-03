package RPG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Morten on 12-02-2016.
 *
 * RPG.Area class for holding all rooms together
 */
public class Area {
    private List<Room> map = new ArrayList<>();
    private Room thisRoom;
    private boolean firstRoom = true;
    private IO io = new IO();

    private boolean isComplete(){
        return thisRoom.isLastRoom() && thisRoom.isComplete();
    }

    /**
     * Start the game here
     * @param player RPG.Player object
     */
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
        Monster monster = new Monster();
        area.map.add(room.firstRoom(monster));
        area.map.add(room.newNormalRoom(monster));
        area.map.add(room.newNormalRoom(monster));
        area.map.add(room.newNormalRoom(monster));
        area.map.add(room.newNormalRoom(monster));
        area.map.add(room.LastRoom(monster));
        area.thisRoom = area.map.get(0);
        return area;
    }

    private Player currentPlayerlocation(List<String> currentRoom, Player player){
        String playerLocation = "";
        for (int i = 0; i < currentRoom.size();i++){
            CharSequence playerPos = "x";
            String currentY = currentRoom.get(i);
            if (currentY.contains(playerPos)){
                player.setPlayerPosX(currentY.indexOf('x'));
                player.setPlayerPosY(i);
            }

        }
        return player;
    }

    private boolean allowedMove(List<String> currentRoom, String direction){
        for (int i = 0; i < currentRoom.size();i++){
            String lastY = "";
            String nextY = "";
            if (1 < i){
                lastY = currentRoom.get(i-1);
            }
            if (i < currentRoom.size()-1){
                nextY = currentRoom.get(i+1);
            }
            String currentY = currentRoom.get(i);
            CharSequence playerPos = "x";
            if (currentY.contains(playerPos)){
                if (!lastY.isEmpty() && !lastY.substring(currentY.indexOf("x"), currentY.indexOf("x")+1).equals("#") && direction == "up")
                {
                    return true;
                }
                else if(!nextY.isEmpty() && !nextY.substring(currentY.indexOf("x"), currentY.indexOf("x")+1).equals("#") && direction == "down")
                {
                    return true;
                }
                else if(!currentY.substring(currentY.indexOf("x")+1, currentY.indexOf("x")+2).equals("#") && direction == "right")
                {
                    return true;
                }
                else if(!currentY.substring(currentY.indexOf("x")-1, currentY.indexOf("x")).equals("#") && direction == "left")
                {
                    return true;
                }
            }
        }
        return false;
    }

    private List<String> updateRoom(List<String> room, String direction){
        for (int i = 0; i < room.size();i++){
            String lastY = "";
            String nextY = "";
            if (1 < i){
                lastY = room.get(i-1);
            }
            if (i < room.size()-1){
                nextY = room.get(i+1);
            }
            CharSequence playerPos = "x";


            if (direction == "up"){
                if (room.get(i).contains(playerPos)){
                    int pos = room.get(i).indexOf('x');
                    StringBuilder newY = new StringBuilder(lastY);
                    newY.setCharAt(pos,'x');
                    room.set(i-1,newY.toString());
                    room.set(i,room.get(i).replace('x',' '));
                    return room;
                }
            }
            else if (direction == "down"){
                if (room.get(i).contains(playerPos)){
                    int pos = room.get(i).indexOf('x');
                    StringBuilder newY = new StringBuilder(nextY);
                    newY.setCharAt(pos,'x');
                    room.set(i+1,newY.toString());
                    room.set(i,room.get(i).replace('x',' '));
                    return room;
                }
            }
            else if(direction == "right"){
                if (room.get(i).contains(playerPos)) {
                    int pos = room.get(i).indexOf('x');
                    StringBuilder newY = new StringBuilder(room.get(i));
                    newY.replace(pos, pos + 2, " x");
                    room.set(i, newY.toString());
                    return room;
                }
            }
            else if (direction == "left"){
                if (room.get(i).contains(playerPos)){
                    int pos = room.get(i).indexOf('x');
                    StringBuilder newY = new StringBuilder(room.get(i));
                    newY.replace(pos-1, pos+1,"x ");
                    room.set(i, newY.toString());
                    return room;
                }
            }

        }
        return room;
    }
    private void movePlayer(Player player){
        List<String> currentRoom = new ArrayList<>(thisRoom.getRoom());
        io.print(thisRoom.getDescription());
        boolean upAllowed = allowedMove(currentRoom, "up");
        boolean downAllowed = allowedMove(currentRoom,"down");
        boolean rightAllowed = allowedMove(currentRoom,"right");
        boolean leftAllowed = allowedMove(currentRoom,"left");
        for (int i = 0; i < currentRoom.size();i++){
            io.print(currentRoom.get(i));
        }
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
            player.setPlayerPosX(player.getPlayerPosX()+1);
            thisRoom.setRoom(updateRoom(currentRoom,"up"));
        }
        if (move.equals("s") && downAllowed){
            player.setPlayerPosX(player.getPlayerPosX()-1);
            thisRoom.setRoom(updateRoom(currentRoom,"down"));
        }
        if (move.equals("d") && rightAllowed){
            player.setPlayerPosY(player.getPlayerPosY()+1);
            thisRoom.setRoom(updateRoom(currentRoom,"right"));
        }
        if (move.equals("a") && leftAllowed){
            player.setPlayerPosY(player.getPlayerPosY()-1);
            thisRoom.setRoom(updateRoom(currentRoom,"left"));
        }

    }

}
