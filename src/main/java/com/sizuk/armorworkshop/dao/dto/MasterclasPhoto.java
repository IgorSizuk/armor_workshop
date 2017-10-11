package com.sizuk.armorworkshop.dao.dto;

public class MasterclasPhoto {
    private int id;
    private int masterclassId;
    private String photoUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterclassId() {
        return masterclassId;
    }

    public void setMasterclassId(int masterclassId) {
        this.masterclassId = masterclassId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
