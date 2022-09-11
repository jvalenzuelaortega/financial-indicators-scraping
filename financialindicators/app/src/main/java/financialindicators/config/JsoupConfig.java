package financialindicators.config;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupConfig {
	
	public static Document getConnection() throws IOException {
		Document doc = Jsoup.connect("https://valordeldolar.cl/").get();
		return doc;
	}
	
	public static String getElementBySite(Document doc, String element) {
		Elements content = doc.getElementsByClass(element);
		return content.text();
	}
}
