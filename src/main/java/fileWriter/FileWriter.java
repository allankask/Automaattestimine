package fileWriter;

import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.*;

public class FileWriter {


    public static void writeDataToFile(JSONObject jsonData){
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter("C:\\Users\\Allan\\Desktop\\output.txt");
            fileWriter.write(jsonData.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    public static void main(String[] args)  {
        JSONObject object = new JSONObject();
        object.put("cityName", "Tallinn");
        FileWriter.writeDataToFile(object);
    }*/
}
