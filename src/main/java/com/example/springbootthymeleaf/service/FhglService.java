package com.example.springbootthymeleaf.service;

import java.util.List;
import java.util.Map;

public interface FhglService {

    List<Map<String, Object>> listAll();

    Boolean deleteYj(Map<String, Object> pamars);

    Boolean updateYj(Map<String, Object> pamars);

    Boolean curYj(Map<String, Object> pamars);

    Boolean insertYj(Map<String, Object> pamars);
}
