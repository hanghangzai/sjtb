package com.lh.sjtb.service;

import java.util.List;
import java.util.Map;

/**
 * @author lihang
 * @Package com.lh.sjtb.service.impl
 * @date 2018/8/1415:16
 */
public interface WorkListService {

    List<Map<String, Object>> findWorkList();

    List<Map<String, Object>> findWorkOrderList();

    List<Map<String, Object>> findWorkOrderTBList();

    void updateWorkOrderByOrderId(String orderid);

    void insertWorkList(Map<String, Object> map);
}
