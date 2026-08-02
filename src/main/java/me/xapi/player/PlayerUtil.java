package me.xapi.player;

import me.xapi.util.ColorUtil;
import org.bukkit.entity.Player;

import java.util.Map;

public class PlayerUtil {

    public static void send(Player player, String message) {
        player.sendMessage(ColorUtil.color(message));
    }

    public static void send(Player player, String message, Map<String, String> placeholders) {
        String msg = message;
        for (Map.Entry<String, String> entry : placeholders.entrySet()) {
            msg = msg.replace("{" + entry.getKey() + "}", entry.getValue());
        }
        player.sendMessage(ColorUtil.color(msg));
    }

    public static void actionBar(Player player, String message) {
        player.sendActionBar(ColorUtil.color(message));
    }

    public static void title(Player player, String title, String subtitle) {
        player.sendTitle(ColorUtil.color(title), ColorUtil.color(subtitle), 10, 70, 20);
    }

    public static void heal(Player player) {
        player.setHealth(player.getAttribute(org.bukkit.attribute.Attribute.GENERIC_MAX_HEALTH).getValue());
        player.setFoodLevel(20);
        player.setFireTicks(0);
    }

    public static void clearInventory(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
    }

    public static boolean hasSpace(Player player, int amount) {
        return player.getInventory().firstEmpty() != -1 ||
                player.getInventory().getStorageContents().length - player.getInventory().getStorageContents().length + amount <= 36;
    }
}