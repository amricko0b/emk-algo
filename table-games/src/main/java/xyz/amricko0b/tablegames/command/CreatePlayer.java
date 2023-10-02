package xyz.amricko0b.tablegames.command;

import an.awesome.pipelinr.Command;
import xyz.amricko0b.tablegames.command.event.PlayerCreated;

/**
 * Команда на создание игрока
 *
 * @param nickName прозвище
 */
public record CreatePlayer(String nickName) implements Command<PlayerCreated> {}
