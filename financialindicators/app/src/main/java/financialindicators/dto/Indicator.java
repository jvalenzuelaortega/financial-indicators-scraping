package financialindicators.dto;

import java.time.LocalDate;

public class Indicator {

    private int indicatorId;
    private String nameIndicator;
    private Double valueIndicator;
    private LocalDate dateIndicator;
    private int lotIndicator;

    public Indicator() {
    }

    public Indicator(int indicatorId, String nameIndicator, Double valueIndicator, LocalDate dateIndicator, int lotIndicator) {
        this.indicatorId = indicatorId;
        this.nameIndicator = nameIndicator;
        this.valueIndicator = valueIndicator;
        this.dateIndicator = dateIndicator;
        this.lotIndicator = lotIndicator;
    }

    public int getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(int indicatorId) {
        this.indicatorId = indicatorId;
    }

    public String getNameIndicator() {
        return nameIndicator;
    }

    public void setNameIndicator(String nameIndicator) {
        this.nameIndicator = nameIndicator;
    }

    public Double getValueIndicator() {
        return valueIndicator;
    }

    public void setValueIndicator(Double valueIndicator) {
        this.valueIndicator = valueIndicator;
    }

    public LocalDate getDateIndicator() {
        return dateIndicator;
    }

    public void setDateIndicator(LocalDate dateIndicator) {
        this.dateIndicator = dateIndicator;
    }

    public int getLotIndicator() {
        return lotIndicator;
    }

    public void setLotIndicator(int lotIndicator) {
        this.lotIndicator = lotIndicator;
    }

    @Override
    public String toString() {
        return "Indicator{" +
                "indicatorId=" + indicatorId +
                ", nameIndicator='" + nameIndicator + '\'' +
                ", valueIndicator=" + valueIndicator +
                ", dateIndicator=" + dateIndicator +
                ", lotIndicator=" + lotIndicator +
                '}';
    }
}
