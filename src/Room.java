import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Morten on 04-02-2016.
 */
public class Room {
    IO io = new IO();
    private List<String> rooms = new ArrayList<>();
    private String description;
    private Monster monster;


    public void createRooms(){
        File roomDir = new File(this.getClass().getClassLoader().getResource("").getPath() + "Rooms/");
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
            String roomNameAndPath = roomDir + "Room" + (i + 1);
            io.WriteToFile(roomContent,roomNameAndPath);
        }
    }

    private List<String> loadRoom(String room){
        return io.readFromFile(room);
    }

    public void movePlayer(String move){

    }

}
