package financialindicators.utils;

import financialindicators.enums.FinancialIndicatorEnum;

public class GeneralUtils {

    public static String getUrlByIndicator(FinancialIndicatorEnum financialIndicatorEnum) {
        return switch (financialIndicatorEnum) {
            case DOLLAR -> "https://valordeldolar.cl/";
            case EURO -> "https://valordeleuro.cl/";
            case UF -> "https://valoruf.cl/";
        };
    }
}
