package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.FhglMapper;
import com.example.springbootthymeleaf.dao.ShglMapper;
import com.example.springbootthymeleaf.service.FhglService;
import com.example.springbootthymeleaf.service.ShglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FhglServiceImpl implements FhglService {
    @Autowired
    FhglMapper fhglMapper;

    @Override
    public List<Map<String, Object>> listAll() {
        return fhglMapper.listAll();
    }

    @Override
    public Boolean deleteYj(Map<String, Object> pamars) {
        Integer result=fhglMapper.deleteYj(pamars);
        if(result == 1)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateYj(Map<String, Object> pamars) {
        Integer result=fhglMapper.updateYj(pamars);
        if(result == 1)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean curYj(Map<String, Object> pamars) {
        Integer result=fhglMapper.curYj(pamars);
        if(result == 1)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean insertYj(Map<String, Object> pamars) {
        Integer result=fhglMapper.insertYj(pamars);
        if(result == 1)
        {
            return true;
        }
        return false;
    }
}
