package de.cubeattack.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class DatabaseProvider {

    public static DataSource source;

    public static void main(String[] args) {
        Properties props = new Properties();

        props.setProperty("dataSource.user", "root");
        props.setProperty("dataSource.password", "");

        String host =  "192.168.178.1";
        String port =  "3306";
        String database = "Test";

        HikariConfig config = new HikariConfig(props);

        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database);

        config.setMaximumPoolSize(10);

        source = new HikariDataSource(config);

        UpdateDatabase.update("test");
    }
}
