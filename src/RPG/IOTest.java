package RPG;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Morten on 25-02-2016.
 */
public class IOTest {

    @Test
    public void testWriteToFile() throws Exception {
        IO io = new IO();
        Path pathtofile = Paths.get("c:\\test\\test.txt");
        String[] writethis = {"some", "line"};
        File roomDir = new File("c:\\test");
        io.WriteToFile(roomDir ,pathtofile.toString(), writethis);
        assertTrue(Files.exists(pathtofile));
        Files.delete(pathtofile);
        roomDir.delete();
    }

    @Test
    public void testReadFromFile() throws Exception {
        IO io = new IO();
        Path pathtofile = Paths.get("c:\\test\\test.txt");
        String[] writethis = {"some", "line"};
        File roomDir = new File("c:\\test");
        List<String> fileContent;
        io.WriteToFile(roomDir ,pathtofile.toString(), writethis);
        fileContent = io.readFromFile(pathtofile.toString());

        assertTrue(fileContent.contains("some")&&fileContent.contains("line"));
        Files.delete(pathtofile);
        roomDir.delete();
    }
}