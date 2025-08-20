package com.devsuperior.dslist_resolvido.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.dslist_resolvido.services.GameListService;
import com.devsuperior.dslist_resolvido.dto.GameListDTO;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/lists")  
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
