package com.example.springbootthymeleaf.service.impl;

import com.example.springbootthymeleaf.dao.SysPowerMapper;
import com.example.springbootthymeleaf.service.SysPowerService;
import com.example.springbootthymeleaf.view.PowerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysPwoerServiceImpl implements SysPowerService {
    @Autowired
    private SysPowerMapper sysPowerMapper;

    @Override
    public List<PowerVO> getPowerResource(Integer rid) {
        return sysPowerMapper.getPowerResource(rid);
    }

    @Override
    public int updateRolePower(Integer rid, String[] arr) {

        Map<String, Object> map = new HashMap<>();
        map.put("arr", arr);
        map.put("rid", rid);
        return sysPowerMapper.updateRolePower(map);
    }

    @Override
    public int deleteResourceByRid(Integer rid) {
        return sysPowerMapper.deleteResourceByRid(rid);
    }
}
