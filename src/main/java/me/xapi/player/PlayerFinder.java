package me.xapi.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class PlayerFinder {

    public static Optional<Player> byName(String name) {
        return Optional.ofNullable(Bukkit.getPlayerExact(name));
    }

    public static Optional<Player> byUuid(UUID uuid) {
        return Optional.ofNullable(Bukkit.getPlayer(uuid));
    }

    public static List<Player> byPermission(String permission) {
        return Bukkit.getOnlinePlayers().stream()
                .filter(p -> p.hasPermission(permission))
                .collect(Collectors.toList());
    }

    public static List<Player> all() {
        return List.copyOf(Bukkit.getOnlinePlayers());
    }

    public static boolean isOnline(String name) {
        return Bukkit.getPlayerExact(name) != null;
    }
}