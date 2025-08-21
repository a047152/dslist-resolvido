package com.devsuperior.dslist_resolvido.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.devsuperior.dslist_resolvido.services.GameListService;
import com.devsuperior.dslist_resolvido.services.GameService;
import com.devsuperior.dslist_resolvido.dto.GameListDTO;
import com.devsuperior.dslist_resolvido.dto.GameMinDTO;
import com.devsuperior.dslist_resolvido.dto.ReplacementDTO; 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
