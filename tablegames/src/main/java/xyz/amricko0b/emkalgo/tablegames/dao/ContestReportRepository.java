package xyz.amricko0b.emkalgo.tablegames.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import xyz.amricko0b.emkalgo.tablegames.dao.jpa.JpaContestReport;

@ApplicationScoped
public class ContestReportRepository implements PanacheRepository<JpaContestReport> {

  public List<JpaContestReport> getTop(int topSize) {
    return findAll().page(0, topSize).list();
  }
}
