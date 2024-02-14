package com.example.exintermediate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediate.model.Hotel;

@Repository
public class HotelRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Hotel> H_ROW_MAPPER = (rs, rowNum) -> {

        Hotel hotel = new Hotel();
        hotel.setId(rs.getInt("id"));
        hotel.setAreaName(rs.getString("area_name"));
        hotel.setHotelName(rs.getString("hotel_name"));
        hotel.setAddress(rs.getString("address"));
        hotel.setNearestStation(rs.getString("nearest_station"));
        hotel.setPrice(rs.getInt("price"));
        hotel.setParking(rs.getString("parking"));

        return hotel;

    };

    /**
     * 入力金額以下のホテルを検索するメソッド.
     * @param price
     * @return
     */
    public List<Hotel> searchByLessThanPrice(Integer price){

        String SERACH_PRICE_QUERY = """
                
            SELECT 
                id
                ,area_name
                ,hotel_name
                ,address
                ,nearest_station
                ,price
                ,parking
            FROM
                hotels
            WHERE 
                price <= :price;
                """;

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("price", price);
        
        List<Hotel> hotelList = template.query(SERACH_PRICE_QUERY, sqlParameterSource, H_ROW_MAPPER);

        return hotelList;
    }

}
