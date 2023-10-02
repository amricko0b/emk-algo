package xyz.amricko0b.tablegames.command.event;

import java.util.UUID;

/**
 * Событие о созданном игроке
 *
 * @param guid идентификатор игрока
 * @param nickName прозвище
 */
public record PlayerCreated(UUID guid, String nickName) {}
