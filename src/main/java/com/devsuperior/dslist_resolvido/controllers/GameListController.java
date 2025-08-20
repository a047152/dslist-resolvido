package com.devsuperior.dslist_resolvido.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devsuperior.dslist_resolvido.services.GameListService;
import com.devsuperior.dslist_resolvido.services.GameService;
import com.devsuperior.dslist_resolvido.dto.GameListDTO;
import com.devsuperior.dslist_resolvido.dto.GameMinDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/lists")  
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;    

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
}
