package xyz.amricko0b.emkalgo.tablegames.projection;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.factory.Mappers;
import xyz.amricko0b.emkalgo.tablegames.dao.jpa.JpaContestReport;
import xyz.amricko0b.emkalgo.tablegames.projection.mapper.ContestReportMapper;

@Getter
@Setter
@AllArgsConstructor
@RegisterForReflection
public class ContestReport {

  private static final ContestReportMapper MAPPER = Mappers.getMapper(ContestReportMapper.class);

  public static ContestReport fromJpa(JpaContestReport jpa) {
    return MAPPER.createFromJpa(jpa);
  }

  private String gameName;

  private int totalPlayers;

  private int totalContests;
}
