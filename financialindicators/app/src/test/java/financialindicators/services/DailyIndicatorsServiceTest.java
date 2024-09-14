package financialindicators.services;

import financialindicators.config.JsoupSingletonConfig;
import financialindicators.config.PropertiesLoaderConfig;
import financialindicators.dto.ResponseDto;
import financialindicators.dto.data.IndicatorDataDto;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DailyIndicatorsServiceTest {

    private DailyIndicatorsService dailyIndicatorsService;
    private ScrapingService scrapingService;
    private PropertiesLoaderConfig propertiesLoaderConfig;
    private Document document;

    private static final String SCRAPING_URL = "https://si3.bcentral.cl/Indicadoressiete/secure/Indicadoresdiarios.aspx";

    @BeforeEach
    void setUp() {
        scrapingService = mock(ScrapingService.class);
        propertiesLoaderConfig = mock(PropertiesLoaderConfig.class);
        document = mock(Document.class);
        dailyIndicatorsService = new DailyIndicatorsService(scrapingService);

        when(propertiesLoaderConfig.getProperty("site.url")).thenReturn(SCRAPING_URL);
    }

    @Test
    void getAllDailyIndicatorsSuccessfully() throws IOException {
        List<IndicatorDataDto> indicators = Arrays.asList(
                new IndicatorDataDto("uf", "value1", LocalDate.now()),
                new IndicatorDataDto("ivp", "value2", LocalDate.now()),
                new IndicatorDataDto("dollar", "value3", LocalDate.now()),
                new IndicatorDataDto("euro", "value4", LocalDate.now())
        );

        //when(JsoupSingletonConfig.getInstance(SCRAPING_URL)).thenReturn(document);
        when(scrapingService.getAllIndicators(document)).thenReturn(indicators);

        ResponseDto response = dailyIndicatorsService.getAllDailyIndicators();

        assertEquals(200, response.getCode());
        assertEquals("Successfully", response.getMessage());
        assertEquals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), response.getDate());
        assertEquals(indicators, response.getData());
    }

    @Test
    void getDailyIndicatorByNameSuccessfully() throws IOException {
        String indicatorName = "uf";
        String indicatorValue = "value1";

        when(propertiesLoaderConfig.getProperty("site.url")).thenReturn("http://example.com");
        when(scrapingService.getIndicatorByName(document, indicatorName)).thenReturn(indicatorValue);

        ResponseDto response = dailyIndicatorsService.getDailyIndicatorByName(indicatorName);

        assertEquals(200, response.getCode());
        assertEquals("Successfully", response.getMessage());
        assertEquals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), response.getDate());
        assertEquals(indicatorValue, response.getData());
    }

    @Test
    void getDailyIndicatorByNameNotFound() throws IOException {
        String indicatorName = "nonexistent";
        String indicatorValue = "Site not found";

        when(propertiesLoaderConfig.getProperty("site.url")).thenReturn("http://example.com");
        when(scrapingService.getIndicatorByName(document, indicatorName)).thenReturn(indicatorValue);

        ResponseDto response = dailyIndicatorsService.getDailyIndicatorByName(indicatorName);

        assertEquals(200, response.getCode());
        assertEquals("Successfully", response.getMessage());
        assertEquals(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), response.getDate());
        assertEquals(indicatorValue, response.getData());
    }

}