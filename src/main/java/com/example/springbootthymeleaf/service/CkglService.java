package com.example.springbootthymeleaf.service;

import java.util.List;
import java.util.Map;

public interface CkglService {

    Boolean UpdateById(Map<String, Object> params);

    Boolean addCkxx(Map<String, Object> params);

    Boolean delCkxx(Map<String, Object> params);

    Boolean updateCk(Map<String, Object> params);

    List<Map<String, Object>> selecck();
}
