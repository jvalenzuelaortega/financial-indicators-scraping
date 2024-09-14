package financialindicators.services;

import financialindicators.config.PropertiesLoaderConfig;
import financialindicators.dto.data.IndicatorDataDto;
import financialindicators.enums.FinancialIndicatorEnum;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScrapingService {

    Logger logger = LoggerFactory.getLogger(ScrapingService.class);
    PropertiesLoaderConfig propertiesLoaderConfig = new PropertiesLoaderConfig("config.properties");

    public List<IndicatorDataDto> getAllIndicators(Document document) {
        List<IndicatorDataDto> indicators = new ArrayList<>();
        String[] indicatorNames = FinancialIndicatorEnum.getIndicatorNames();

        for (String name : indicatorNames) {
            IndicatorDataDto indicator = new IndicatorDataDto();
            indicator.setIndicatorName(name);
            indicator.setValue(document.getElementById(propertiesLoaderConfig.getProperty("element." + name)).html());
            indicator.setLocalDate(LocalDate.now());
            indicators.add(indicator);
        }

        logger.info("[getAllIndicators] Indicators found: {}", indicators.size());
        return indicators;
    }

    public String getIndicatorByName(Document document, String indicator) {
        String elementId = propertiesLoaderConfig.getProperty("element." + indicator);
        if (elementId != null) {
            return document.getElementById(elementId).html();
        }

        logger.error("[getIndicatorByName] Indicator not found: {}", indicator);
        return "Site not found";
    }

}
