package xyz.amricko0b.emkalgo.tablegames.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import xyz.amricko0b.emkalgo.tablegames.dao.jpa.JpaPlayerReport;

@ApplicationScoped
public class PlayerReportRepository implements PanacheRepository<JpaPlayerReport> {

  public List<JpaPlayerReport> getTop(int topSize) {
    return findAll().page(0, topSize).list();
  }
}
