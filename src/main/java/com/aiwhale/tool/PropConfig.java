package com.aiwhale.tool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class PropConfig {

    private static Logger logger = LogManager.getLogger(PropConfig.class.getName());

    private static Properties props = new Properties();

    public static void init() {
        try {
            //可添加多个配置文件
            String[] paths = new String[]{"conf/args.properties"};

            for (String path : paths) {
                Properties p = new Properties();
                InputStream resourceAsStream = Files.newInputStream(NativePath.get(path), StandardOpenOption.READ);
                InputStreamReader inputstreamreader = new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8);
                p.load(inputstreamreader);
                props.putAll(p);
            }
        } catch (IOException e) {
            logger.error("无法读取配置文件");
        }
    }

    public static Properties getProps() {
        if (props.size() == 0)
            init();
        return props;
    }

    public static String getProperty(String key) {
        if (props.size() == 0)
            init();
        return props.getProperty(key);
    }

    //environment
    public static String environment = getProperty("environment");
    //http_port
    public static String http_port = getProperty("http.port");

}
