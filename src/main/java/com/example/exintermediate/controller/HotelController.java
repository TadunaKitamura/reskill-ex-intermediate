package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exintermediate.model.Hotel;
import com.example.exintermediate.service.HotelService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/index")
    public String index(Model model) {
        return "/hotel/search";
    }

    @PostMapping("/search")
    public List<Hotel> search(@RequestParam("price") String price, Model model) {

        List<Hotel> hotelList = hotelService.searchByLessThanPrice(price);
        model.addAttribute("hotelList", hotelList);
        return hotelList;

    }

}
