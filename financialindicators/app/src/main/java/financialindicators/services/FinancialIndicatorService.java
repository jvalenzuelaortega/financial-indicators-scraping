package financialindicators.services;

import financialindicators.config.JsoupSingletonConfig;
import financialindicators.dto.request.IndicatorRequestDto;
import financialindicators.dto.response.IndicatorResponseDto;
import financialindicators.utils.JsoupScrapingUtils;
import financialindicators.utils.RegexUtils;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.time.LocalDate;

public class FinancialIndicatorService {

    public IndicatorResponseDto getIndicatorOfName(IndicatorRequestDto indicatorRequestDto) throws IOException {
        Document document = JsoupSingletonConfig.getInstance(indicatorRequestDto.getIndicatorUrl());
        String dollarContent = JsoupScrapingUtils.getElementBySite(document, indicatorRequestDto.getDomElement());
        String formated = RegexUtils.getValueOfText(dollarContent, indicatorRequestDto.getCharacter());

        IndicatorResponseDto indicatorResponseDto = new IndicatorResponseDto();
        indicatorResponseDto.setIndicatorName(indicatorRequestDto.getIndicator().name());
        indicatorResponseDto.setValue(formated);
        indicatorResponseDto.setLocalDate(LocalDate.now());

        return indicatorResponseDto;
    }
}
