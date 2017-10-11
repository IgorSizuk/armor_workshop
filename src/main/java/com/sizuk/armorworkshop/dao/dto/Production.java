package com.sizuk.armorworkshop.dao.dto;


public class Production {
    private int id;
    private String albumName;
    private String albumPhotoUrl;
    private int link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumPhotoUrl() {
        return albumPhotoUrl;
    }

    public void setAlbumPhotoUrl(String albumPhotoUrl) {
        this.albumPhotoUrl = albumPhotoUrl;
    }

    public int getLink() {
        return link;
    }

    public void setLink(int link) {
        this.link = link;
    }
}
