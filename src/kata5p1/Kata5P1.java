package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Kata5P1 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usuario\\Desktop\\SQLiteDatabaseBrowserPortable\\Data\\KATA5.db");
        
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT name FROM PEOPLE");
        
        while(rs.next()){
            System.out.println("NAME = " + rs.getString("name"));
        }
        
        String query = "CREATE TABLE IF NOT EXISTS mail (\n"
                + "     id integer PRIMARY KEY AUTOINCREMENT ,\n"
                + "     mail text NOT NULL\n"
                + ");";
        
        System.out.println(query);
        st.execute(query);
        
        String nameFile = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata5P1\\src\\kata5p1\\emails.txt";
        ArrayList<String> mailList = new ArrayList<>();
        
        BufferedReader fileIn = new BufferedReader(new FileReader(new File(nameFile)));
        
        String mail;
        
        while((mail = fileIn.readLine()) != null){
            if(!mail.contains("@")){
                continue;
            }
            mailList.add(mail);
        }
        
        System.out.println(mailList.size());
        
        for (String m: mailList){
            query = "INSERT INTO MAIL (mail) VALUES ('" + m + "')";
            System.out.println(query);
            st.executeUpdate(query);
        }
        
    }
}
