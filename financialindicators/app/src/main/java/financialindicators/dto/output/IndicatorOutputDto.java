package financialindicators.dto.output;

import java.time.LocalDate;

public class IndicatorOutputDto {

    private String indicatorName;
    private String value;
    private LocalDate localDate;

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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "IndicatorResponseDto{" +
                "indicatorName='" + indicatorName + '\'' +
                ", value='" + value + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}
