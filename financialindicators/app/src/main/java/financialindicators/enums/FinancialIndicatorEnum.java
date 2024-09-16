package financialindicators.enums;

import java.util.Arrays;

public enum FinancialIndicatorEnum {

    UF("uf"),
    IPV("ivp"),
    DOLLAR("dollar"),
    EURO("euro");

    private final String indicatorName;

    FinancialIndicatorEnum(String indicatorName) {
        this.indicatorName = indicatorName;
    }

    public String getIndicatorName() {
        return indicatorName;
    }

    public static String[] getIndicatorNames() {
        return Arrays.stream(FinancialIndicatorEnum.values())
                .map(FinancialIndicatorEnum::getIndicatorName)
                .toArray(String[]::new);
    }

    public static FinancialIndicatorEnum getIndicatorByName(String name) {
        return Arrays.stream(FinancialIndicatorEnum.values())
                .filter(indicator -> indicator.indicatorName.equals(name))
                .findFirst()
                .orElse(null);
    }

}
