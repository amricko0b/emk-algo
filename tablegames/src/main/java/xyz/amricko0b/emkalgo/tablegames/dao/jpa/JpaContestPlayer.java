package xyz.amricko0b.emkalgo.tablegames.dao.jpa;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ContestPlayer")
@Table(name = "tg_contest_player")
public class JpaContestPlayer extends PanacheEntityBase {

  @Id
  @Column(name = "nick_name", nullable = false)
  private String nickName;

  @ManyToOne
  @JoinColumn(name = "contest_id")
  private JpaContest contest;
}
