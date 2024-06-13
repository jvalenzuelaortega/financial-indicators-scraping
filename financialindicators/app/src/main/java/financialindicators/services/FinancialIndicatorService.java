package financialindicators.services;

import financialindicators.config.JsoupSingletonConfig;
import financialindicators.dto.input.IndicatorInputDto;
import financialindicators.dto.output.IndicatorOutputDto;
import financialindicators.exceptions.UnknownSiteException;
import financialindicators.utils.JsoupScrapingUtils;
import financialindicators.utils.RegexUtils;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.LocalDate;

public class FinancialIndicatorService {

    public IndicatorOutputDto getIndicatorOfName(IndicatorInputDto indicatorInputDto) {
        IndicatorOutputDto indicatorOutputDto = new IndicatorOutputDto();
        try {
            Document document = JsoupSingletonConfig.getInstance(indicatorInputDto.getIndicatorUrl());
            String elementContent = JsoupScrapingUtils.getElementBySite(document, indicatorInputDto.getDomElement());
            String valueExtractedRegex = RegexUtils.getValueOfText(elementContent, indicatorInputDto.getCharacter());

            indicatorOutputDto.setIndicatorName(indicatorInputDto.getIndicator().name());
            indicatorOutputDto.setValue(valueExtractedRegex);
            indicatorOutputDto.setLocalDate(LocalDate.now());

            JsoupSingletonConfig.closeConnectionUrl();
        } catch(IOException e) {
            throw new UnknownSiteException(String.format("Error loading web page for Indicator %s", indicatorInputDto.getIndicator()), e);
        }

        return indicatorOutputDto;
    }
}
