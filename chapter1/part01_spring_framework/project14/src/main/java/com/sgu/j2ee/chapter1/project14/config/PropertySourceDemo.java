package com.sgu.j2ee.chapter1.project14.config;

import com.sgu.j2ee.chapter1.project14.model.DataSourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:config.properties")
public class PropertySourceDemo implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertySourceDemo.class);

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Autowired
    private Environment env;

    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("Values injected via @Value:");
        LOGGER.info("Driver: {}", driver);
        LOGGER.info("URL: {}", url);
        LOGGER.info("Username: {}", username);
        LOGGER.info("Password: {}", password);

        setDatabaseConfig();
    }

    private void setDatabaseConfig() {
        LOGGER.info("Reading values via Spring Environment:");
        DataSourceConfig config = new DataSourceConfig();
        config.setDriver(env.getProperty("jdbc.driver"));
        config.setUrl(env.getProperty("jdbc.url"));
        config.setUsername(env.getProperty("jdbc.username"));
        config.setPassword(env.getProperty("jdbc.password"));

        System.out.println("DataSourceConfig instance created: " + config.toString());
    }
}
