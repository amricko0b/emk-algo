package xyz.amricko0b.tablegames.command;

import an.awesome.pipelinr.Command;
import jakarta.inject.Inject;
import lombok.Getter;

public abstract class AbstractCommandTests<C extends Command<R>, R> {

  @Inject @Getter protected Command.Handler<C, R> handler;
}
