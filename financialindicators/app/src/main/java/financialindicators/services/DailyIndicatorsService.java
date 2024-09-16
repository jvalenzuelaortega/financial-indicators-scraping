package financialindicators.services;

import financialindicators.config.JsoupSingletonConfig;
import financialindicators.config.PropertiesLoaderConfig;
import financialindicators.dto.ResponseDto;
import financialindicators.dto.data.IndicatorDataDto;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DailyIndicatorsService {

    Logger logger = LoggerFactory.getLogger(DailyIndicatorsService.class);
    PropertiesLoaderConfig propertiesLoaderConfig = new PropertiesLoaderConfig("config.properties");

    private final ScrapingService scrapingService;

    public DailyIndicatorsService(ScrapingService scrapingService) {
        this.scrapingService = scrapingService;
    }

    public ResponseDto getAllDailyIndicators() throws IOException {
        Document document = JsoupSingletonConfig.getInstance(propertiesLoaderConfig.getProperty("site.url"));
        List<IndicatorDataDto> listAllIndicators = scrapingService.getAllIndicators(document);
        if (listAllIndicators.isEmpty()) {
            logger.error("No indicators found");
            return new ResponseDto(404, "No indicators found", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), null);
        }

        logger.info("Get all indicators");
        return new ResponseDto(200, "Successfully", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), listAllIndicators);
    }

    public ResponseDto getDailyIndicatorByName(String indicatorName) throws IOException {
        Document document = JsoupSingletonConfig.getInstance(propertiesLoaderConfig.getProperty("site.url"));
        String indicatorValue = scrapingService.getIndicatorByName(document, indicatorName);

        logger.info("Value for indicator {} is {}", indicatorName, indicatorValue);

        return new ResponseDto(200, "Successfully", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), indicatorValue);
    }

}
