package util;

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
    public static void writeDataToFile(String filePath, JSONObject jsonData){
        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(filePath);
            fileWriter.write(jsonData.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
