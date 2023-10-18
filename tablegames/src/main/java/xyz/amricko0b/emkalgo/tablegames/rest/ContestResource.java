package xyz.amricko0b.emkalgo.tablegames.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;
import xyz.amricko0b.emkalgo.tablegames.dao.ContestReportRepository;
import xyz.amricko0b.emkalgo.tablegames.projection.ContestReport;

@Path("/api/v1/contest")
public class ContestResource {

  private final ContestReportRepository repository;

  @Inject
  public ContestResource(ContestReportRepository repository) {
    this.repository = repository;
  }

  @GET
  @Path("/top")
  public List<ContestReport> getGameTopByPlayers() {
    return repository.getTop(10).stream().map(ContestReport::fromJpa).toList();
  }
}
