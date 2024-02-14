package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exintermediate.model.Team;
import com.example.exintermediate.repository.TeamRepository;

@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> showList() {

        List<Team> teamList = teamRepository.findAll();

        return teamList;
    }

    public Team showDetail(Integer id) {

        Team team = teamRepository.load(id);

        return team;
    }

}
