/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Bill {
    private int bid;
    private int month;
    private float electric;
    private float water;
    private float reduce;
    private int rid;

    public Bill() {
    }

    public Bill(int bid, int month, float electric, float water, float reduce, int rid) {
        this.bid = bid;
        this.month = month;
        this.electric = electric;
        this.water = water;
        this.reduce = reduce;
        this.rid = rid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public float getElectric() {
        return electric;
    }

    public void setElectric(float electric) {
        this.electric = electric;
    }

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public float getReduce() {
        return reduce;
    }

    public void setReduce(float reduce) {
        this.reduce = reduce;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
