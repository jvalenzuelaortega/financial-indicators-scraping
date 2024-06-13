package financialindicators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import financialindicators.dto.input.IndicatorInputDto;
import financialindicators.dto.output.IndicatorOutputDto;
import financialindicators.services.FinancialIndicatorService;
import financialindicators.services.MapperIndicatorService;

class AppTest {
	
    @Test
    void main_whenIndicatorIsDollar_thenReturnIndicator() {
    	MapperIndicatorService mapperIndicatorService = new MapperIndicatorService();
    	IndicatorInputDto indicatorInputDollarDto = mapperIndicatorService.buildIndicatorRequestDto("dollar", "vd");
    	FinancialIndicatorService financialIndicatorService = new FinancialIndicatorService();
    	
    	IndicatorOutputDto indicator = financialIndicatorService.getIndicatorOfName(indicatorInputDollarDto);
    	
    	assertEquals(indicator.getIndicatorName(), "DOLLAR");
    	assertEquals(indicator.getLocalDate(), LocalDate.now());
		assertNotNull(indicator.getValue());
    }
    
    @Test
	@Disabled
    void main_whenIndicatorIsEuro_thenReturnIndicator() {
    	MapperIndicatorService mapperIndicatorService = new MapperIndicatorService();
    	IndicatorInputDto indicatorInputDollarDto = mapperIndicatorService.buildIndicatorRequestDto("euro", "vd");
    	FinancialIndicatorService financialIndicatorService = new FinancialIndicatorService();
    	
    	IndicatorOutputDto indicator = financialIndicatorService.getIndicatorOfName(indicatorInputDollarDto);
    	
    	assertEquals(indicator.getIndicatorName(), "EURO");
    	assertEquals(indicator.getLocalDate(), LocalDate.now());
    	//assertEquals(indicator.getValue(), " $ 1042.04");
    }
    
    @Test
    void main_whenIndicatorIsUf_thenReturnIndicator() {
    	MapperIndicatorService mapperIndicatorService = new MapperIndicatorService();
    	IndicatorInputDto indicatorInputDollarDto = mapperIndicatorService.buildIndicatorRequestDto("uf", "vpr");
    	FinancialIndicatorService financialIndicatorService = new FinancialIndicatorService();
    	
    	IndicatorOutputDto indicator = financialIndicatorService.getIndicatorOfName(indicatorInputDollarDto);
    	
    	assertEquals(indicator.getIndicatorName(), "UF");
    	assertEquals(indicator.getLocalDate(), LocalDate.now());
    	assertNotNull(indicator.getValue());
    }

}
