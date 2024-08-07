package financialindicators.services;

import financialindicators.config.PropertiesLoaderConfig;
import financialindicators.dto.output.IndicatorOutputDto;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScrapingService {

    Logger logger = LoggerFactory.getLogger(ScrapingService.class);
    PropertiesLoaderConfig propertiesLoaderConfig = new PropertiesLoaderConfig("config.properties");

    public List<IndicatorOutputDto> getAllIndicators(Document document) {
        List<IndicatorOutputDto> indicators = new ArrayList<>();

        IndicatorOutputDto ufIndicator = new IndicatorOutputDto();
        ufIndicator.setIndicatorName("uf");
        ufIndicator.setValue(document.getElementById(propertiesLoaderConfig.getProperty("element.uf")).html());
        ufIndicator.setLocalDate(LocalDate.now());

        IndicatorOutputDto ivpIndicator = new IndicatorOutputDto();
        ivpIndicator.setIndicatorName("ivp");
        ivpIndicator.setValue(document.getElementById(propertiesLoaderConfig.getProperty("element.ivp")).html());
        ivpIndicator.setLocalDate(LocalDate.now());

        IndicatorOutputDto dollarIndicator = new IndicatorOutputDto();
        dollarIndicator.setIndicatorName("dollar");
        dollarIndicator.setValue(document.getElementById(propertiesLoaderConfig.getProperty("element.dollar")).html());
        dollarIndicator.setLocalDate(LocalDate.now());

        IndicatorOutputDto euroIndicator = new IndicatorOutputDto();
        euroIndicator.setIndicatorName("euro");
        euroIndicator.setValue(document.getElementById(propertiesLoaderConfig.getProperty("element.euro")).html());
        euroIndicator.setLocalDate(LocalDate.now());

        indicators.add(ufIndicator);
        indicators.add(ivpIndicator);
        indicators.add(dollarIndicator);
        indicators.add(euroIndicator);

        return indicators;
    }

    public String getIndicatorByName(Document document, String indicator) {
        switch (indicator){
            case "uf":
                String UFValue = document.getElementById(propertiesLoaderConfig.getProperty("element.uf")).html();
                return UFValue;
            case "ipv":
                String IVPValue = document.getElementById(propertiesLoaderConfig.getProperty("element.ivp")).html();
                return IVPValue;
            case "dollar":
                String observedDollar = document.getElementById(propertiesLoaderConfig.getProperty("element.dollar")).html();
                return observedDollar;
            case "euro":
                String euro = document.getElementById(propertiesLoaderConfig.getProperty("element.euro")).html();
                return euro;
            default:
                return "Site not found";
        }
    }

}
