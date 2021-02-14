package com.example.said.fuelmanager;

public class FuelManager {
    int fuel_id;
    String liter_price,liter_amount,last_km,datea;
    int fuel_user_id;

    public FuelManager() {
    }

    public FuelManager(String liter_price, String liter_amount, String last_km) {
        this.liter_price = liter_price;
        this.liter_amount = liter_amount;
        this.last_km = last_km;
    }

    public int getFuel_id() {
        return fuel_id;
    }

    public String getLiter_price() {
        return liter_price;
    }

    public String getLiter_amount() {
        return liter_amount;
    }

    public String getLast_km() {
        return last_km;
    }

    public String getDatea() {
        return datea;
    }

    public int getFuel_user_id() {
        return fuel_user_id;
    }

    public void setFuel_id(int fuel_id) {
        this.fuel_id = fuel_id;
    }

    public void setLiter_price(String liter_price) {
        this.liter_price = liter_price;
    }

    public void setLiter_amount(String liter_amount) {
        this.liter_amount = liter_amount;
    }

    public void setLast_km(String last_km) {
        this.last_km = last_km;
    }

    public void setDatea(String datea) {
        this.datea = datea;
    }

    public void setFuel_user_id(int fuel_user_id) {
        this.fuel_user_id = fuel_user_id;
    }
}