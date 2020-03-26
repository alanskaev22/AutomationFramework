package com.learn.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Logging {
    /**
     * Implement this class in order to output logs
     */
    static Logger log = LogManager.getLogger(Logging.class);

    default void log(String args) {
        log.info(args);
    }

    static void logInfo(String args) {
        log.info(args);
    }
}
