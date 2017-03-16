package com.test.framework.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 * Created by yang.wang@beecloud.com on 17-1-6.
 */
public class JsonLoader {
    private static String TIME_DAILY = "carrental_data/fee/time_daily.json";



    public static PayRuleJson loadDailyPayRule() throws FileNotFoundException, UnsupportedEncodingException {
        String dataFile = JsonLoader.class.getClassLoader().getResource(TIME_DAILY).getFile();
        Reader reader = new InputStreamReader(new FileInputStream(dataFile), "UTF-8");
        GsonBuilder builder = new GsonBuilder().setDateFormat("MM/dd/yyyy hh:mm");
        Gson gson = builder.create();
        return gson.fromJson(reader, PayRuleJson.class);
    }

}
