package com.example.service.impl;

import com.example.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    private static Map<String,String> map = new HashMap<>();

    static {
        map.put("milk","sua bo");
        map.put("laptop","may tinh");
        map.put("money","tien");
        map.put("notebook","quyen vo");
        map.put("fan","quat");
    }

    public String find(String eng){
        for (String key:map.keySet()) {
            if(key.equals(eng)){
                return map.get(key);
            }
        }
        return "Not found";
    }
}
