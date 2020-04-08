package com.example.springbootthymeleaf.dao;

import java.util.List;
import java.util.Map;

public interface ShglMapper {

    List<Map<String,Object>> selectAll();

    Integer qs(Map<String, Object> pamars);

    Integer addShxx(Map<String, Object> pamars);
}
