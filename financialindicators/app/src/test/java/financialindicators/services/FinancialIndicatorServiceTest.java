package financialindicators.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import financialindicators.dto.input.IndicatorInputDto;
import financialindicators.dto.output.IndicatorOutputDto;
import financialindicators.enums.FinancialIndicatorEnum;


class FinancialIndicatorServiceTest {

    @Test
    void getIndicatorOfName_whenIndicatorDtoIsDollar_thenReturnInformation() {
    	FinancialIndicatorService service = new FinancialIndicatorService();
    	IndicatorInputDto indicator = new IndicatorInputDto();
    	indicator.setIndicator(FinancialIndicatorEnum.DOLLAR);
    	indicator.setIndicatorUrl("https://valordeldolar.cl/");
    	indicator.setDomElement("vd");
    	indicator.setCharacter("");
    	
    	IndicatorOutputDto output = service.getIndicatorOfName(indicator);
    	
    	assertEquals(output.getIndicatorName(), "DOLLAR");
    	
    }
    
    @Test
    void getIndicatorOfName_whenIndicatorDtoIsEuro_thenReturnInformation() {
    	FinancialIndicatorService service = new FinancialIndicatorService();
    	IndicatorInputDto indicator = new IndicatorInputDto();
    	indicator.setIndicator(FinancialIndicatorEnum.EURO);
    	indicator.setIndicatorUrl("https://valordeleuro.cl/");
    	indicator.setDomElement("vd");
    	indicator.setCharacter("");
    	
    	IndicatorOutputDto output = service.getIndicatorOfName(indicator);
    	
    	assertEquals(output.getIndicatorName(), "EURO");
    	
    }
    
    @Test
    void getIndicatorOfName_whenIndicatorDtoIsUF_thenReturnInformation() {
    	FinancialIndicatorService service = new FinancialIndicatorService();
    	IndicatorInputDto indicator = new IndicatorInputDto();
    	indicator.setIndicator(FinancialIndicatorEnum.UF);
    	indicator.setIndicatorUrl("https://valoruf.cl/");
    	indicator.setDomElement("vpr");
    	indicator.setCharacter("");
    	
    	IndicatorOutputDto output = service.getIndicatorOfName(indicator);
    	
    	assertEquals(output.getIndicatorName(), "UF");
    	
    }

}