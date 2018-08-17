package com.lh.sjtb.timer;

import com.lh.sjtb.service.WorkListService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lihang
 * @Package com.lh.sjtb.timer
 * @date 2018/8/1416:57
 */
@Component
public class QuartzService {

    private final Logger logger = LoggerFactory.getLogger(QuartzService.class);

    @Autowired
    private WorkListService workListService;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    //    每分钟启动
    @Scheduled(cron = "0 0/1 * * * ?")
    public void timerToNow(){
        logger.info("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        List<Map<String, Object>> list = workListService.findWorkOrderTBList();
        if(list!=null && list.size()>0){
            for(int i=0; i<list.size(); i++){
                JSONObject json = new JSONObject();
                json.put("oid",list.get(i).get("ORDERID"));
                json.put("consultant_name",Ret_value(list.get(i).get("LDRXM")));
                json.put("consultant_sex",Ret_value(list.get(i).get("LDRXB")));
                json.put("consultant_area",Ret_value(list.get(i).get("LXDZ")));
                json.put("consultation_number",Ret_value(list.get(i).get("DH")));
                json.put("business_type",Ret_value(list.get(i).get("YWLX")));
                json.put("appeal_type",Ret_value(list.get(i).get("SQLB")));
                json.put("appeal_title",Ret_value(list.get(i).get("SQZT")));
                json.put("appeal_content",Ret_value(list.get(i).get("SQNR")));
                json.put("status",Ret_value(list.get(i).get("ORDERSTATUS")));
                logger.info("send = "+json);
                this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", json.toString());
            }
        }else{
            logger.info("无同步数据。");
        }
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
