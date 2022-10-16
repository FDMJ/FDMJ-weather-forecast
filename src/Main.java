import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Für welche Stadt soll das Wetter abgefragt werden?");
        Scanner input = new Scanner(System.in);
        String city = input.next();
        System.out.println("Das Wetter für " + city + " wird abgerufen:");
        WeatherFetcher wF = WeatherFetcher.getInstance();

        WeatherInfo[] wI = wF.fetch(city);

        for (WeatherInfo info : wI) {
            System.out.println(info.getTimestamp() + ": " + info.getTemperature());
        }
    }
}
