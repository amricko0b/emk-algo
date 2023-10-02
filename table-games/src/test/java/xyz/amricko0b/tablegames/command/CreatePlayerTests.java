package xyz.amricko0b.tablegames.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import xyz.amricko0b.tablegames.command.event.PlayerCreated;
import xyz.amricko0b.tablegames.command.execption.BadCommandException;

@QuarkusTest
public class CreatePlayerTests extends AbstractCommandTests<CreatePlayer, PlayerCreated> {

  @Test
  @TestTransaction
  void test_create() {
    var command = new CreatePlayer("nagibator777");
    var event = getHandler().handle(command);
    assertEquals(command.nickName(), event.nickName());
    assertNotNull(event.guid());
  }

  @Test
  @TestTransaction
  void test_create_nameEmpty() {
    var command = new CreatePlayer("");
    assertThrows(BadCommandException.class, () -> getHandler().handle(command));
  }

  @Test
  @TestTransaction
  void test_create_nameNull() {
    var command = new CreatePlayer(null);
    assertThrows(BadCommandException.class, () -> getHandler().handle(command));
  }
}
