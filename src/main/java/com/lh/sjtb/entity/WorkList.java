package com.lh.sjtb.entity;

/**
 * @author lihang
 * @Package com.lh.sjtb.entity
 * @date 2018/8/1414:43
 */
public class WorkList {

    private String oid;
    private String consultation_type; //咨询类型
    private String consultation_number; //咨询号码
    private String consultation_time; //咨询时间
    private String consultant_userid; //咨询人id
    private String consultant_name; //咨询人姓名
    private String consultant_sex; //咨询人性别
    private String consultant_area; //咨询人所属区域
    private String address; //联系地址
    private Integer status; //预约状态
    private String appeal_type; //诉求类型
    private String business_type; //业务类型
    private String appeal_title; //诉求主题
    private String appeal_content; //诉求内容
    private String create_user; //创建人
    private String create_time; //创建时间
    private String distribution_user; //分配人
    private String distribution_time; //分配时间

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getConsultation_type() {
        return consultation_type;
    }

    public void setConsultation_type(String consultation_type) {
        this.consultation_type = consultation_type;
    }

    public String getConsultation_number() {
        return consultation_number;
    }

    public void setConsultation_number(String consultation_number) {
        this.consultation_number = consultation_number;
    }

    public String getConsultation_time() {
        return consultation_time;
    }

    public void setConsultation_time(String consultation_time) {
        this.consultation_time = consultation_time;
    }

    public String getConsultant_userid() {
        return consultant_userid;
    }

    public void setConsultant_userid(String consultant_userid) {
        this.consultant_userid = consultant_userid;
    }

    public String getConsultant_name() {
        return consultant_name;
    }

    public void setConsultant_name(String consultant_name) {
        this.consultant_name = consultant_name;
    }

    public String getConsultant_sex() {
        return consultant_sex;
    }

    public void setConsultant_sex(String consultant_sex) {
        this.consultant_sex = consultant_sex;
    }

    public String getConsultant_area() {
        return consultant_area;
    }

    public void setConsultant_area(String consultant_area) {
        this.consultant_area = consultant_area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAppeal_type() {
        return appeal_type;
    }

    public void setAppeal_type(String appeal_type) {
        this.appeal_type = appeal_type;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public String getAppeal_title() {
        return appeal_title;
    }

    public void setAppeal_title(String appeal_title) {
        this.appeal_title = appeal_title;
    }

    public String getAppeal_content() {
        return appeal_content;
    }

    public void setAppeal_content(String appeal_content) {
        this.appeal_content = appeal_content;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDistribution_user() {
        return distribution_user;
    }

    public void setDistribution_user(String distribution_user) {
        this.distribution_user = distribution_user;
    }

    public String getDistribution_time() {
        return distribution_time;
    }

    public void setDistribution_time(String distribution_time) {
        this.distribution_time = distribution_time;
    }
}
