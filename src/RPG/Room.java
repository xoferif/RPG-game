package RPG;

import java.io.*;
import java.util.*;

/**
 * Created by Morten on 04-02-2016.
 */
public class Room {
    IO io = new IO();
    private List<String> rooms = new ArrayList<>();
    private boolean isLastRoom;
    private String description;
    private Monster monster;
    private Set<Integer> roomVisited = new HashSet<>();
    private int numberOfRooms = 6;
    private Random random = new Random();
    private File roomDir = new File(this.getClass().getClassLoader().getResource("").getPath() + "Rooms/");

    public void createRoomFiles() throws NullPointerException{
        rooms.add("##########;#x       #;#   .    #;#        #;# #      #;#        #;#        #;#      ¤ #;#   #    #;##########");
        rooms.add("##########;#        #;#     ¤  #;#        #;#        #;#  #     #;#        #;#        #;#  #     #;##########");
        rooms.add("##########;#        #;#        #;#        #;# #      #;#      # #;#        #;#  ¤     #;#        #;##########");
        rooms.add("##########;#        #;#        #;#    ¤   #;#        #;#  #     #;#        #;#        #;#        #;##########");
        rooms.add("##########;#        #;#        #;#    #   #;#        #;#        #;#  #     #;#        #;# ¤      #;##########");
        rooms.add("##########;#       ¤#;##       #;#        #;#    #   #;#        #;#        #;#        #;#        #;##########");
        if (!roomDir.exists()){
            try{
                roomDir.mkdir();
            }
            catch(SecurityException se){
            }

        }
        String[] roomContent;

        for (int i = 0; i < rooms.size(); i++)
        {

            roomContent = rooms.get(i).split(";");
            String roomNameAndPath = roomDir + "/RPG.Room" + (i + 1);
            io.WriteToFile(roomContent,roomNameAndPath);
        }
    }

    private Room(String description, Monster monster, Boolean isLastRoom) {
        this.description = description;
        this.monster = monster;
        this.isLastRoom = isLastRoom;
    }

    public Room() {
    }

    public List<String> loadRoom(String room){
        String path = roomDir + "/" + room;
        return io.readFromFile(path);
    }

    public boolean isLastRoom(){
        return isLastRoom;
    }

    public Room newNormalRoom(Monster monster) {
        if (roomVisited.size() == numberOfRooms) {
            roomVisited.clear();
        }
        int i;
        do {
            i = random.nextInt(numberOfRooms);
        } while (roomVisited.contains(i));
        roomVisited.add(i);

        String roomDescription = null;
        if (i == 0) {
            roomDescription = "A mist cellar with a funky smell";
        }
        else if (i == 1) {
            roomDescription = "A dark cave with crushed bones as floor";
        }
        else if (i == 2) {
            roomDescription = "A mystical forrest with horrifying sound from all sides ";
        }
        else if (i == 3) {
            roomDescription = "A Misty svamp, with almost no visibility";
        }
        else if (i == 4) {
            roomDescription = "An empty castle, all movements are overseen from the dark";
        }
        else if (i == 5) {
            roomDescription = "An old shipyard, littered with the remains of some unlucky sailors";
        }
        else if (i == 6) {
            roomDescription = "harsh lands, Seems no living organisms could live here";
        }
        else {
            roomDescription = "Seems to be an empty hallway";
        }
        return new Room(roomDescription, monster.newRandomInstance(), false);
    }

    public Room LastRoom(Monster monster) {
        return new Room("a huge cavern thick with the smell of death", monster.lastInstance(),
                true);
    }

    public boolean isComplete() {
        return !monster.alive();
    }

    //public RPG.Room updateMap(int playerPosY,int playerPosX){


    //}

}
