package financialindicators.dto.data;

import java.time.LocalDate;

public class IndicatorDataDto {

    private String indicatorName;
    private String value;
    private String localDate;

    public IndicatorDataDto(String indicatorName, String value, String localDate) {
        this.indicatorName = indicatorName;
        this.value = value;
        this.localDate = localDate;
    }

    public IndicatorDataDto() {

    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public void setIndicatorName(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

}
