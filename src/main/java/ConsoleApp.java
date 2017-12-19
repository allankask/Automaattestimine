
import util.WeatherRequestUtil;
import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        ConsoleApp app = new ConsoleApp();
    }

    public ConsoleApp() {
        start();
    }

    public void start() {

        System.out.println("Please enter city name. " +
                "Example: Tallinn, Riga, Oslo, Helsinki, etc...");
        Scanner sc = new Scanner(System.in);

        //Gets city from scanner
        String cityName = sc.nextLine();

        String inputFilePath = System.getProperty("user.home") + "\\Desktop" + "\\input.txt";
        String outputFilePath = System.getProperty("user.home") + "\\Desktop" + "\\output.txt";

        WeatherRequestUtil.getWeatherDataByCityNameAndWriteToFile(
                inputFilePath, outputFilePath, cityName);
    }
}
