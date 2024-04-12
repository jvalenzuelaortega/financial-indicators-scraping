/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package financialindicators;

import java.util.ArrayList;
import java.util.List;

import financialindicators.dto.input.IndicatorInputDto;
import financialindicators.dto.output.IndicatorOutputDto;
import financialindicators.services.FinancialIndicatorService;
import financialindicators.services.MapperIndicatorService;

public class App {

    public static void main(String[] args) {

        MapperIndicatorService mapperIndicatorService = new MapperIndicatorService();
        IndicatorInputDto indicatorInputDollarDto = mapperIndicatorService.buildIndicatorRequestDto("dollar", "vd");
        IndicatorInputDto indicatorInputEuroDto = mapperIndicatorService.buildIndicatorRequestDto("euro", "vd");
        IndicatorInputDto indicatorInputUFDto = mapperIndicatorService.buildIndicatorRequestDto("uf", "vpr");

        FinancialIndicatorService financialIndicatorService = new FinancialIndicatorService();
        IndicatorOutputDto dollarIndicator = financialIndicatorService.getIndicatorOfName(indicatorInputDollarDto);
        IndicatorOutputDto euroIndicator = financialIndicatorService.getIndicatorOfName(indicatorInputEuroDto);
        IndicatorOutputDto ufIndicator = financialIndicatorService.getIndicatorOfName(indicatorInputUFDto);

        List<IndicatorOutputDto> indicatorOutputList = new ArrayList<>();
        indicatorOutputList.add(dollarIndicator);
        indicatorOutputList.add(euroIndicator);
        indicatorOutputList.add(ufIndicator);

        indicatorOutputList.forEach(System.out::println);

    }
}
