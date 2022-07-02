package de.cubeattack.mysql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateDatabase {

    public static void create(){
        try (Connection conn = DatabaseProvider.source.getConnection();
             PreparedStatement stmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Data (keyData VARCHAR(100) UNIQUE, value1 VARCHAR(100))");) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String s1,String s2){
        create();
        try (Connection conn = DatabaseProvider.source.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Data (keyData, value1) VALUES (?,?)");) {
            stmt.setString(1, s1);
            stmt.setString(2, s2);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
