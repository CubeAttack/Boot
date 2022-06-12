package de.cubeattack.mysql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class DatabaseProvider {


    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("dataSourceClassName", " org.mariadb.jdbc.MariaDbDataSource");
        props.setProperty("dataSource.serverName", "192.168.178.1");
        props.setProperty("dataSource.portNumber", "3306");
        props.setProperty("dataSource.user", "root");
        props.setProperty("dataSource.password", "Silvers@rfer1");
        props.setProperty("dataSource.databaseName", "Test");

        HikariConfig config = new HikariConfig(props);

        config.setMaximumPoolSize(10);

        DataSource source = new HikariDataSource(config);

        new UpdateDatabase(source);
        UpdateDatabase.update("irgendwas");
    }
}
