package test_data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GoRestTestData {

    public Map<String, String>dataKeyMap(String message){
        Map<String,String>dataKeyMap=new HashMap<>();
        dataKeyMap.put("message",message);

        return dataKeyMap;
    }

    public Map<String,Object>expectedData(Object meta,Map<String,String> data){
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("meta",meta);
        expectedData.put("data",data);

        return expectedData;

    }
}
