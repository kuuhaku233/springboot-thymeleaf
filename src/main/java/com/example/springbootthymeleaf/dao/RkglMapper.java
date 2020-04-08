package com.example.springbootthymeleaf.dao;

import java.util.List;
import java.util.Map;

public interface RkglMapper {
    List<Map<String,Object>> selectAll();

    Integer UpdateById(Map<String, Object> params);

    Integer addRkxx(Map<String, Object> params);

    Integer delRkxx(Map<String, Object> params);

    Integer updateRk(Map<String, Object> params);
}
