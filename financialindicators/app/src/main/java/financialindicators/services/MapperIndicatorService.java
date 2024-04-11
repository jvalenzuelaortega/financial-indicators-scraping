package financialindicators.services;

import financialindicators.dto.request.IndicatorRequestDto;
import financialindicators.enums.FinancialIndicatorEnum;
import financialindicators.utils.SIteUtils;

public class MapperIndicatorService {

    public IndicatorRequestDto buildIndicatorRequestDto(String indicator, String domElement) {
        IndicatorRequestDto indicatorRequestDto = new IndicatorRequestDto();
        FinancialIndicatorEnum indicatorEnum = FinancialIndicatorEnum.getIndicatorByName(indicator);

        indicatorRequestDto.setIndicator(indicatorEnum);
        indicatorRequestDto.setIndicatorUrl(SIteUtils.getUrlByIndicator(indicatorEnum));
        indicatorRequestDto.setDomElement(domElement);
        indicatorRequestDto.setCharacter("=");
        return indicatorRequestDto;
    }
}
