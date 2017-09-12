package com.aiwhale;

import com.aiwhale.jetty.JettyServer;
import com.aiwhale.tool.DB_Client;
import com.aiwhale.tool.PropConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public class App {

    private static Logger logger = LogManager.getLogger(App.class.getClass());

    public static void main(String[] args) throws Exception {
        logger.info("当前启动环境：" + PropConfig.environment);
        //初始化mybatis
        DB_Client.init_pool();
        //启动jetty
        JettyServer.startJetty(Integer.parseInt(PropConfig.http_port), "/");
        logger.info("jetty start @" + PropConfig.http_port);
        Thread.currentThread().join();
    }
}
