package financialindicators.services;

import financialindicators.config.JsoupSingletonConfig;
import financialindicators.config.PropertiesLoaderConfig;
import financialindicators.dto.ResponseDto;
import financialindicators.dto.output.IndicatorOutputDto;
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
        ResponseDto responseDto = new ResponseDto();

        Document document = JsoupSingletonConfig.getInstance(propertiesLoaderConfig.getProperty("site.url"));
        List<IndicatorOutputDto> listAllIndicators = scrapingService.getAllIndicators(document);

        logger.info("Get all indicators");

        responseDto.setCode(200);
        responseDto.setMessage("Successfully");
        responseDto.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        responseDto.setData(listAllIndicators);

        return responseDto;
    }

    public ResponseDto getDailyIndicatorByName(String indicatorName) throws IOException {
        ResponseDto responseDto = new ResponseDto();

        Document document = JsoupSingletonConfig.getInstance(propertiesLoaderConfig.getProperty("site.url"));
        String indicatorValue = scrapingService.getIndicatorByName(document, indicatorName);

        logger.info("Value for indicator {} is {}", indicatorName, indicatorValue);

        responseDto.setCode(200);
        responseDto.setMessage("Successfully");
        responseDto.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        responseDto.setData(indicatorValue);

        return responseDto;
    }

}
