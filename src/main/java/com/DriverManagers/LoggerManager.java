package com.DriverManagers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerManager {

    public static final Logger logger = Logger.getLogger(LoggerManager.class);

    public LoggerManager() {
        initilaizeLogger();
    }

    public static void initilaizeLogger() {
        PropertyConfigurator.configure("./src/main/java/com/Config/log4j.properties");
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void error(String message) {
        logger.error(message);
    }


}
