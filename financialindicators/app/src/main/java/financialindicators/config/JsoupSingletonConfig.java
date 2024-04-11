package financialindicators.config;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupSingletonConfig {

    private static Document document;

    private JsoupSingletonConfig() {
        if (document == null) {
            throw new RuntimeException();
        }
    }

    public static Document getInstance(String url) throws IOException {
        if(document == null){
            document = Jsoup.connect(url).get();
        }
        return document;
    }
}
