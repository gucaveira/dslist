package com.devgustavo.dslist.repositories;

import com.devgustavo.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
