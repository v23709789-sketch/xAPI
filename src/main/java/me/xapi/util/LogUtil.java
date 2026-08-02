package me.xapi.util;

import me.xapi.xAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtil {

    private final Logger logger;

    private LogUtil(Logger logger) {
        this.logger = logger;
    }

    public static LogUtil of(Plugin plugin) {
        return new LogUtil(plugin.getLogger());
    }

    public static LogUtil of() {
        return new LogUtil(xAPI.getInstance().getLogger());
    }

    public void info(String msg) {
        logger.info(ColorUtil.stripColor(msg));
    }

    public void warn(String msg) {
        logger.warning(ColorUtil.stripColor(msg));
    }

    public void error(String msg) {
        logger.severe(ColorUtil.stripColor(msg));
    }

    public void debug(String msg) {
        logger.log(Level.FINE, ColorUtil.stripColor(msg));
    }

    public void console(String msg) {
        Bukkit.getConsoleSender().sendMessage(ColorUtil.color(msg));
    }
}