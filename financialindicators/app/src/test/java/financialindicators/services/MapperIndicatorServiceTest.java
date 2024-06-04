package financialindicators.services;

import org.junit.jupiter.api.Test;

import financialindicators.dto.input.IndicatorInputDto;
import financialindicators.enums.FinancialIndicatorEnum;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperIndicatorServiceTest {

    @Test
    void testIndicatorInputDto() {
        FinancialIndicatorEnum indicator = FinancialIndicatorEnum.DOLLAR;
        String indicatorUrl = "https://example.com";
        String domElement = "div";
        String character = "=";

        IndicatorInputDto indicatorInputDto = new IndicatorInputDto();
        indicatorInputDto.setIndicator(indicator);
        indicatorInputDto.setIndicatorUrl(indicatorUrl);
        indicatorInputDto.setDomElement(domElement);
        indicatorInputDto.setCharacter(character);

        assertEquals(indicator, indicatorInputDto.getIndicator());
        assertEquals(indicatorUrl, indicatorInputDto.getIndicatorUrl());
        assertEquals(domElement, indicatorInputDto.getDomElement());
        assertEquals(character, indicatorInputDto.getCharacter());
    }
}