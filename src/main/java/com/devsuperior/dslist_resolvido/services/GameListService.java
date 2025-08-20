package com.devsuperior.dslist_resolvido.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist_resolvido.repositories.GameListRepository;
import com.devsuperior.dslist_resolvido.dto.GameListDTO;
import com.devsuperior.dslist_resolvido.entities.GameList;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> listdto = result.stream().map(x -> new GameListDTO(x)).toList();
        return listdto;
    }

}
