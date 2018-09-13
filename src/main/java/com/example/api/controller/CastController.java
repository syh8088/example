package com.example.api.controller;

import com.example.api.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CastController {

    private CastService castService;

    @Autowired
    public CastController(CastService castService) {
        this.castService = castService;
    }

    @GetMapping("/castList")
    public void getCastList() {
        castService.getCastList();
    }


}
