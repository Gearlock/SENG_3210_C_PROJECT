package com.example.seng3210project;

public class Information {
    public String firstnameofUser,lastnameofUser,ageofUser, passwordofUser;
    public Information(){

    }
    public Information(String passwordofUser,String lastnameofUser,String firstnameofUser, String ageofUser){
        this.firstnameofUser = firstnameofUser;
        this.passwordofUser = passwordofUser;
        this.lastnameofUser = lastnameofUser;
        this.ageofUser = ageofUser;
    }

    public String getfirstnameofUser() {
        return firstnameofUser;
    }

    public void setfirstnameofUser(String firstnameofUser) {
        this.firstnameofUser = firstnameofUser;
    }

    public String getlastnameofUser() {
        return lastnameofUser;
    }

    public void setlastnameofUser(String lastnameofUser) {
        this.lastnameofUser = lastnameofUser;
    }

    public String getageofUser() {
        return ageofUser;
    }

    public void setageofUser(String ageofUser) {
        this.ageofUser = ageofUser;
    }

    public String getpasswordofUser() {
        return passwordofUser;
    }

    public void setpasswordofUser(String passwordofUser) {
        this.passwordofUser = passwordofUser;
    }
}
