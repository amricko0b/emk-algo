package xyz.amricko0b.emkalgo.tablegames.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import xyz.amricko0b.emkalgo.tablegames.dao.PlayerReportRepository;
import xyz.amricko0b.emkalgo.tablegames.projection.PlayerReport;

@Path("/api/v1/player")
public class PlayerResource {

  private final PlayerReportRepository repository;

  @Inject
  public PlayerResource(PlayerReportRepository repository) {
    this.repository = repository;
  }

  @GET
  @Path("/top")
  public List<PlayerReport> getGameTopByPlayers() {
    return repository.getTop(10).stream().map(PlayerReport::fromJpa).toList();
  }
}
