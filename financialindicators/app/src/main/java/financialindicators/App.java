package financialindicators;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import financialindicators.dto.ResponseDto;
import financialindicators.services.DailyIndicatorsService;
import financialindicators.services.ScrapingService;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(App.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());

        var app = Javalin.create()
                .start(9090);

        ScrapingService scrapingService = new ScrapingService();
        DailyIndicatorsService dailyIndicatorsService = new DailyIndicatorsService(scrapingService);
        app.get("/get-all-indicators", ctx -> {

            ResponseDto<?> response = dailyIndicatorsService.getAllDailyIndicators();
            ctx.json(response);
        });

        app.get("/get-indicator", ctx -> {
            String indicatorName = ctx.queryParam("indicator");

            ResponseDto<?> response = dailyIndicatorsService.getDailyIndicatorByName(indicatorName);

            ctx.json(response);
        });
    }

}
