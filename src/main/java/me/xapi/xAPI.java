package me.xapi;

import org.bukkit.plugin.java.JavaPlugin;

public class xAPI extends JavaPlugin {

    private static xAPI instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("xAPI v" + getDescription().getVersion() + " enabled!");
    }

    @Override
    public void onDisable() {
        instance = null;
        getLogger().info("xAPI disabled!");
    }

    public static xAPI getInstance() {
        return instance;
    }
}