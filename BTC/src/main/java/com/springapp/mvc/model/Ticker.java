package com.springapp.mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "tickers")
public class Ticker {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mid")
    private double mid;

    @Column(name = "bid")
    private double bid;

    @Column(name = "ask")
    private double ask;

    @Column(name = "last_price")
    private double last_price;

    @Column(name = "low")
    private double low;

    @Column(name = "high")
    private double high;

    @Column(name = "volume")
    private double volume;

    @Column(name = "timestamp")
    private double timestamp;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double volume) {
        this.mid = volume;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getLast_price() {
        return last_price;
    }

    public void setLast_price(double last_price) {
        this.last_price = last_price;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "mid=" + mid +
                ", bid=" + bid +
                ", ask=" + ask +
                ", last_price=" + last_price +
                ", low=" + low +
                ", high=" + high +
                ", volume=" + volume +
                ", timestamp=" + timestamp +
                '}';
    }
}
