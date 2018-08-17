package com.lh.sjtb.service.impl;

import com.lh.sjtb.dao.WorkListDao;
import com.lh.sjtb.datasource.DatabaseContextHolder;
import com.lh.sjtb.datasource.DatabaseType;
import com.lh.sjtb.service.WorkListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author lihang
 * @Package com.lh.sjtb.service.impl
 * @date 2018/8/1415:17
 */
@Service("workListService")
public class WorkListServiceImpl implements WorkListService {

    @Autowired
    private WorkListDao workListDao;
    @Override
    public List<Map<String, Object>> findWorkList() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        return workListDao.findWorkList();
    }

    @Override
    public List<Map<String, Object>> findWorkOrderList() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        return workListDao.findWorkOrderList();
    }

    @Override
    public List<Map<String, Object>> findWorkOrderTBList() {
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        return workListDao.findWorkOrderTBList();
    }

    public void updateWorkOrderByOrderId(String orderid){
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb);
        workListDao.updateWorkOrderByOrderId(orderid);
    }

    public void insertWorkList(Map<String , Object> map){
        DatabaseContextHolder.setDatabaseType(DatabaseType.mytestdb2);
        workListDao.insertWorkList(map);
    };
}
