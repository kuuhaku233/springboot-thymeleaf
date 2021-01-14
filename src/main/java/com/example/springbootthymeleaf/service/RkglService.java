package com.example.springbootthymeleaf.service;

import java.util.List;
import java.util.Map;

public interface RkglService {
    List<Map<String,Object>> findAll();

    Boolean UpdateById(Map<String, Object> params);

    Boolean addRkxx(Map<String, Object> params);

    Boolean delRkxx(Map<String, Object> params);

    Boolean updateRk(Map<String, Object> params);

    List<Map<String,Object>> selectChange(Integer id);

}
