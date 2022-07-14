package com.afisha.demo.dao.entity;

import javax.persistence.ManyToOne;

public class Category {
//    @ManyToOne
    private String uuid;
    private int dtCreate;
    private int dtUpdate;
    private String title;

    public Category() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(int dtCreate) {
        this.dtCreate = dtCreate;
    }

    public int getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(int dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
