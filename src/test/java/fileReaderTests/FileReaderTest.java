package fileReaderTests;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import util.InputFileReader;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class FileReaderTest {
    private static String cityName;
    private static JSONObject content;
    private static String countryCode;
    private static String formatOfUnits;
    private static InputFileReader fileReaderMock;
    //private static String inputFilePath = System.getProperty("user.home") + "\\Desktop" + "\\input.txt";
    private static String absolutePath = Paths.get("").toAbsolutePath().toString();
    private static String inputFilePath = new String(absolutePath + "\\src\\test\\java\\fileReaderTests\\input.txt");


    @BeforeClass
    public static void setUp(){
        try {
            InputFileReader fileReadertest = new InputFileReader();
            cityName = "Tallinn";
            countryCode = "EE";
            formatOfUnits = "metric";
            fileReaderMock = mock(InputFileReader.class);
            JSONArray randomJsonArray = new JSONArray();
            JSONObject randomJsonObject = new JSONObject();
            randomJsonObject.put("cityName", "Tallinn");
            randomJsonObject.put("countryCode", "EE");
            randomJsonObject.put("formatOfUnits", "metric");
            randomJsonArray.add(randomJsonObject);
            when(fileReaderMock.readFileAsJSONArrayNonStatic(any(String.class))).thenReturn(randomJsonArray);

            JSONArray fileContent = fileReadertest.readFileAsJSONArrayNonStatic(inputFilePath);
            content = (JSONObject) fileContent.get(0);
        } catch (Exception e){
            fail("All tests failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfReaderReturnsCorrectCity(){
        try {
            assertEquals(cityName, content.get("cityName"));
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfReaderReturnsCorrectCountryCode(){
        try {
            assertEquals(countryCode, content.get("countryCode"));
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfReaderReturnsCorrectUnits(){
        try {
            assertEquals(formatOfUnits, content.get("formatOfUnits"));
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @Test
    public void testIfFileIsRead(){
        try {
            fileReaderMock.readDataFromFile("input.txt");
        } catch (Exception e){
            fail("Test failed because: " + e.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
    }
}
