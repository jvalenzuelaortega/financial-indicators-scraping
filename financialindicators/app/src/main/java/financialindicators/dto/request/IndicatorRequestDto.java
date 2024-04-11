package financialindicators.dto.request;

import financialindicators.enums.FinancialIndicatorEnum;

public class IndicatorRequestDto {

    private FinancialIndicatorEnum indicator;
    private String indicatorUrl;
    private String domElement;
    private String character;

    public FinancialIndicatorEnum getIndicator() {
        return indicator;
    }

    public void setIndicator(FinancialIndicatorEnum indicator) {
        this.indicator = indicator;
    }

    public String getIndicatorUrl() {
        return indicatorUrl;
    }

    public void setIndicatorUrl(String indicatorUrl) {
        this.indicatorUrl = indicatorUrl;
    }

    public String getDomElement() {
        return domElement;
    }

    public void setDomElement(String domElement) {
        this.domElement = domElement;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
