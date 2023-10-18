package xyz.amricko0b.emkalgo.tablegames.dao.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ContestReport")
@Table(name = "tg_contest_report")
public class JpaContestReport {

  @Id
  @Column(name = "game_name")
  private String gameName;

  @Column(name = "total_players")
  private long totalPlayers;

  @Column(name = "total_contests")
  private long totalContests;
}
