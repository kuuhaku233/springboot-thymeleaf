package com.example.springbootthymeleaf.dao;

import java.util.List;
import java.util.Map;

public interface FhglMapper {

    List<Map<String, Object>> listAll();

    Integer deleteYj(Map<String, Object> pamars);

    Integer updateYj(Map<String, Object> pamars);

    Integer curYj(Map<String, Object> pamars);

    Integer insertYj(Map<String, Object> pamars);
}
