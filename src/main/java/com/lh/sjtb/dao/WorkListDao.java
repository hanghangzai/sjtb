package com.lh.sjtb.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author lihang
 * @Package com.lh.sjtb.dao
 * @date 2018/8/1415:15
 */
@Component
public interface WorkListDao {

    List<Map<String, Object>> findWorkList();

    List<Map<String, Object>> findWorkOrderList();

    List<Map<String, Object>> findWorkOrderTBList();

    void updateWorkOrderByOrderId(@Param("orderid") String orderid);

    void insertWorkList(Map<String, Object> map);

}
