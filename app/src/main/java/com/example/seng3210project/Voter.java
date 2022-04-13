package com.example.seng3210project;

public class Voter { // Generic class to hold the log-in info of a voter

    public String firstname,lastname,password,age;

    public Voter(){

    }

    public Voter(String firstname,String lastname,String password,String age){
    this.age = age;
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
    }

    // Setters and Getters for the voter's info
    public String getAge() {
        return age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
