package com.devgustavo.dslist.services;

import com.devgustavo.dslist.dto.GameDTO;
import com.devgustavo.dslist.dto.GameMinDTO;
import com.devgustavo.dslist.entities.Game;
import com.devgustavo.dslist.projection.GameMinProjection;
import com.devgustavo.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();

        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        Game result = gameRepository.findById(gameId).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);

        return result.stream().map(GameMinDTO::new).toList();
    }
}