package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping(method = RequestMethod.GET)
	public String getTicker(ModelMap model) {
		model.addAttribute("ticker", Ticker.createInstance());
		return "tickerPage";
	}

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTicker(@ModelAttribute("ticker") Ticker ticker, Model model){
        System.err.println(ticker);
        return "redirect://";
    }
}
