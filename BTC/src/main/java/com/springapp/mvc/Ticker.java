package com.springapp.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Ticker {

    private double mid;
    private double bid;
    private double ask;
    private double last_price;
    private double low;
    private double high;
    private double volume;
    private double timestamp;

    public static Ticker createInstance() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new URL("https://api.bitfinex.com/v1/pubticker/btcusd"), Ticker.class);

        } catch (IOException e){
            System.out.println("Exception creating ticker");
        }

        return null;
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

    public void refteshFields(){
        Ticker refreshedTicker = createInstance();

        this.timestamp = refreshedTicker.getTimestamp();
        this.mid = refreshedTicker.getMid();
        this.bid = refreshedTicker.getBid();
        this.ask = refreshedTicker.getAsk();
        this.low = refreshedTicker.getLow();
        this.high = refreshedTicker.getHigh();
        this.last_price = refreshedTicker.getLast_price();
        this.volume = refreshedTicker.getVolume();
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
