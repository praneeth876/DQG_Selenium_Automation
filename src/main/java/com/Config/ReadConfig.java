package com.Config;

import com.Enum.Browsers;
import com.Enum.URL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.Enum.URL.DQGURL;

public class ReadConfig {
    static FileInputStream file;
    static Properties prop;
   // String strUrl;

public static  void loadFile() {

    try {
        file = new FileInputStream("C:\\Users\\PraneethReddyKatamre\\Desktop\\IntelliJ workspace\\DQG_Automation\\src\\main\\java\\com\\Config\\readConfig.properties");
        prop = new Properties();
        prop.load(file);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        throw new RuntimeException(e);

    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}

    public static Browsers getBrowser() {
        loadFile();
        String strBrowser = prop.getProperty("browser");
        System.out.println(strBrowser);
        System.out.println(prop.getProperty("url"));

        switch (strBrowser.toUpperCase()) {
            case "CHROME":
                return Browsers.CHROME;

            case "EDGE":
                return Browsers.EDGE;

            case "FIREFOX":
                return Browsers.FIREFOX;

            default:
                throw new RuntimeException("The browser selected is not valid");

        }
    }

public URL getUrl(){
    return DQGURL;
}

    public void setUrl(){
    //loadFile();
    String  strUrl= prop.getProperty("url");
    if(strUrl!=null){
        DQGURL.setValue(strUrl);
    }

    }

}


