package com.crumet.codecamp2018;

public class GuestModel {
    String name, title, desc, profileLink;

    public GuestModel(String name, String title, String desc, String profileLink) {
        this.name = name;
        this.title = title;
        this.desc = desc;
        this.profileLink = profileLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProfileLink() {
        return profileLink;
    }

    public void setProfileLink(String profileLink) {
        this.profileLink = profileLink;
    }
}
