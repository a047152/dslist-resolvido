package com.devsuperior.dslist_resolvido.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.dslist_resolvido.services.GameService;
import com.devsuperior.dslist_resolvido.dto.GameMinDTO;
import com.devsuperior.dslist_resolvido.dto.GameDTO;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/games")  
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
