package com.devgustavo.dslist.services;


import com.devgustavo.dslist.dto.GameMinDTO;
import com.devgustavo.dslist.entities.Game;
import com.devgustavo.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();

        return result.stream().map(GameMinDTO::new).toList();
    }
}