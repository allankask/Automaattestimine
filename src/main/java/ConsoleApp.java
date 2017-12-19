
import com.sun.org.apache.xpath.internal.SourceTree;
import util.InputFileReader;
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
        String inputFilePath = System.getProperty("user.home") + "\\Desktop" + "\\input.txt";
        System.out.println(InputFileReader.getWeatherRequestCitysFromFile(inputFilePath));
        System.out.println("Please enter city name from the cities above: ");
        Scanner sc = new Scanner(System.in);

        //Gets city from scanner
        String cityName = sc.nextLine();

        String inputFilePathInfo = System.getProperty("user.home") + "\\Desktop" + "\\input.txt";
        String outputFilePath = System.getProperty("user.home") + "\\Desktop" + "\\output.txt";

        WeatherRequestUtil.getWeatherDataByCityNameAndWriteToFile(
                inputFilePathInfo, outputFilePath, cityName);
    }
}
