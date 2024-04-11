package financialindicators.enums;

public enum FinancialIndicatorEnum {

    DOLLAR("dollar"),
    EURO("euro"),
    UF("uf");

    private final String indicatorName;

    FinancialIndicatorEnum(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public static FinancialIndicatorEnum getIndicatorByName(String name) {
        for (FinancialIndicatorEnum indicator : FinancialIndicatorEnum.values()) {
            if (indicator.indicatorName.equals(name)) {
                return indicator;
            }
        }
        return null;
    }
}
