package com.lh.sjtb.mqreceiver;

import com.lh.sjtb.service.WorkListService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihang
 * @Package com.lh.sjtb.mqreceiver
 * @date 2018/8/1510:16
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

    private final Logger logger = LoggerFactory.getLogger(TopicReceiver.class);

    @Autowired
    private WorkListService workListService;

    @RabbitHandler
    public void process(String message) {
        logger.info("Topic Receiver  : " + message);
        JSONObject json = JSONObject.fromObject(message);
        logger.info(" Receiver oid  : " + json.get("oid"));
        workListService.updateWorkOrderByOrderId(json.get("oid").toString());
        Map<String ,Object> map = JsonToMap(json);
        workListService.insertWorkList(map);
        logger.info("完成数据同步。");
    }

    private static Map<String, Object> JsonToMap(JSONObject json){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("oid",json.get("oid"));
        map.put("consultant_name",json.get("consultant_name"));
        map.put("consultant_sex",Ret_value(json.get("consultant_name")));
        map.put("consultant_area",Ret_value(json.get("consultant_area")));
        map.put("consultation_number",Ret_value(json.get("consultation_number")));
        map.put("business_type",Ret_value(json.get("business_type")));
        map.put("appeal_type",Ret_value(json.get("appeal_type")));
        map.put("appeal_title",Ret_value(json.get("appeal_title")));
        map.put("appeal_content",Ret_value(json.get("appeal_content")));
        map.put("status",Ret_value(json.get("status")));
        return map;
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
