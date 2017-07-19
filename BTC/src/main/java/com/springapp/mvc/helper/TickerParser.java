package com.springapp.mvc.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.mvc.model.Ticker;

import java.io.IOException;
import java.net.URL;


public class TickerParser {

    public static Ticker getCurrentTicker() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new URL("https://api.bitfinex.com/v1/pubticker/btcusd"), Ticker.class);

        } catch (IOException e){
            System.err.println("Exception while creating ticker:");
            e.printStackTrace();
        }

        return null;
    }
}
