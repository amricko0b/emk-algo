package xyz.amricko0b.tablegames.command;

import an.awesome.pipelinr.Command;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Objects;
import xyz.amricko0b.tablegames.command.event.PlayerCreated;
import xyz.amricko0b.tablegames.command.execption.BadCommandException;
import xyz.amricko0b.tablegames.dao.PlayerRepository;
import xyz.amricko0b.tablegames.dao.jpa.JpaPlayer;

/**
 * Обработчик команды
 *
 * @see CreatePlayer
 */
@ApplicationScoped
public class CreatePlayerHandler implements Command.Handler<CreatePlayer, PlayerCreated> {

  /** Репозиторий игроков */
  private final PlayerRepository repository;

  @Inject
  public CreatePlayerHandler(PlayerRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional
  public PlayerCreated handle(CreatePlayer createPlayer) {

    var nickName = createPlayer.nickName();

    if (Objects.isNull(nickName) || nickName.isBlank()) {
      throw new BadCommandException("Player name must not be null or blank");
    }

    var exists = repository.find("nickName", nickName).count() != 0;
    if (exists) {
      throw new BadCommandException("Player " + nickName + " already exists");
    }

    var entity = new JpaPlayer();
    entity.setNickName(nickName);
    repository.persist(entity);

    return new PlayerCreated(entity.getGuid(), entity.getNickName());
  }
}
