import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Morten on 09-02-2016.
 */
public class IO {
    public void WriteToFile(String string[], String path){
        try{
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter out = new PrintWriter(br);
            for(int i=0; i<string.length; i++){
                if(string[i] != null) {
                    out.write(string[i]);
                }

                br.newLine();
            }
            out.close();
        }

        catch(IOException e){
            print(e.toString());
        }
    }
    public List<String> readFromFile(String room){
        List<String> roomList = new ArrayList<>();
        String file = this.getClass().getClassLoader().getResource("").getPath() + "/Rooms/" + room;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                roomList.add(line);
            }
        }
        catch (IOException iox){
            print(iox.toString());
        }
        return roomList;
    }
    public void print(String string){
        System.out.println(string);
    }

    public String scan(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
