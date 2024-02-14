package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exintermediate.model.Clothe;
import com.example.exintermediate.service.ClotheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/clothe")
public class ClotheController {

    @Autowired
    private ClotheService clotheService;

    @GetMapping("/index")
    public String index() {
        return "clothe/search";
    }

    @PostMapping("/search")
    public List<Clothe> search(@RequestParam(value = "gender", required = false) String gender, @RequestParam(value = "color", required = false) String color, Model model) {

        List<Clothe> clothesList = clotheService.searchByColorAndGender(gender, color);
        model.addAttribute("clothesList", clothesList);

        return clothesList;
    }

}
