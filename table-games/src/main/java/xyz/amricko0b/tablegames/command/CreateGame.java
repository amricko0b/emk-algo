package xyz.amricko0b.tablegames.command;

import an.awesome.pipelinr.Command;
import xyz.amricko0b.tablegames.command.event.GameCreated;

public record CreateGame(String title) implements Command<GameCreated> {}
