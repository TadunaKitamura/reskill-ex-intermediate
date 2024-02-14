package com.example.exintermediate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.exintermediate.model.Team;
import com.example.exintermediate.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    /**
     * 球団一覧を表示する.
     * 
     * @param model リクエストスコープ
     * @return 球団情報一覧画面
     */
    @GetMapping("/showList")
    public String showList(Model model) {

        List<Team> teamList = teamService.showList();
        model.addAttribute("teamList", teamList);
        return "team/list";
    }

    /**
     * チームの詳細情報の表示.
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/showDetail")
    public String showDetail(@RequestParam("id") Integer id, Model model) {

        Team team = teamService.showDetail(id);
        model.addAttribute("team", team);

        return "team/detail";
    }

}
