package xyz.amricko0b.tablegames.command;

import an.awesome.pipelinr.Command;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Objects;
import xyz.amricko0b.tablegames.command.event.GameCreated;
import xyz.amricko0b.tablegames.command.execption.BadCommandException;
import xyz.amricko0b.tablegames.dao.GameRepository;
import xyz.amricko0b.tablegames.dao.jpa.Game;

@ApplicationScoped
public class CreateGameHandler implements Command.Handler<CreateGame, GameCreated> {

  private final GameRepository repository;

  @Inject
  public CreateGameHandler(GameRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional
  public GameCreated handle(CreateGame createGame) {

    var title = createGame.title();
    if (Objects.isNull(title) || title.isBlank()) {
      throw new BadCommandException("Game title must not be null or empty");
    }

    var exists = repository.find("title", createGame.title()).count() != 0;
    if (exists) {
      throw new BadCommandException("Game " + createGame.title() + " already exists!");
    }

    var entity = new Game();
    entity.setTitle(createGame.title());
    repository.persist(entity);

    return new GameCreated(entity.getGuid(), entity.getTitle());
  }
}
