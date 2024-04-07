/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package financialindicators;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.nodes.Document;

import financialindicators.config.JsoupConfig;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {

        HashMap<String, String> indicatorsMap = new HashMap<>();

        try {
            //TODO: dolar
            Document dolarDocument = JsoupConfig.getConnection("https://valordeldolar.cl/");
            String dolarContent = JsoupConfig.getElementBySite(dolarDocument, "vd");

            //TODO: euro
            Document euroDocument = JsoupConfig.getConnection("https://valordeleuro.cl/");
            String ueroContent = JsoupConfig.getElementBySite(euroDocument, "vd");

            //TODO: uf
            Document ufDocument = JsoupConfig.getConnection("https://valoruf.cl/");
            String ufContent = JsoupConfig.getElementBySite(ufDocument, "vpr");

            indicatorsMap.put("Dolar", dolarContent);
            indicatorsMap.put("Euro", ueroContent);
            indicatorsMap.put("UF", ufContent);

            indicatorsMap.forEach((key, value) -> System.out.println(key + " " + value));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
