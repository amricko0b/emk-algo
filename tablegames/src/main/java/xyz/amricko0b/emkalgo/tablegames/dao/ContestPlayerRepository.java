package xyz.amricko0b.emkalgo.tablegames.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import xyz.amricko0b.emkalgo.tablegames.dao.jpa.JpaContestPlayer;

@ApplicationScoped
public class ContestPlayerRepository implements PanacheRepository<JpaContestPlayer> {}
