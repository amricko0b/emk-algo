package xyz.amricko0b.emkalgo.tablegames.scheduler;

import com.github.javafaker.Faker;
import io.quarkus.logging.Log;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import xyz.amricko0b.emkalgo.tablegames.dao.ContestPlayerRepository;
import xyz.amricko0b.emkalgo.tablegames.dao.ContestRepository;
import xyz.amricko0b.emkalgo.tablegames.dao.jpa.JpaContest;
import xyz.amricko0b.emkalgo.tablegames.dao.jpa.JpaContestPlayer;

@ApplicationScoped
public class PopulatingScheduler {

  private static final List<String> GAME_NAMES =
      List.of(
          "Дюна. Империя",
          "Каркассон",
          "Иниш",
          "Цитадели",
          "Азул",
          "Звёздные Империи",
          "Бумажные Кварталы",
          "7 Чудес: Дуэль",
          "Билет на поезд",
          "Кровь и Ярость",
          "Сквозь Века",
          "Рес Аркана",
          "Кольт Экспресс",
          "Ганзейский союз",
          "Пять племён");

  private static final List<String> NICK_NAMES =
      List.of(
          "}{0тт@8bl4",
          "nagibator777",
          "Принцесса_в_Кедах",
          "Пропiйца",
          "Cinebot",
          "KaldЫrь",
          "kpojiuk",
          "Ananas",
          "b0mzh",
          "amricko0b");

  private static final Faker FAKER = new Faker();

  private final ContestRepository contestRepository;

  private final ContestPlayerRepository contestPlayerRepository;

  @Inject
  public PopulatingScheduler(
      ContestRepository contestRepository, ContestPlayerRepository contestPlayerRepository) {
    this.contestRepository = contestRepository;
    this.contestPlayerRepository = contestPlayerRepository;
  }

  @Scheduled(every = "10s")
  @Transactional(dontRollbackOn = EntityExistsException.class)
  public void addContest() {

    var contest = new JpaContest();

    var randIdx = FAKER.number().numberBetween(0, GAME_NAMES.size() - 1);
    contest.setGameName(GAME_NAMES.get(randIdx));

    var randomPrice = FAKER.number().numberBetween(100, 3000);
    contest.setTicketPrice(BigDecimal.valueOf(randomPrice));

    Log.infof("Adding contest for game %s", contest.getGameName());
    contestRepository.persist(contest);

    var playersCount = FAKER.number().numberBetween(2, 10);
    while (playersCount != 0) {
      var player = new JpaContestPlayer();

      randIdx = FAKER.number().numberBetween(0, NICK_NAMES.size() - 1);
      player.setNickName(NICK_NAMES.get(randIdx));

      player.setContest(contest);

      try {
        Log.infof("Adding player %s for contest %d", player.getNickName(), contest.getId());
        contestPlayerRepository.persistAndFlush(player);
      } catch (EntityExistsException ex) {
        // noop
      } finally {
        playersCount--;
      }
    }
  }
}
