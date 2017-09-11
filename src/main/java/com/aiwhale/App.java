package com.aiwhale;

import com.aiwhale.jetty.JettyServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public class App {

    private static Logger logger = LogManager.getLogger(App.class.getClass());

    public static void main(String[] args) throws Exception {
        JettyServer.startJetty(8080, "/");
        logger.info("jetty start @" + 8080);
        Thread.currentThread().join();
    }
}
