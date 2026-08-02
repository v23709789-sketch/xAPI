package me.xapi.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class ConfigUtil {

    public static YamlConfiguration load(Plugin plugin, String fileName) {
        File file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) {
            plugin.saveResource(fileName, false);
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void save(Plugin plugin, YamlConfiguration config, String fileName) {
        try {
            config.save(new File(plugin.getDataFolder(), fileName));
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save " + fileName + ": " + e.getMessage());
        }
    }
}