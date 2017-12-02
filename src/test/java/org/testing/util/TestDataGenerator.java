package org.testing.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Random;

public class TestDataGenerator {

    public static void generatePostData(String fileName, int charCount, int postCount) {
        Writer writer = getWriter(/*"src/test/resources/jsons/" + */fileName);
        JSONObject object = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < postCount; i++) {
            String randomText = randomString(charCount);
            jsonArray.add(randomText);
        }
        object.put("posts", jsonArray);
        try {
            if (writer != null) {
                writer.write(object.toJSONString());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateCommentData(String fileName, int charCount, int commentCount) {
        Writer writer = getWriter(/*"src/test/resources/jsons/" + */fileName);
        JSONObject object = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < commentCount; i++) {
            String randomText = randomString(charCount);
            jsonArray.add(randomText);
        }
        object.put("comments", jsonArray);
        try {
            if (writer != null) {
                writer.write(object.toJSONString());
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static FileWriter getWriter(String fineName) {
        try {
            return new FileWriter(fineName);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String randomString(int charCount) {
        Random randomizer = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charCount; i++) {
            char randomChar = (char) (randomizer.nextInt(67) + 57);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }
}
