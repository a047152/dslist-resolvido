package com.devsuperior.dslist_resolvido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dslist_resolvido.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
    
}
