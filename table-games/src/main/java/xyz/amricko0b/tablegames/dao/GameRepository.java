package xyz.amricko0b.tablegames.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import xyz.amricko0b.tablegames.dao.jpa.Game;

/**
 * @see Game
 * @see PanacheRepository
 */
@ApplicationScoped
public class GameRepository implements PanacheRepository<Game> {}
