package fileWriterTests;

import org.json.simple.JSONObject;
import org.junit.Test;
import util.FileWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FileWriterTest {

    public static final String outputFilePath = System.getProperty("user.home") + "\\Desktop" + "\\mock_test.txt";

    @Test
    public void testIfOutputFileIsWritten(){
        FileWriter fileWriterMock = mock(FileWriter.class);
        JSONObject mockJsonObject = new JSONObject();
        mockJsonObject.put("city", "Tallinn");
        verify(fileWriterMock).writeDataToFile(outputFilePath, mockJsonObject);
    }
}
