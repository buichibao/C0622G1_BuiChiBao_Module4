package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

    private static Map<String, String> stringMap = new HashMap<>();

    static {
        stringMap.put("computer", "May tinh");
        stringMap.put("pen", "Cai but");
        stringMap.put("book", "sach");
        stringMap.put("phone", "Dien thoai");
    }

    @Override
    public String change(String english) {
        for (String eng : stringMap.keySet()) {
            if (eng.equals(english)) {
                return stringMap.get(eng);
            }
        }
        return "not found!";
    }
}

