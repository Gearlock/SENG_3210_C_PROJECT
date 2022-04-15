package com.example.seng3210project;

public class Topic {
    String topicName,startDate,endDate;
    int Yes,No;
    public Topic(){

    }
    public Topic(String topicName,String startDate,String endDate,int Yes,int No){
        this.topicName = topicName;
        this.endDate = endDate;
        this.startDate = startDate;
        this.No = No;
        this.Yes = Yes;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getYes() {
        return Yes;
    }

    public void setYes(int Yes) {
        this.Yes = Yes;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

}
