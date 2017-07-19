package com.springapp.mvc.service;

import com.springapp.mvc.dao.TickerDao;
import com.springapp.mvc.model.Ticker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TickerService {

    @Autowired(required = true)
    @Qualifier(value = "tickerDao")
    private TickerDao tickerDao;

    public void addTicker(Ticker ticker) {
        tickerDao.add(ticker);
    }

    public void updateTicker(Ticker ticker) {
        tickerDao.update(ticker);
    }

    public void removeTickerById(int id) {
        tickerDao.removeById(id);
    }

    public Ticker getTickerById(int id) {
        return tickerDao.getById(id);
    }

    public List<Ticker> getTickersList() {
        return tickerDao.getAll();
    }
}

