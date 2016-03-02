package RPG;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Morten on 09-02-2016.
 *
 * Class used for various system commands.
 */
public class IO {

    /**
     *
     * @param roomDir : Folder path
     * @param path : Absolute filepath to save file
     * @param string : Lines to write to file
     */
    public void WriteToFile(File roomDir, String path, String string[]){
        if (!roomDir.exists()){
            try{
                roomDir.mkdirs();
            }
            catch(SecurityException se){
            }
        }
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

        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param Path : # defines room level etc 'room1'
     * @return : List<String> RPG.Room details.
     */
    public List<String> readFromFile(String Path){
        List<String> roomList = new ArrayList<>();
        String file = Path;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                roomList.add(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return roomList;
    }

    /**
     *
     * @param string : Print string with System.out.println
     */
    public void print(String string){
        System.out.println(string);
    }

    /**
     *
     * @return <type>String</type>
     */
    public String scan(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
