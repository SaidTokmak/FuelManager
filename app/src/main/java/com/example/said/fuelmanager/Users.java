package com.example.said.fuelmanager;

public class Users {
    int id;
    String name,mail,info;
    int km;

    public Users() { }

    public Users(String name, String mail, String info, int km) {
        this.name = name;
        this.mail = mail;
        this.info = info;
        this.km = km;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getInfo() {
        return info;
    }

    public int getKm() {
        return km;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
