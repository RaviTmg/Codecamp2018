package com.crumet.codecamp2018;

public class TeamModel {
    String name, shortDetail, ideaDesc, member1, member2, member3;


    public String getIdeaDesc() {
        return ideaDesc;
    }

    public void setIdeaDesc(String ideaDesc) {
        this.ideaDesc = ideaDesc;
    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }

    public String getMember2() {
        return member2;
    }

    public void setMember2(String member2) {
        this.member2 = member2;
    }

    public String getMember3() {
        return member3;
    }

    public void setMember3(String member3) {
        this.member3 = member3;
    }

    public TeamModel(String name, String shortDetail, String ideaDesc, String member1, String member2, String member3) {
        this.name = name;
        this.shortDetail = shortDetail;
        this.ideaDesc = ideaDesc;
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
    }

    public String getShortDetail() {
        return shortDetail;
    }

    public void setShortDetail(String shortDetail) {
        this.shortDetail = shortDetail;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamModel(String name, String shortDetail) {

        this.name = name;
        this.shortDetail = shortDetail;
    }
}
