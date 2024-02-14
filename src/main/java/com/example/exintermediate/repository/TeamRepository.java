package com.example.exintermediate.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.model.Team;



@Repository
public class TeamRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Team> T_ROW_MAPPER = (rs, rowNum) -> {

        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setLeagueName(rs.getString("league_name"));
        team.setTeamName(rs.getString("team_name"));
        team.setHeadquarters(rs.getString("headquarters"));
        team.setInauguration(rs.getString("inauguration"));
        team.setHistory(rs.getString("history"));
        return team;
    };

    public List<Team> findAll() {

        String ALL_QUERY = """

                SELECT
                    id
                    ,league_name
                    ,team_name
                    ,headquarters
                    ,inauguration
                    ,history
                FROM
                    teams
                ORDER BY
                    inauguration;
                        """;

        List<Team> teamList = new ArrayList<>();

        teamList = template.query(ALL_QUERY, T_ROW_MAPPER);

        return teamList;
    }

    public Team load(Integer id) {

        String TEAM_QUERY = """
                SELECT
                    id
                    ,league_name
                    ,team_name
                    ,headquarters
                    ,inauguration
                    ,history
                FROM
                    teams
                WHERE
                    id = :id;
                    """;

        Team team = new Team();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id);

        team = template.queryForObject(TEAM_QUERY, sqlParameterSource, T_ROW_MAPPER);

        return team;
    }

}
