package assignmentsTests;

import org.junit.Test;
import util.WeatherRequestUtil;

public class AssignmentTest {
    @Test
    public void assignment3Test() {
        String inputFilePath = System.getProperty("user.home") + "\\Desktop" + "\\input.txt";
        String outputFilePath = System.getProperty("user.home") + "\\Desktop" + "\\output.txt";

        WeatherRequestUtil.getWeatherDataByCityNameAndWriteToFile(
                inputFilePath, outputFilePath, "Tallinn");
    }

    @Test
    public void assignment4Test() {
        String inputFilePath = System.getProperty("user.home") + "\\Desktop" + "\\input.txt";
        String desktopPath = System.getProperty("user.home") + "\\Desktop";

        WeatherRequestUtil.getWeatherDataByInputFileDataAndWriteIntoFile(inputFilePath, desktopPath);
    }
}
