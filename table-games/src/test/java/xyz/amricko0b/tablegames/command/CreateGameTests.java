package xyz.amricko0b.tablegames.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import xyz.amricko0b.tablegames.command.event.GameCreated;
import xyz.amricko0b.tablegames.command.execption.BadCommandException;

@QuarkusTest
public class CreateGameTests extends AbstractCommandTests<CreateGame, GameCreated> {

  @Test
  @TestTransaction
  void test_create() {
    var command = new CreateGame("Dungeons And Dragons");
    var event = getHandler().handle(command);
    assertEquals(command.title(), event.title());
    assertNotNull(event.guid());
  }

  @Test
  @TestTransaction
  void test_create_nameEmpty() {
    var command = new CreateGame("");
    assertThrows(BadCommandException.class, () -> getHandler().handle(command));
  }

  @Test
  @TestTransaction
  void test_create_nameNull() {
    var command = new CreateGame(null);
    assertThrows(BadCommandException.class, () -> getHandler().handle(command));
  }
}
