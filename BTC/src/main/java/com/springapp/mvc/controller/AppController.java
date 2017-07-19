package com.springapp.mvc.controller;

import com.springapp.mvc.helper.TickerParser;
import com.springapp.mvc.model.Ticker;
import com.springapp.mvc.service.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    @Qualifier(value = "tickerService")
    private TickerService tickerService;

	@RequestMapping(value = "/tickers", method = RequestMethod.GET)
	public String getTickers(ModelMap model) {

        model.addAttribute("ticker", TickerParser.getCurrentTicker());
        model.addAttribute("tickers", tickerService.getTickersList());

		return "tickers";
	}

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTicker(@ModelAttribute("ticker") Ticker ticker, Model model){

        tickerService.addTicker(ticker);

        return "redirect:/tickers";
    }
}
