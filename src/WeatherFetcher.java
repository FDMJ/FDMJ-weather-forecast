import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class WeatherFetcher {

    private static WeatherFetcher instance;
    private WeatherFetcher(){

    };

    public static WeatherFetcher getInstance(){
        if (instance == null){
            instance = new WeatherFetcher();
        }
        return instance;
    }


    public WeatherInfo[] fetch(String city) throws  Exception{
        String uri = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&mode=xml&appid=-------";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();

        Document document = docBuilder.parse(uri);
        NodeList times = document.getElementsByTagName("time");

        WeatherInfo[] weatherInfos = new WeatherInfo[times.getLength()];

        for (int i = 0; i < times.getLength(); i++){
            Node time = times.item(i);
            NamedNodeMap timeAttributes = time.getAttributes();
            String timestamp = timeAttributes.getNamedItem("from").getNodeValue();

            NodeList children = time.getChildNodes();
            for (int j = 0; j < children.getLength(); j++){
                Node child = children.item(j);
                if (child.getNodeName().equals("temperature")){
                    String temp = child.getAttributes().getNamedItem("value").getNodeValue();
                    double temperature = Double.parseDouble(temp);
                    if(temperature > 200){
                        temperature -= 272.15;
                    }
                    weatherInfos[i] = new WeatherInfo(timestamp, Math.floor(temperature * 100) / 100);
                }
            }
        }

        return weatherInfos;

    }
}
