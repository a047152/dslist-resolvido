package com.devsuperior.dslist_resolvido.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist_resolvido.repositories.GameRepository;
import com.devsuperior.dslist_resolvido.dto.GameMinDTO;
import com.devsuperior.dslist_resolvido.entities.Game;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;  

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

}
