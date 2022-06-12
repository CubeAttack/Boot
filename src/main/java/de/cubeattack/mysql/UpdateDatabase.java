package de.cubeattack.mysql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateDatabase {

    public static DataSource source;

    public UpdateDatabase(DataSource source) {
        UpdateDatabase.source = source;
    }

    public static void update(String s){
        try (Connection conn = source.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT some from stuff")) {
            stmt.setString(1, s);
            ResultSet rs = stmt.executeQuery();
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
