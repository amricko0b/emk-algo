package xyz.amricko0b.tablegames.restapi;

import an.awesome.pipelinr.Pipelinr;
import jakarta.inject.Inject;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import xyz.amricko0b.tablegames.command.CreateGame;
import xyz.amricko0b.tablegames.restapi.model.RestGame;

@Path("/api/game")
public class GameResource {

  private final Pipelinr pipelinr;

  @Inject
  public GameResource(Pipelinr pipelinr) {
    this.pipelinr = pipelinr;
  }

  @PUT
  @Path("/{title}")
  public RestGame createGame(@PathParam("title") String name) {
    var command = new CreateGame(name);
    var event = command.execute(pipelinr);
    return new RestGame(event);
  }
}
