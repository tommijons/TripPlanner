package Hotel;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBFactory {
    // Ykkur vantar að setja upp .jar file fyrir jdbc sqlite
    String DATABASE_URL;
    Connection connection = null;


    public DBFactory() {
        File directory = new File("./src/database"); // path í möppuna sem gagnagrunnurinn er geymdur í.
        try {
            DATABASE_URL = "jdbc:sqlite:" + directory.getCanonicalPath() + "/hotelDataBase.db";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection connect() {
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}