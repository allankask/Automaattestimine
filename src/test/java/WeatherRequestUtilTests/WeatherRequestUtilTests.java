package WeatherRequestUtilTests;

import org.junit.Before;
import org.junit.Test;
import util.WeatherRequestUtil;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Paths;

public class WeatherRequestUtilTests {
    private static String absolutePath = Paths.get("").toAbsolutePath().toString();
    private static String inputFilePath = new String(absolutePath + "\\src\\test\\java\\fileReaderTests\\input.txt");
    private static String outputFilePath = System.getProperty("user.home") + "\\Desktop";

    @Test
    public void testIfMethodGetWeatherDataByInputFileDataAndWriteIntoFileWorks(){
        assertTrue(WeatherRequestUtil.getWeatherDataByInputFileDataAndWriteIntoFile(inputFilePath,outputFilePath));
    }

    @Test
    public void testIfMethodGetWeatherDataByCityNameAndWriteToFileWorks(){
        assertTrue(WeatherRequestUtil.getWeatherDataByCityNameAndWriteToFile(inputFilePath,outputFilePath,"Tallinn"));
    }
}
