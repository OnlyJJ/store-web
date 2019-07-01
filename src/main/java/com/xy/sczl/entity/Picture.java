package com.xy.sczl.entity;


import java.util.Date;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;


/**
 * 图片实体
 */
public class Picture {
    private Integer id;
    private String title;
    private String memo;
    private String url;
    private Date updateTime;
    private Admin updateAdmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Admin getUpdateAdmin() {
        return updateAdmin;
    }

    public void setUpdateAdmin(Admin updateAdmin) {
        this.updateAdmin = updateAdmin;
    }
}
