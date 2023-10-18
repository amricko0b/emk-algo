package xyz.amricko0b.emkalgo.tablegames.dao.jpa;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Contest")
@Table(name = "tg_contest")
@SequenceGenerator(name = "contest_gen", sequenceName = "tg_ids_seq")
public class JpaContest extends PanacheEntityBase {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(generator = "contest_gen", strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "game_name", nullable = false)
  private String gameName;

  @Column(name = "ticket_price", nullable = false)
  private BigDecimal ticketPrice;
}
