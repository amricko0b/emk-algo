package xyz.amricko0b.tablegames.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import xyz.amricko0b.tablegames.command.event.GameCreated;

@Getter
@Setter
public class RestGame {

  @JsonProperty(required = true)
  private UUID guid;

  @JsonProperty(required = true)
  private String title;

  public RestGame(GameCreated event) {
    this.guid = event.guid();
    this.title = event.title();
  }
}
