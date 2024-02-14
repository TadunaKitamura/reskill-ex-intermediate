package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exintermediate.model.Hotel;
import com.example.exintermediate.repository.HotelRepository;

@Service
@Transactional
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> searchByLessThanPrice(String price) {

        if ("".equals(price)) {

            List<Hotel> hotelList = hotelRepository.findAll();

            return hotelList;

        } else {
            List<Hotel> hotelList = hotelRepository.searchByLessThanPrice(Integer.parseInt(price));

            return hotelList;

        }

    }
}
