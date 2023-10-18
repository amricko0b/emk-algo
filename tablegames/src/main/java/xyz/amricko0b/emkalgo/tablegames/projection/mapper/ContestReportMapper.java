package xyz.amricko0b.emkalgo.tablegames.projection.mapper;

import org.mapstruct.Mapper;
import xyz.amricko0b.emkalgo.tablegames.dao.jpa.JpaContestReport;
import xyz.amricko0b.emkalgo.tablegames.projection.ContestReport;

@Mapper
public interface ContestReportMapper {

  ContestReport createFromJpa(JpaContestReport contest);
}
