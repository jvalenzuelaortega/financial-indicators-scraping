package financialindicators.utils;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupScrapingUtils {

    public static String getElementBySite(Document doc, String element) {
        Elements content = doc.getElementsByClass(element);
        return content.text();
    }
}
