package com.example.seng3210project;

public class Admin { // Generic class to hold the administrator's log-in info

    public String firstname,lastname,password,age;

    public Admin(){

    }
    public Admin(String firstname, String lastname, String password,String age){
    this.firstname = firstname;
    this.lastname = lastname;
    this.password = password;
    this.age = age;
    }

    // Setters and Getters for the administrator's info
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
