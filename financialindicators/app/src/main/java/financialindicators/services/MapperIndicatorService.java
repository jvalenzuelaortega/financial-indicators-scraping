package financialindicators.services;

import financialindicators.dto.input.IndicatorInputDto;
import financialindicators.enums.FinancialIndicatorEnum;
import financialindicators.utils.GeneralUtils;

public class MapperIndicatorService {

    public IndicatorInputDto buildIndicatorRequestDto(String indicator, String domElement) {
        IndicatorInputDto indicatorInputDto = new IndicatorInputDto();
        FinancialIndicatorEnum indicatorEnum = FinancialIndicatorEnum.getIndicatorByName(indicator);

        indicatorInputDto.setIndicator(indicatorEnum);
        indicatorInputDto.setIndicatorUrl(GeneralUtils.getUrlByIndicator(indicatorEnum));
        indicatorInputDto.setDomElement(domElement);
        indicatorInputDto.setCharacter(buildCharacterForIndicator(indicatorEnum.name()));
        return indicatorInputDto;
    }

    private String buildCharacterForIndicator(String indicator) {
        return "DOLLAR".equals(indicator) || "EURO".equals(indicator) ? "=" : null;
    }
}
