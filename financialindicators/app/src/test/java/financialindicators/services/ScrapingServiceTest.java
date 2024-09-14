package financialindicators.services;

import financialindicators.config.PropertiesLoaderConfig;
import financialindicators.dto.data.IndicatorDataDto;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ScrapingServiceTest {

    private ScrapingService scrapingService;
    private PropertiesLoaderConfig propertiesLoaderConfig;
    private Document document;

    @BeforeEach
    void setUp() {
        propertiesLoaderConfig = mock(PropertiesLoaderConfig.class);
        document = mock(Document.class);
        scrapingService = new ScrapingService();
    }

    @Test
    void getAllIndicatorsSuccessfully() {
        List<IndicatorDataDto> expectedIndicators = Arrays.asList(
                new IndicatorDataDto("uf", "value1", LocalDate.now()),
                new IndicatorDataDto("ivp", "value2", LocalDate.now()),
                new IndicatorDataDto("dollar", "value3", LocalDate.now()),
                new IndicatorDataDto("euro", "value4", LocalDate.now())
        );

        when(propertiesLoaderConfig.getProperty("element.uf")).thenReturn("ufId");
        when(propertiesLoaderConfig.getProperty("element.ivp")).thenReturn("ivpId");
        when(propertiesLoaderConfig.getProperty("element.dollar")).thenReturn("dollarId");
        when(propertiesLoaderConfig.getProperty("element.euro")).thenReturn("euroId");
        when(document.getElementById("ufId")).thenReturn(new Element("ufId").html("value1"));
        when(document.getElementById("ivpId")).thenReturn(new Element("ivpId").html("value2"));
        when(document.getElementById("dollarId")).thenReturn(new Element("dollarId").html("value3"));
        when(document.getElementById("euroId")).thenReturn(new Element("euroId").html("value4"));

        List<IndicatorDataDto> actualIndicators = scrapingService.getAllIndicators(document);

        assertEquals(expectedIndicators, actualIndicators);
    }

    @Test
    void getIndicatorByNameSuccessfully() {
        String indicatorName = "uf";
        String expectedValue = "value1";

        when(propertiesLoaderConfig.getProperty("element.uf")).thenReturn("ufId");
        when(document.getElementById("ufId")).thenReturn(new Element("ufId").html("value1"));

        String actualValue = scrapingService.getIndicatorByName(document, indicatorName);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getIndicatorByNameNotFound() {
        String indicatorName = "nonexistent";
        String expectedValue = "Site not found";

        when(propertiesLoaderConfig.getProperty("element.nonexistent")).thenReturn(null);

        String actualValue = scrapingService.getIndicatorByName(document, indicatorName);

        assertEquals(expectedValue, actualValue);
    }


}