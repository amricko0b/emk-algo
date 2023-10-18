package xyz.amricko0b.emkalgo.tablegames.projection;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.factory.Mappers;
import xyz.amricko0b.emkalgo.tablegames.dao.jpa.JpaPlayerReport;
import xyz.amricko0b.emkalgo.tablegames.projection.mapper.PlayerReportMapper;

@Getter
@Setter
@AllArgsConstructor
@RegisterForReflection
public class PlayerReport {

  private static final PlayerReportMapper MAPPER = Mappers.getMapper(PlayerReportMapper.class);

  public static PlayerReport fromJpa(JpaPlayerReport jpa) {
    return MAPPER.createFromJpa(jpa);
  }

  private String nickName;

  private int totalContests;
}
