package com.lh.sjtb.controller;

import com.lh.sjtb.service.WorkListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihang
 * @Package com.lh.sjtb.controller
 * @date 2018/8/1414:48
 */
@RestController
@RequestMapping("/WorkListController")
public class WorkListController {

    private final Logger logger = LoggerFactory.getLogger(WorkListController.class);
    @Autowired
    private WorkListService workListService;

    @RequestMapping("/WorkList")
    public @ResponseBody List<Map<String, Object>> WorkList(HttpServletRequest request, HttpServletResponse response){
        List<Map<String, Object>> list =  workListService.findWorkList();
        logger.info("---- size = "+list.size());
        return list;
    }

    @RequestMapping("/WorkOrderList")
    public @ResponseBody List<Map<String, Object>> WorkOrderList(HttpServletRequest request, HttpServletResponse response){
        List<Map<String, Object>> list =  workListService.findWorkOrderList();
        logger.info("---- size = "+list.size());
        return list;
    }

    @RequestMapping("/WorkOrderTb")
    public @ResponseBody List<Map<String, Object>> WorkOrderTb(HttpServletRequest request, HttpServletResponse response){
        List<Map<String, Object>> list =  workListService.findWorkOrderTBList();
        logger.info("---- size = "+list.size());
        return list;
    }

    @RequestMapping("/updateWorkOrderByOrderid")
    public @ResponseBody String updateWorkOrderByOrderid(HttpServletRequest request, HttpServletResponse response){
        workListService.updateWorkOrderByOrderId("634");
        return "1111";
    }

    @RequestMapping("/insertWorklist")
    public @ResponseBody String insertWorklist(HttpServletRequest request, HttpServletResponse response){
        List<Map<String, Object>> list =  workListService.findWorkOrderTBList();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("oid",list.get(0).get("ORDERID"));
        map.put("consultant_name",list.get(0).get("LDRXM"));
        map.put("consultant_sex",Ret_value(list.get(0).get("LDRXB")));
        map.put("consultant_area",Ret_value(list.get(0).get("LXDZ")));
        map.put("consultation_number",Ret_value(list.get(0).get("DH")));
        map.put("business_type",Ret_value(list.get(0).get("YWLX")));
        map.put("appeal_type",Ret_value(list.get(0).get("SQLB")));
        map.put("appeal_title",Ret_value(list.get(0).get("SQZT")));
        map.put("appeal_content",Ret_value(list.get(0).get("SQNR")));
        map.put("status",Ret_value(list.get(0).get("ORDERSTATUS")));
        workListService.insertWorkList(map);
        return "1111";
    }

    /**
     * 转化map空值
     * @return
     */
    public static String Ret_value(Object obj){
        if(obj != null && !obj.equals("")){
            return obj.toString();
        }else {
            return "";
        }
    }
}
