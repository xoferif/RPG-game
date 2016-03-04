package RPG;
import java.sql.*;
/**
 * Created by Morten on 04-03-2016.
 */
public class SqlHandler {
    IO io = new IO();
    // JDBC driver name and database URL
    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/rpggame";

    //  Database credentials
    static String USER = "root";
    static String PASS = "password";

    public void insertintoDB(Game game){
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            io.print("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            io.print("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO player VALUES (1, game.player.getName(), Playername, game.player.getDescription(), game.player.getLevel())";
            ResultSet rs = stmt.executeQuery(sql);
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){se2.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    public void retrieveFromdB() {
        Connection conn = null;
        Statement stmt = null;
        try{
            //Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            io.print("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            io.print("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, Playername, playerDescription, playerlevel FROM player";
            ResultSet rs = stmt.executeQuery(sql);
            //Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String Playername = rs.getString("Playername");
                String playerDescription = rs.getString("playerDescription");
                int playerlevel = rs.getInt("playerlevel");

                //Display values
                io.print("ID: " + id);
                io.print(", Playername: " + Playername);
                io.print(", playerDescription: " + playerDescription);
                io.print(", playerlevel: " + playerlevel);
            }
            //Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){se2.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}

