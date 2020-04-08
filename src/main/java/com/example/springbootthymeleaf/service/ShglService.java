package com.example.springbootthymeleaf.service;

import java.util.List;
import java.util.Map;

public interface ShglService {

    List<Map<String,Object>> selectAll();

    Boolean qs(Map<String, Object> pamars);

    Boolean addShxx(Map<String, Object> params);
}
