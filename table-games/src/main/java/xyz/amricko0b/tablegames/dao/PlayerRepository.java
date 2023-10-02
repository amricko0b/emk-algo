package xyz.amricko0b.tablegames.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import xyz.amricko0b.tablegames.dao.jpa.JpaPlayer;

/**
 * Репозиторий игроков
 *
 * @see JpaPlayer
 */
@ApplicationScoped
public class PlayerRepository implements PanacheRepository<JpaPlayer> {}
