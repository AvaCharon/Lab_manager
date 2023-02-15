package com.example.lab_manager.utils;

import java.util.HashMap;
import java.util.Map;

public class ResultsUtils {

    public static Map<String, String> resultsMap(String data, String msg){
        Map<String ,String> map = new HashMap<>();

        map.put("data", data);
        map.put("msg", msg);

        return map;
    }


}
