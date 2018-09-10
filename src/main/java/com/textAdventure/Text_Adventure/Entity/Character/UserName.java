package com.textAdventure.Text_Adventure.Entity.Character;


public class UserName {

    private String userName;

    public UserName() {
    } // THIS IS REQUIRED FOR DESERIALISATION!        ##

    public UserName(String userName) {
        this.userName = userName;
    }


    public String getUserName() {
        return userName;
    }


}
