package financialindicators.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static String getValueOfText(String text, String character) {
        String pattern = Pattern.quote(character) + "(.*?)$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(text);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
