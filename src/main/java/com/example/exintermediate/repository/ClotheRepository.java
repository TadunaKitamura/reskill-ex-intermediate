package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.model.Clothe;

@Repository
public class ClotheRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Clothe> C_ROW_MAPPER = (rs, rowNum) -> {

        Clothe clothe = new Clothe();
        clothe.setId(rs.getInt("id"));
        clothe.setCategory(rs.getString("category"));
        clothe.setGenre(rs.getString("genre"));
        clothe.setGender(rs.getInt("gender"));
        clothe.setColor(rs.getString("color"));
        clothe.setPrice(rs.getInt("price"));
        clothe.setSize(rs.getString("size"));

        return clothe;

    };

    public List<Clothe> searchByColorAndGender(Integer gender, String color) {

        String SEARCH_COLOR_QUERY = """

        SELECT 
            id
            ,category
            ,genre
            ,gender
            ,color
            ,price
            ,size
        FROM
            clothes
        WHERE 
            gender = :gender
        AND 
            color = :color ;

                """;

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("gender", gender)                
        .addValue("color", color);

        List<Clothe> clothesList = template.query(SEARCH_COLOR_QUERY, sqlParameterSource, C_ROW_MAPPER);

        return clothesList;

    }
    public List<Clothe> findAll() {

        String ALL_QUERY = """

        SELECT 
            id
            ,category
            ,genre
            ,gender
            ,color
            ,price
            ,size
        FROM
            clothes
                """;

        List<Clothe> clothesList = template.query(ALL_QUERY, C_ROW_MAPPER);

        return clothesList;

    }

}
