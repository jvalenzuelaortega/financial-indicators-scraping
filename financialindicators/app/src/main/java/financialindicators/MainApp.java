package financialindicators;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import financialindicators.dto.input.IndicatorInputDto;
import financialindicators.dto.output.IndicatorOutputDto;
import financialindicators.services.FinancialIndicatorService;
import financialindicators.services.MapperIndicatorService;
import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());

        var app = Javalin.create()
                .start(9090);

        app.get("/get-all-indicators", ctx -> {
            ctx.json(getAllIndicators());
        });
    }

    private static List<IndicatorOutputDto> getAllIndicators() {
        MapperIndicatorService mapperIndicatorService = new MapperIndicatorService();
        IndicatorInputDto indicatorInputDollarDto = mapperIndicatorService.buildIndicatorRequestDto("dollar", "vd");
        IndicatorInputDto indicatorInputUFDto = mapperIndicatorService.buildIndicatorRequestDto("uf", "vpr");

        FinancialIndicatorService financialIndicatorService = new FinancialIndicatorService();
        IndicatorOutputDto dollarIndicator = financialIndicatorService.getIndicatorOfName(indicatorInputDollarDto);
        IndicatorOutputDto ufIndicator = financialIndicatorService.getIndicatorOfName(indicatorInputUFDto);

        List<IndicatorOutputDto> indicatorOutputList = new ArrayList<>();
        indicatorOutputList.add(dollarIndicator);
        indicatorOutputList.add(ufIndicator);

        return indicatorOutputList;
    }
}
