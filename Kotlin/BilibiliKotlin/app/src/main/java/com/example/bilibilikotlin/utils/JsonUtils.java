package com.example.bilibilikotlin.utils;

import java.io.InputStream;

public class JsonUtils {
    public static String readJson(String jsonFile) {
        InputStream inputStream = FileUtils.openAssetFile(AppUtils.getAppContext(), jsonFile);
        String jsonStr = IOUtils.streamToString(inputStream);
        return jsonStr;
    }
}