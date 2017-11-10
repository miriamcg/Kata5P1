package kata5p1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kata5P1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Desktop\\SQLiteDatabaseBrowserPortable\\Data\\KATA5.db");
        
        Statement statement = cn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT name FROM PEOPLE");
        
        while(rs.next()){
            System.out.println("NAME = " + rs.getString("name"));
        }
    }
}
