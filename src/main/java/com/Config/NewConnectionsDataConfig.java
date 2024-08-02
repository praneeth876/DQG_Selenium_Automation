package com.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class NewConnectionsDataConfig {

    static FileInputStream file;
    static Properties prop;

    public NewConnectionsDataConfig() {
        loadFile();
    }

    public static void loadFile() {

        try {
            file = new FileInputStream("src/main/java/com/Config/newConnection.properties");
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String getServer() {
        return prop.getProperty("Server");
    }

    public String getUsername() {
        return prop.getProperty("Username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }

    public String getDatabase() {
        return prop.getProperty("Database");
    }

    public String getAuthType() {
        return prop.getProperty("AuthenticationType");
    }

    public String getSchema() {
        return prop.getProperty("schema");
    }
}
