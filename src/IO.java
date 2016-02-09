import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Morten on 09-02-2016.
 */
public class IO {
    public void Write(String string[], String path){


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
            System.out.println(e);
        }
    }
}
