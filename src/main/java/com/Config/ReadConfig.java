package com.Config;

import com.Enum.Browsers;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static com.Enum.URL.NAVIGATE;

public class ReadConfig {
    static FileInputStream file;
    static Properties prop;


    public static Properties loadFile() {

        try {
            file = new FileInputStream("src/main/java/com/Config/ReadConfig.properties");
            prop = new Properties();
            prop.load(file);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return prop;
    }

    public static Browsers getBrowser() {
        String strBrowser = loadFile().getProperty("browser");
        return switch (strBrowser.toUpperCase()) {
            case "CHROME" -> Browsers.CHROME;
            case "EDGE" -> Browsers.EDGE;
            case "FIREFOX" -> Browsers.FIREFOX;
            default -> throw new RuntimeException("The browser selected is not valid");
        };
    }

    public static String getUrl() {
        return NAVIGATE.getValue();
    }

    public static void setUrl() {
        String strUrl = loadFile().getProperty("url");
        if (strUrl != null) {
            NAVIGATE.setValue(strUrl);
        }
    }


}


