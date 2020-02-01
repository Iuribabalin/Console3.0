package com.company.lab_4;

abstract class AbstractPlace implements IPlace{
    private String NamePlace;

    public void setNamePlace(String name) {
        NamePlace = name;
    }

    public String getName(){
        return NamePlace;
    }

    void RCoaster(){
        System.out.print("еще сильнее, чем на " + this.getName() + "\n");
    }

    String NamePlace(){
        return "место " + this.NamePlace + " создано\n";
    }

    public int hashCode(){
        return super.hashCode()+this.NamePlace.hashCode();
    }

    public boolean equals(Object obj) {
        return obj.hashCode()== this.hashCode() ? true : false;
    }
}
