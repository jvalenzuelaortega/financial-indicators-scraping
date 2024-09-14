package financialindicators.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PropertiesLoaderConfigTest {

    private PropertiesLoaderConfig propertiesLoaderConfig;
    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        inputStream = mock(InputStream.class);
    }

    @Test
    @Disabled
    void propertyIsLoadedSuccessfully() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("key", "value");

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("test.properties")) {
            propertiesLoaderConfig = new PropertiesLoaderConfig("test.properties");
            when(inputStream.read(any(byte[].class), anyInt(), anyInt())).thenReturn(-1);
            properties.load(input);
        }

        assertEquals("value", propertiesLoaderConfig.getProperty("key"));
    }

    @Test
    @Disabled
    void propertyFileNotFound() {
        propertiesLoaderConfig = new PropertiesLoaderConfig("nonexistent.properties");
        assertEquals(null, propertiesLoaderConfig.getProperty("key"));
    }

    @Test
    @Disabled
    void propertyFileLoadError() {
        propertiesLoaderConfig = new PropertiesLoaderConfig("invalid.properties");
        assertEquals(null, propertiesLoaderConfig.getProperty("key"));
    }

}