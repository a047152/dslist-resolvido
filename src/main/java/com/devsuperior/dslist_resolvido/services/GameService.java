package com.devsuperior.dslist_resolvido.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist_resolvido.repositories.GameRepository;
import com.devsuperior.dslist_resolvido.dto.GameDTO;
import com.devsuperior.dslist_resolvido.dto.GameMinDTO;
import com.devsuperior.dslist_resolvido.entities.Game;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

}
