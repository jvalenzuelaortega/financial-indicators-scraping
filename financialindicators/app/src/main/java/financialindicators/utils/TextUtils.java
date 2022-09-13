package financialindicators.utils;

public class TextUtils {

    public static String splitText(String text, int beginIndex, int endIndex) {
        String textOutput = "";
        if (text.length() > 7) {
            textOutput = text.substring(beginIndex, endIndex);
            return textOutput;
        }
        return textOutput;
    }
}
