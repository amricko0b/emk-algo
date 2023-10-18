package xyz.amricko0b.emkalgo.tablegames.dao.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "PlayerReport")
@Table(name = "tg_player_report")
public class JpaPlayerReport {

  @Id
  @Column(name = "nick_name")
  private String nickName;

  @Column(name = "total_contests")
  private long totalContests;
}
