package xyz.amricko0b.emkalgo.tablegames.projection.mapper;

import org.mapstruct.Mapper;
import xyz.amricko0b.emkalgo.tablegames.dao.jpa.JpaPlayerReport;
import xyz.amricko0b.emkalgo.tablegames.projection.PlayerReport;

@Mapper
public interface PlayerReportMapper {

  PlayerReport createFromJpa(JpaPlayerReport contest);
}
