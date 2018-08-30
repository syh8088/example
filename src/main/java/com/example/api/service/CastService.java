package com.example.api.service;

import com.example.api.entities.cast.CastContents;
import com.example.api.repositories.cast.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CastService {

    private CastRepository castRepository;

    @Autowired
    public CastService(CastRepository castRepository) {
        this.castRepository = castRepository;
    }

    public void getCastList() {
        List<CastContents> castContentsList = castRepository.findAll();
        //HashMap<Long, CastContents> castContentsList = castRepository.findAll();


        //System.out.println(castContentsList);

        castContentsList.forEach((value) -> {

            System.out.println(value);
            //value.

        });

    }


}
