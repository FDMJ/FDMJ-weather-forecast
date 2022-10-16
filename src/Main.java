import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Main {
    public static void main(String[] args) throws Exception{

        String uri = "https://api.openweathermap.org/data/2.5/forecast?q=Berlin&mode=xml&appid=7e9a538ad8dcdf3337e1a98745582ee8";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();

        Document document = docBuilder.parse(uri);

        System.out.println(document.getDocumentElement().getTagName());

        factory.newDocumentBuilder().parse(uri);

    }
}
