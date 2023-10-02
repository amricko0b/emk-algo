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
@Entity(name = "Player")
@Table(name = "tg_player")
@EqualsAndHashCode(of = "guid")
public class JpaPlayer {

  /** GUID игрока */
  @Id
  @GeneratedValue
  @Column(name = "guid", nullable = false)
  private UUID guid;

  /** Прозвище игрока */
  @Column(name = "nick_name", nullable = false)
  private String nickName;
}
