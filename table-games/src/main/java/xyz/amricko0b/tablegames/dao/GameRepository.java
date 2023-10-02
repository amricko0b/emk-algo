package xyz.amricko0b.tablegames.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import xyz.amricko0b.tablegames.dao.jpa.JpaGame;

/**
 * @see JpaGame
 * @see PanacheRepository
 */
@ApplicationScoped
public class GameRepository implements PanacheRepository<JpaGame> {}
