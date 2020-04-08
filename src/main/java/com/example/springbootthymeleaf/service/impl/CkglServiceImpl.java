package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.CkglMapper;
import com.example.springbootthymeleaf.dao.RkglMapper;
import com.example.springbootthymeleaf.service.CkglService;
import com.example.springbootthymeleaf.service.RkglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CkglServiceImpl implements CkglService {
    @Autowired
    CkglMapper ckglMapper;

    @Override
    public Boolean UpdateById(Map<String, Object> params) {
        Integer integer = ckglMapper.UpdateById(params);
        if(integer==1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean addCkxx(Map<String, Object> params)
    {
        params.put("time",new Date());
        Integer integer = ckglMapper.addRkxx(params);
        if(integer==1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delCkxx(Map<String, Object> params) {
        Integer integer = ckglMapper.delRkxx(params);
        if(integer==1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateCk(Map<String, Object> params) {
        Integer integer= ckglMapper.updateRk(params);
        if(integer==1) {
            return true;
        }
        return false;
    }

    @Override
    public List<Map<String, Object>> selecck() {
        return ckglMapper.selecck();
    }
}
