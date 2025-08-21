package com.devsuperior.dslist_resolvido.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.devsuperior.dslist_resolvido.repositories.GameListRepository;
import com.devsuperior.dslist_resolvido.repositories.GameRepository;
import com.devsuperior.dslist_resolvido.dto.GameListDTO;
import com.devsuperior.dslist_resolvido.entities.GameList;
import com.devsuperior.dslist_resolvido.projections.GameMinProjection;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> listdto = result.stream().map(x -> new GameListDTO(x)).toList();
        return listdto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min;

        if(sourceIndex < destinationIndex) {
            min = sourceIndex;
        } else {
            min = destinationIndex;
        }

        int max;

        if(sourceIndex < destinationIndex) {
            max = destinationIndex;
        } else {
            max = sourceIndex;
        }

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }


    }

}
