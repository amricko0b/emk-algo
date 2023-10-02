package xyz.amricko0b.tablegames.dao.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/** JPA-сущность */
@Getter
@Setter
@Entity(name = "Game")
@Table(name = "tg_game")
@EqualsAndHashCode(of = "guid")
public class JpaGame {

  /** GUID игры */
  @Id
  @GeneratedValue
  @Column(name = "guid", nullable = false)
  private UUID guid;

  /** Название игры */
  @Column(name = "title", nullable = false)
  private String title;
}
