package xyz.amricko0b.tablegames;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipelinr;
import io.quarkus.arc.All;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import java.util.ArrayList;
import java.util.List;

public class PipelinrBeans {

  @Produces
  @ApplicationScoped
  @SuppressWarnings("rawtypes")
  public Pipelinr pipelinr(@All List<Command.Handler<?, ?>> commandHandlers) {

    List<Command.Handler> ch = new ArrayList<>(commandHandlers);

    return new Pipelinr().with(ch::stream);
  }
}
