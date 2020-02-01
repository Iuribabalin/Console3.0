package com.company.lab_4;

public class HumanwithPropeller extends Human {
    private String messang = null;

    String fly(String place){
        this.messang = this.getName() + " улетел с ним на " + place + ".\n";
        return this.messang;
    }

}
