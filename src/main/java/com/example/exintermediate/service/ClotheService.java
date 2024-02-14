package com.example.exintermediate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exintermediate.model.Clothe;
import com.example.exintermediate.repository.ClotheRepository;

@Service
@Transactional
public class ClotheService {

    @Autowired
    private ClotheRepository clotheRepository;

    public List<Clothe> searchByColorAndGender(String gender, String color) {

        if ("".equals(gender) || "".equals(color)) {

            List<Clothe> clothesList = clotheRepository.findAll();
            return clothesList;

        } else {

            List<Clothe> clothesList = clotheRepository.searchByColorAndGender(Integer.parseInt(gender), color);

            return clothesList;
        }

    }

}
