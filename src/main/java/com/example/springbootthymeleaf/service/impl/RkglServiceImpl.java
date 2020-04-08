package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.RkglMapper;
import com.example.springbootthymeleaf.service.RkglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class RkglServiceImpl implements RkglService {
    @Autowired
    RkglMapper rkglMapper;
    @Override
    public List<Map<String, Object>> findAll() {
        return rkglMapper.selectAll();
    }

    @Override
    public Boolean UpdateById(Map<String, Object> params) {
//        params.put("time", new Date());
        Integer result = rkglMapper.UpdateById(params);
        if(result>0)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean addRkxx(Map<String, Object> params) {
        params.put("time",new Date());
        Integer result= rkglMapper.addRkxx(params);
        if(result==1)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean delRkxx(Map<String, Object> params) {
        Integer result= rkglMapper.delRkxx(params);
        if(result==1)
        {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateRk(Map<String, Object> params) {
        Integer result= rkglMapper.updateRk(params);
        if(result==1)
        {
            return true;
        }
        return false;
    }

}
