package net.hifor.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author IKin <br/>
 * @description json文件读取 <br/>
 * @create 2023/12/2 11:24 <br/>
 */
public class JsonFileReader {

    public static JSONObject readJsonObjectFile(String filePath) {
        String jsonContent = readFileContent(filePath);

        JSONObject jsonObject = null;
        if (jsonContent != null) {
            try {
                jsonObject = JSON.parseObject(jsonContent);
            } catch (Exception e) {
                System.out.println("Failed to convert JSON file: " + filePath);
            }
        } else {
            System.out.println("Failed to read JSON file: " + filePath);
        }
        return jsonObject;
    }

    public static JSONArray readJsonArrayFile(String filePath) {
        String jsonContent = readFileContent(filePath);

        JSONArray jsonArray = null;
        if (jsonContent != null) {
            try {
                jsonArray = JSON.parseArray(jsonContent);
            } catch (Exception e) {
                System.out.println("Failed to convert JSON file: " + filePath);
            }
        } else {
            System.out.println("Failed to read JSON file: " + filePath);
        }
        return jsonArray;
    }

    private static String readFileContent(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return contentBuilder.toString();
    }
}
