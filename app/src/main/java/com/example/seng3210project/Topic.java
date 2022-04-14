package com.example.seng3210project;

public class Topic {
    String topicName,startDate,endDate;
    public Topic(){

    }
    public Topic(String topicName,String startDate,String endDate){
        this.topicName = topicName;
        this.endDate = endDate;
        this.startDate = startDate;
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
}
