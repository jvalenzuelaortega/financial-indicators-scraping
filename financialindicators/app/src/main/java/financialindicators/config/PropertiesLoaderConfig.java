package financialindicators.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoaderConfig {

    Logger logger = LoggerFactory.getLogger(PropertiesLoaderConfig.class);
    private Properties properties = new Properties();

    public PropertiesLoaderConfig(String filename) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (input == null) {
                logger.error("Sorry, unable to find {}", filename);
                return;
            }

            properties.load(input);
        } catch (Exception ex) {
            logger.error("Sorry, unable to load {}", filename, ex);
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
