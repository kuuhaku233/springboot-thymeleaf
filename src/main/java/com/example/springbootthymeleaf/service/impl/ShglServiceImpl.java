package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.ShglMapper;
import com.example.springbootthymeleaf.service.ShglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ShglServiceImpl implements ShglService {
    @Autowired
    ShglMapper shglMapper;
    @Override
    public List<Map<String, Object>> selectAll() {
        return shglMapper.selectAll();
    }

    @Override
    public Boolean qs(Map<String, Object> pamars) {
//        pamars.put("time", new Date());
        Integer result=shglMapper.qs(pamars);
        if(result == 1)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean addShxx(Map<String, Object> params) {
        Integer result=shglMapper.addShxx(params);
        if(result == 1)
        {
            return true;
        }
        return false;
    }
}
