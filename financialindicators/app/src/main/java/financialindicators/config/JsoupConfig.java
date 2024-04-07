package financialindicators.config;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupConfig {
	
	public static Document getConnection(String url) throws IOException {
		return Jsoup.connect(url).get();
	}
	
	public static String getElementBySite(Document doc, String element) {
		Elements content = doc.getElementsByClass(element);
		return content.text();
	}
}
