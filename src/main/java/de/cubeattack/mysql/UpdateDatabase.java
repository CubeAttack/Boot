package de.cubeattack.mysql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateDatabase {

    public static void create(){
        try (Connection conn = DatabaseProvider.source.getConnection();
             PreparedStatement stmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Data (Key VARCHAR(100) UNIQUE, Data1 VARCHAR(100))");) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String s){
        create();
        try (Connection conn = DatabaseProvider.source.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Data (Key, Data1) VALUES (?,?)");) {
            stmt.setString(1, s);
            stmt.setString(2, null);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
